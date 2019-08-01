package edu.kosta.boardModel;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dbclose.util.CloseUtil;

public class BoardDAO {  // controller
	
	private static BoardDAO instance = new BoardDAO();	// 한번만 객체를 생성하여 모든 클라이언트들이 공유
	
	public static BoardDAO getInstance(){
		return instance;
	}// getInstance()
	
	// 생성자
	public BoardDAO(){}  
		
	// DB연결
	public Connection getConnection() throws Exception{
		// 연결은 JNDI & POLL 형태로 연결 객체 생성해서 리턴
		Context ctx = new InitialContext();
		//Context env = (Context)ctx.lookup("java:comp/env");
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc:BoardDB");	
		//DBMS 에러를 찾는데 도움
		DriverManager.setLogWriter(new PrintWriter(System.out));
		
		return ds.getConnection();
	}// getConnection();
	
	//insert(vo) method - 새로운 글을 게시판에 추가, 글 입력 처리에 사용
	public int insert(BoardVO vo) {
		Connection conn = null ;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//답변 글인지 일반(새 게시글)인지 구분해서 입력 시키는 로직
		int num = vo.getNum();				//내부적 부모 글번호
		int ref = vo.getRef();					//부모의 ref(그룹 번호)
		int re_step = vo.getRe_step();		//부모의 그룹내 순서
		int re_level = vo.getRe_level();		//부모의 그룹내 레벨
		int number = 0;							// board 테이블에 들어갈 번호
		StringBuffer sb = new StringBuffer();
		
		try {
			conn = getConnection();
			//현재 board 테이블에 레코드 유무 판단과 글 번호 지정
			pstmt = conn.prepareStatement("SELECT MAX(NUM) FROM BOARD");
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				number = rs.getInt(1) + 1;     // 1 : num , 다음 글 번호는 가장 큰 번호 + 1 
			} else {
				number = 1;
			} // if end
			
			//제목글과 답변글 간의 순서 결정
			if( num != 0 ) {  //답변글
				re_level = re_level + 1;
				
				pstmt = conn.prepareStatement(
						"SELECT MAX(RE_STEP) FROM BOARD WHERE REF = ? AND RE_LEVEL = ? ");
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_level);
				rs = pstmt.executeQuery();
				
				if( rs.next() ) {
					if( re_step == 0 ) {
						re_step = rs.getInt(1) + 1;
					}
				} else {
					re_step = 0; 			// 첫번째 글
				} // in if end
				
			} else {				// 부모글인 경우 글번호 없음
				ref= number;
				re_step = 0;
				re_level = 0;
			} // out if end
			
			//insert 명령 처리
			sb.append("INSERT INTO BOARD(NUM, WRITER, SUBJECT, EMAIL, CONTENT, PASSWD, REG_DATE, ");
			sb.append(" REF, RE_STEP, RE_LEVEL, IP) VALUES(BOARD_NUM.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getSubject());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getContent());
			pstmt.setString(5, vo.getPasswd());
			pstmt.setTimestamp(6, vo.getReg_date());
			
			pstmt.setInt(7, ref);
			pstmt.setInt(8, re_step);
			pstmt.setInt(9, re_level);
			pstmt.setString(10, vo.getIp());			
			
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(rs);			CloseUtil.close(pstmt);			CloseUtil.close(conn);
		}	
		return 0;
	} // insert() end
	
	//getListAllCount() : list.jsp 페이지에서 사용할 레코드 갯수 얻어오는 메소드
	public int getListAllCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			conn = getConnection();
			
			//현재 board 테이블의 레코드 수 구하기
			pstmt = conn.prepareStatement("SELECT COUNT(*) FROM BOARD" );
			rs = pstmt.executeQuery();
			
			if( rs.next() ) count = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(rs);			CloseUtil.close(pstmt);			CloseUtil.close(conn);
		}	
		return count;
	} // getListAllCount() end
	
	//getSelectAll(startRow, endRow) : list.jsp 에서 사용할 전체 레코드 출력 메소드
	public List<BoardVO> getSelectAll( int start,  int end ) {
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		List  list = null;
		
		try {
			conn = getConnection();
			StringBuffer  sb = new StringBuffer();
			// 방법 3>
			//sb.append("SELECT j.* FROM (	SELECT k.*, rownum r FROM( SELECT * FROM board ORDER BY ref desc, re_step asc	) k ) j WHERE j.r BETWEEN ? AND ?");
			
			// 방법 2>
			//sb.append("select * from (select rownum as r,  x.*   from (select *  from board  order by ref desc, re_step asc)  x ) where r BETWEEN ? and ?");
			
			//방법 1>
			/*sb.append("SELECT NUM, WRITER, EMAIL, SUBJECT, PASSWD, REG_DATE, REF, RE_STEP, RE_LEVEL, CONTENT, IP, READCOUNT, R ");
			sb.append("FROM(SELECT NUM, WRITER, EMAIL, SUBJECT, PASSWD, REG_DATE, REF, RE_STEP, RE_LEVEL, CONTENT, IP, READCOUNT, ROWNUM R ");
			sb.append("FROM(SELECT NUM, WRITER, EMAIL, SUBJECT, PASSWD, REG_DATE, REF, RE_STEP, RE_LEVEL, CONTENT, IP, READCOUNT ");
			sb.append("FROM BOARD ORDER BY REF DESC, RE_STEP ASC, re_level ) ORDER BY REF DESC,  re_step asc, re_level asc, reg_date asc) WHERE R>=? AND R<=?");*/
			
			//방법 4>
			/*sb.append("SELECT NUM, WRITER, EMAIL, SUBJECT, PASSWD, REG_DATE, REF, RE_STEP, RE_LEVEL, CONTENT, IP, READCOUNT, R ");
			sb.append("FROM(SELECT NUM, WRITER, EMAIL, SUBJECT, PASSWD, REG_DATE, REF, RE_STEP, RE_LEVEL, CONTENT, IP, READCOUNT, ROWNUM R ");
			sb.append("FROM(SELECT NUM, WRITER, EMAIL, SUBJECT, PASSWD, REG_DATE, REF, RE_STEP, RE_LEVEL, CONTENT, IP, READCOUNT ");
			sb.append("FROM BOARD GROUP BY NUM, WRITER, EMAIL, SUBJECT, PASSWD, REG_DATE, REF, RE_STEP, RE_LEVEL, CONTENT, IP, READCOUNT ORDER BY REF DESC, RE_STEP ASC) ");
			sb.append("ORDER BY REF DESC, RE_STEP ASC, RE_LEVEL DESC, REG_DATE asc) WHERE R>=? AND R<=? ORDER BY R asc ");*/
			
			// 수정 했음
			sb.append("SELECT NUM, WRITER, EMAIL, SUBJECT, PASSWD, REG_DATE, REF, RE_STEP, RE_LEVEL, CONTENT, IP, READCOUNT, R ");
			sb.append("FROM(SELECT NUM, WRITER, EMAIL, SUBJECT, PASSWD, REG_DATE, REF, RE_STEP, RE_LEVEL, CONTENT, IP, READCOUNT, ROWNUM R ");
			sb.append("FROM(SELECT NUM, WRITER, EMAIL, SUBJECT, PASSWD, REG_DATE, REF, RE_STEP, RE_LEVEL, CONTENT, IP, READCOUNT ");
			sb.append("FROM BOARD ORDER BY REF DESC, RE_STEP ASC) ORDER BY REF DESC,  re_step asc, re_level asc, reg_date asc) WHERE R>=? AND R<=?");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				list = new ArrayList(end);
				
				do {
					BoardVO vo = new BoardVO();
					vo.setNum(rs.getInt("num"));
					vo.setWriter(rs.getString("writer"));
					
					vo.setEmail(rs.getString("email"));
					vo.setSubject(rs.getString("subject"));
					vo.setPasswd(rs.getString("passwd"));
					vo.setReg_date(rs.getTimestamp("reg_date"));
					
					vo.setReadcount(rs.getInt("readcount"));
					vo.setRef(rs.getInt("ref"));
					vo.setRe_level(rs.getInt("re_level"));
					vo.setRe_step(rs.getInt("re_step"));
					
					vo.setIp(rs.getString("ip"));
					vo.setContent(rs.getString("content"));
					
					// list 객체에 데이터 저장 Bean인 BoardVO 객체에 저장한다.
					list.add(vo);
					
				} while( rs.next() ) ;	
			} // if end
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(rs);			CloseUtil.close(pstmt);			CloseUtil.close(conn);
		}				
		return list;
	} // getSelectAll(startRow, endRow) end
	
	// getDataDetail( num ) - content.jsp 상세보기 페이지
	// num 에 해당하는 레코드를 board 테이블에서 검색함
	public BoardVO getDataDetail( int num ) {
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		BoardVO vo = null;
		String sql = "";
		
		try {
			conn = getConnection();
			//조회수 증가
			sql = "UPDATE BOARD SET READCOUNT = READCOUNT + 1 WHERE NUM = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeQuery();
			
			pstmt = conn.prepareStatement("SELECT * FROM BOARD WHERE NUM = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setWriter(rs.getString("writer"));	
				vo.setEmail(rs.getString("email"));
				vo.setSubject(rs.getString("subject"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setReg_date(rs.getTimestamp("reg_date"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setRef(rs.getInt("ref"));
				vo.setRe_level(rs.getInt("re_level"));
				vo.setRe_step(rs.getInt("re_step"));
				vo.setIp(rs.getString("ip"));
				vo.setContent(rs.getString("content"));
			} // if end			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(rs);			CloseUtil.close(pstmt);			CloseUtil.close(conn);
		}			
		return vo;
	} // getDataDetail() end
	
	// update(num) - 업데이트시 사용하는 메소드
	public BoardVO  update( int num ) {
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		BoardVO vo = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM BOARD WHERE NUM = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setWriter(rs.getString("writer"));	
				vo.setEmail(rs.getString("email"));
				vo.setSubject(rs.getString("subject"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setReg_date(rs.getTimestamp("reg_date"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setRef(rs.getInt("ref"));
				vo.setRe_level(rs.getInt("re_level"));
				vo.setRe_step(rs.getInt("re_step"));
				vo.setIp(rs.getString("ip"));
				vo.setContent(rs.getString("content"));
			} // if end
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(rs);			CloseUtil.close(pstmt);			CloseUtil.close(conn);
		}				
		return vo;
	} // update(num) end
	
	//update(vo) - 글수정시 처리 메소드 <=== updatePro.jsp 에서 사용
	public int update(BoardVO vo) {
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		String dbpasswd = "";
		String sql = "";
		int result = -1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("SELECT PASSWD FROM BOARD WHERE NUM = ?");
			pstmt.setInt(1, vo.getNum());
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				dbpasswd = rs.getString("passwd");
				
				if( dbpasswd.equals(vo.getPasswd())) {
					sql = "UPDATE BOARD SET WRITER=?, EMAIL=?, SUBJECT=?, PASSWD=? ";
					sql += " ,CONTENT = ? WHERE NUM = ?";
					
					System.out.println(sql);
					
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, vo.getWriter());
					pstmt.setString(2, vo.getEmail());
					pstmt.setString(3, vo.getSubject());
					pstmt.setString(4, vo.getPasswd());
					pstmt.setString(5, vo.getContent());
					pstmt.setInt(6, vo.getNum());
					
					pstmt.executeUpdate();
					result = 1;
					
				} else {
					result = 0;
				} // in if end
			} // out if end
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(rs);			CloseUtil.close(pstmt);			CloseUtil.close(conn);
		}					
		return result;
	} // update() end	
	
	//delete( num, passwd ) - deletePro.jsp
	public int delete(int num, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		String dbpasswd = "";
		int result = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("SELECT PASSWD FROM BOARD WHERE NUM=?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				dbpasswd = rs.getString("passwd");
				
				if( dbpasswd.equals(passwd) ) {
					pstmt = conn.prepareStatement("DELETE FROM BOARD WHERE NUM = ?");
					pstmt.setInt(1, num);
					result = pstmt.executeUpdate();
					result = 1;   // 글삭제 성공
					
				} else 	result = 0;  // 비밀번호 틀림
			} // out if end	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(rs);			CloseUtil.close(pstmt);			CloseUtil.close(conn);
		}					
		return result;
	} // delete() end
}








