//package edu.bit.board;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.sql.DataSource;
//
//
//public class BoardDAO {  //Controller
//	
//	private static BoardDAO instance = new BoardDAO();
//	
//	public static BoardDAO getInstance() {
//		return instance;
//	}
//	
//	private BoardDAO() { }  // useBean 태그로 객체 생성하면~
//	
//	public Connection getConnection() throws Exception {
//		// 연결은 JNDI * Pool 형태로 연결 객체 생성해서 리턴할것
//		Context initCtx = new InitialContext();
//
//		DataSource  ds = 
//			(DataSource)initCtx.lookup("java:comp/env/jdbc:BoardDB");
//		
//		return ds.getConnection();
//	}//getConnection() end
//	
//	//insert(vo) method - 새로운 글을 게시판에 추가, 글 입력처리에 사용
//	public int insert(BoardVO vo) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		//답변 글인지 일반(새글)인지 구분해서 입력 시키는 로직
//		int num = vo.getNum();	//내부적 부모 글번호
//		int ref = vo.getRef();  //부모의 ref(그룹번호)
//		int re_step = vo.getRe_step();  //부모의 그룹 내 순서
//		int re_level = vo.getRe_level(); //부모의 re_level
//		int number = 0;   // board 테이블에 들어갈 번호
//		StringBuffer sb = new StringBuffer();
//		
//		try {
//			conn = getConnection();
//			//현재 board 테이블에 레코드 유무 판단과 글 번호 지정
//			pstmt = conn.prepareStatement("SELECT MAX(NUM) FROM BOARD");
//			rs = pstmt.executeQuery();
//			
//			if( rs.next() ) {
//				number = rs.getInt(1) + 1; // 1 : num, 다음 글 번호는 가장 큰번호 + 1
//			}else {
//				number = 1;   //첫번째 글
//			}
//			
//			//제목글과 답변글 간의 순서 결정
//			if( num != 0 ) {   // 답변글
//				re_level = re_level + 1;
//				String sql = "SELECT MAX(RE_STEP) FROM BOARD WHERE REF= ? AND RE_LEVEL = ?";
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setInt(1, ref);
//				pstmt.setInt(2, re_level);
//				rs = pstmt.executeQuery();
//				
//				if( rs.next() ) {
//					if( re_step == 0 ) re_step = rs.getInt(1) + 1;
//					// code 확인 할것!
//				}else {
//					re_step = 0;     //첫번째 글
//				} // in if end				
//				
//			}else {
//				ref = number;
//				re_step = 0;
//				re_level = 0;
//			} //out if end
//			
//			// insert 처리 명령
//			sb.append("insert into board(num, writer, subject, ");
//			sb.append("email, content, passwd, reg_date, ref, re_step,");
//			sb.append("re_level, ip) values(board_num.nextval,?,?,?,?,?,?,?,?,?,?)");
//			
//			//System.out.println(sb.toString());
//			
//			pstmt = conn.prepareStatement(sb.toString());
//			pstmt.setString(1, vo.getWriter());
//			pstmt.setString(2, vo.getSubject());
//			pstmt.setString(3, vo.getEmail());
//			pstmt.setString(4, vo.getContent());
//			pstmt.setString(5, vo.getPasswd());
//			pstmt.setTimestamp(6, vo.getReg_date());
//			
//			pstmt.setInt(7, ref);
//			pstmt.setInt(8, re_step);
//			pstmt.setInt(9, re_level);
//			pstmt.setString(10, vo.getIp());
//			
//			pstmt.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			
//		} // try end
//		
//		return 0;
//	}//insert() end
//	
//	//getListAllCount() : list.jsp 페이지에서 사용할 레코드 갯수 얻어오는 함수
//	public int getListAllCount() {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int count = 0;
//		
//		try {
//			conn = getConnection();
//			
//			//현재 board 테이블의 레코드 수 구하기
//			pstmt = conn.prepareStatement("SELECT COUNT(*) FROM BOARD");
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) count = rs.getInt(1);  
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			
//		} //end try
//		
//		return count;
//	} //getListAllCount() end
//	
//	//getSelectAll(start, end) : list.jsp에서 사용
//	public List<BoardVO> getSelectAll(int start, int end) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		List list = null;
//		
//		try {
//			conn = getConnection();
//			StringBuffer sb = new StringBuffer();
//			
//			// 방법 3>
//			//sb.append("SELECT j.* FROM (	SELECT k.*, rownum r FROM( SELECT * FROM board ORDER BY ref desc, re_step asc	) k ) j WHERE j.r BETWEEN ? AND ?");
//			
//			// 방법 2>
//			//sb.append("select * from (select rownum as r,  x.*   from (select *  from board  order by ref desc, re_step asc)  x ) where r BETWEEN ? and ?");
//			
//			//방법 1>
//			/*sb.append("SELECT NUM, WRITER, EMAIL, SUBJECT, PASSWD, REG_DATE, REF, RE_STEP, RE_LEVEL, CONTENT, IP, READCOUNT, R ");
//			sb.append("FROM(SELECT NUM, WRITER, EMAIL, SUBJECT, PASSWD, REG_DATE, REF, RE_STEP, RE_LEVEL, CONTENT, IP, READCOUNT, ROWNUM R ");
//			sb.append("FROM(SELECT NUM, WRITER, EMAIL, SUBJECT, PASSWD, REG_DATE, REF, RE_STEP, RE_LEVEL, CONTENT, IP, READCOUNT ");
//			sb.append("FROM BOARD ORDER BY REF DESC, RE_STEP ASC, re_level ) ORDER BY REF DESC,  re_step asc, re_level asc, reg_date asc) WHERE R>=? AND R<=?");*/
//						
//						
//			/*
//			 * select num, writer, email, subject, passwd, reg_date, ref, re_step, re_level,
//			 * content, ip, readcount, r from(select num, writer, email, subject, passwd,
//			 * reg_date, ref, re_step, re_level, content, ip, readcount, rownum r
//			 * from(select num, writer, email, subject, passwd, reg_date, ref, re_step,
//			 * re_level, content, ip, readcount from board order by ref desc, re_step asc)
//			 * order by ref desc, re_step asc, re_level asc, reg_date asc) where r>=1 and
//			 * r<=50;
//			 */
//			//방법 4>
//			sb.append("select num, writer, email, subject, passwd, reg_date, ref, re_step, re_level,");
//			sb.append("content, ip, readcount, r from(select num, writer, email, subject, passwd,");
//			sb.append("reg_date, ref, re_step, re_level, content, ip, readcount, rownum r  ");
//			sb.append("from(select num, writer, email, subject, passwd, reg_date, ref, re_step,");
//			sb.append("re_level, content, ip, readcount from board order by ref desc, re_step asc)");
//			sb.append("order by ref desc, re_step asc, re_level asc, reg_date asc) where r>=? and r<=?");
//			
//			//System.out.println(sb.toString());
//			
//			pstmt = conn.prepareStatement(sb.toString());
//			pstmt.setInt(1, start);
//			pstmt.setInt(2, end);
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				list = new ArrayList(end);
//				
//				do {
//					BoardVO vo = new BoardVO();
//					vo.setNum(rs.getInt("num"));
//					vo.setWriter(rs.getString("writer"));
//					vo.setEmail(rs.getString("email"));
//					vo.setSubject(rs.getString("subject"));
//					vo.setPasswd(rs.getString("passwd"));
//					vo.setReg_date(rs.getTimestamp("reg_date"));
//					vo.setReadcount(rs.getInt("readcount"));
//					vo.setRef(rs.getInt("ref"));
//					vo.setRe_level(rs.getInt("re_level"));
//					vo.setRe_step(rs.getInt("re_step"));
//					vo.setIp(rs.getString("ip"));
//					vo.setContent(rs.getString("content"));
//					
//					//list 객체에 데이터 저장빈인 BoardVO 객체에 저장
//					list.add(vo);
//					
//				}while(rs.next());		
//			} //end if
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			
//		}
//		return list;
//	} //getSelectAll() end
//
//}
//
//
//
//
//












//-----------------------에러 원인 찾기










package edu.bit.board;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class BoardDAO {
	public static BoardDAO instance=new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	private BoardDAO() {}
	public static Connection getConnection() throws Exception{
		//JNDI기재하기.
//		Context initCtx=new InitialContext();
//		Context envCtx=(Context)initCtx.lookup("java:comp/env");
//		DataSource ds=(DataSource)envCtx.lookup("jdbc:MemberDB");
		
		Context initCtx=new InitialContext();
//		Context envCtx=(Context)initCtx.lookup("java:comp/env");
		DataSource ds=(DataSource)initCtx.lookup("java:comp/env/jdbc:BoardDB");
	
		Connection conn=ds.getConnection();
		
		return conn;
	}
	
	//insert(VO)--새로운글을 게시판에 추가 글 입력 처리에 사용
	public int insert(BoardVO vo)  throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		//답변 글인지 일반(새글인지 판단)인지 판단
		int num=vo.getNum();
		int ref=vo.getRef();  //부모의 ref(그룹번호)
		int re_step=vo.getRe_step(); //부모의 ref(그룹내 레벨)
		int re_level=vo.getRe_level();//부모의 re_level
		int number=0;
		StringBuffer sb=new StringBuffer();
		try {
			conn=getConnection();
			//현재 board 테이블에 레코드 유무 판단과 글 번호 지정.
			pstmt=conn.prepareStatement("select max(num) from board");
					rs=pstmt.executeQuery();
					
					if(rs.next()) {
						number=rs.getInt(1)+1;//1:num,다음글 번호는 가장 
					}else {
						number=1;
					}
					//제목글과 답변글 간의 순서 결정
					if(num!=0) {//답변글
						re_level=re_level+1;
						String sql="select max(re_step) from board where ref=? and re_level=?";
						pstmt=conn.prepareStatement(sql);
						pstmt.setInt(1, ref);
						pstmt.setInt(2, re_level);
						rs=pstmt.executeQuery();
						if(rs.next()) {
							if(re_step==0) re_step=rs.getInt(1)+1;
						}else {
							re_step=0;//첫번쨰 글
						}
						
					}else {
						ref=number;
						re_step=0;
						re_level=0;
						
					}//out if end
					
					//insert 처리 명령
					sb.append("insert into board(num, writer, subject, email, content, passwd, reg_date, ref, re_step, re_level, ip) ");
					sb.append("values(board_num.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
					pstmt=conn.prepareStatement(sb.toString());
					pstmt.setString(1, vo.getWriter());
					pstmt.setString(2, vo.getSubject());
					pstmt.setString(3, vo.getEmail());
					pstmt.setString(4, vo.getContent());
					pstmt.setString(5, vo.getPasswd());
					pstmt.setTimestamp(6, vo.getReg_date());
					pstmt.setInt(7, vo.getRef());
					pstmt.setInt(8, vo.getRe_step());
					pstmt.setInt(9, vo.getRe_level());
					pstmt.setString(10, vo.getIp());
					pstmt.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			
			
		}
	
		
		
		return 0;  //문제없으면 0
	}
	
	//전체개수를 얻어오는 메서드:list.jsp페이지에서 사용할 레코드 갯수 얻어오기
	public int getListAllCount() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("select count(writer) from board");
			rs=pstmt.executeQuery();
			while(rs.next()) {	count=rs.getInt(1);			}
		} catch (Exception e) {
			e.printStackTrace();
		
		}finally {
			
		}
		
		return count;
	}
	
	//getSelectAll(start,end):list.jsp에서 사용
	public List<BoardVO> getSelectAll(int start, int end) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List list = null;
		
		try {
			conn = getConnection();
			StringBuffer sb = new StringBuffer();
			
			/*
			 * select num, writer, email, subject, passwd, reg_date, ref, re_step, re_level,
			 * content, ip, readcount, r from(select num, writer, email, subject, passwd,
			 * reg_date, ref, re_step, re_level, content, ip, readcount, rownum r
			 * from(select num, writer, email, subject, passwd, reg_date, ref, re_step,
			 * re_level, content, ip, readcount from board order by ref desc, re_step asc)
			 * order by ref desc, re_step asc, re_level asc, reg_date asc) where r>=1 and
			 * r<=50;
			 */
			
			sb.append("select num, writer, email, subject, passwd, reg_date, ref, re_step, re_level,");
			sb.append("content, ip, readcount, r from(select num, writer, email, subject, passwd,");
			sb.append("reg_date, ref, re_step, re_level, content, ip, readcount, rownum r ");
			sb.append("from(select num, writer, email, subject, passwd, reg_date, ref, re_step,");
			sb.append("re_level, content, ip, readcount from board order by ref desc, re_step asc)");
			sb.append("order by ref desc, re_step asc, re_level asc, reg_date asc) where r>=? and r<=?");
			
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs=pstmt.executeQuery();
			System.out.println("ddd");
			if(rs.next()) {
				list=new ArrayList(end);//이것만큼 arraylist를 늘려라.
				
				do {
					BoardVO vo=new BoardVO();
					
					

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
					
					list.add(vo);
				}while(rs.next());
			}//end if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return list;
	} //getSelectAll() end
}
