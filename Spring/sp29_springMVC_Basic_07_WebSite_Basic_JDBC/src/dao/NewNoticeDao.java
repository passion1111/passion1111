package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;


import vo.Notice;

public class NewNoticeDao implements NoticeDao {
	
	private JdbcTemplate template;
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	

	public int getCount(String field, String query) throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT COUNT(*) CNT FROM NOTICES WHERE "+field+" LIKE ?";
		
		//쿼리문의 결과가 단일값 (sum() ,max() ,min(), count(*) 
		//return template.queryForInt(sql,"%"+query+"%");
		return template.queryForObject(sql, Integer.class,"%"+query+"%");
	/*	Class.forName("oracle.jdbc.driver.OracleDriver");
		// 1. 접속
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"HR", "1004");
		// 2. 실행
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+query+"%");
		
		// 3. 결과
		ResultSet rs = st.executeQuery();
		rs.next();
		
		int cnt = rs.getInt("cnt");
		
		rs.close();
		st.close();
		con.close();
		
		return cnt;*/
	}
	
	public List<Notice> getNotices(int page, String field, String query) 
			throws ClassNotFoundException, SQLException
	{					
		
		//int srow = 1 + (page-1)*15; // 1, 16, 31, 46, 61, ... an = a1 + (n-1)*d
		//int erow = 15 + (page-1)*15; //15, 30, 45, 60, 75, ...
		
		int srow = 1 + (page-1)*5; // 1, 16, 31, 46, 61, ... an = a1 + (n-1)*d
		int erow = 5 + (page-1)*5; //15, 30, 45, 60, 75, ...
		
		String sql = "SELECT * FROM";
		sql += "(SELECT ROWNUM NUM, N.* FROM (SELECT * FROM NOTICES WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) N)";
		sql += "WHERE NUM BETWEEN ? AND ?";
		
		//객체를 (vo) 객체에 담아서 처리하기
		//query 는 배열로 리턴 (목록 출력하기)
		return template.query(sql, 
						new Object[]{"%"+query+"%" ,srow ,erow}, 
						new BeanPropertyRowMapper<Notice>(Notice.class));
		
		/*// 0. 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 1. 접속
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"HR", "1004");
		// 2. 실행
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+query+"%");
		st.setInt(2, srow);
		st.setInt(3, erow);
		// 3. 결과
		ResultSet rs = st.executeQuery();
		
		List<Notice> list = new ArrayList<Notice>();
		
		while(rs.next()){
			Notice n = new Notice();
			n.setSeq(rs.getString("seq"));
			n.setTitle(rs.getString("title"));
			n.setWriter(rs.getString("writer"));
			n.setRegdate(rs.getDate("regdate"));
			n.setHit(rs.getInt("hit"));
			n.setContent(rs.getString("content"));
			n.setFileSrc(rs.getString("fileSrc"));
			
			list.add(n);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;*/
	}
	
	public int delete(String seq) throws ClassNotFoundException, SQLException
	{
		// 2. 데이터 베이스 연동을 위한 쿼리와 실행 코드 작성
		String sql = "DELETE NOTICES WHERE SEQ=?";
		return template.update(sql, seq);
		/*// 0. 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 1. 접속
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"HR", "1004");
		// 2. 실행
		PreparedStatement st = con.prepareStatement(sql);	
		st.setString(1, seq);
		
		int af = st.executeUpdate();
		
		return af;*/
	}
	
	public int update(Notice notice) throws ClassNotFoundException, SQLException{
		
		// 2. 데이터 베이스를 연동하기 위한 쿼리와 데이터베이스 연동을 위한 코드를 작성
		//String sql = "UPDATE NOTICES SET TITLE=?, CONTENT=?, FILESRC=? WHERE SEQ=?";
		//return template.update(sql, notice.getTitle() , notice.getContent(), 
		//		                    notice.getFileSrc() , notice.getSeq());
		
		//System.out.println(notice.getContent() + "/" + notice.getFileSrc() + "/" +notice.getSeq());
		if(notice.getFile().isEmpty()){notice.setFileSrc("");}
		
		String sql = "UPDATE NOTICES SET CONTENT=?, FILESRC=? WHERE SEQ=?";
		return template.update(sql, notice.getContent(), 
				                    notice.getFileSrc() , notice.getSeq());
		
		// 0. 드라이버 로드
		/*Class.forName("oracle.jdbc.driver.OracleDriver");
		// 1. 접속
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"kingsmile", "oracle");
		// 2. 실행
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, notice.getTitle());
		st.setString(2, notice.getContent());
		st.setString(3, notice.getFileSrc());
		st.setString(4, notice.getSeq());		
		
		int af = st.executeUpdate();
		
		return af;
		*/
	}

	public Notice getNotice(String seq) throws ClassNotFoundException, SQLException
	{
		//쿼리가 실행되기 위한 전제조건 : 드라이버 로드 , 연결설정(연결문자) , 계정 , 비번
		/*
		 *****1단계 처리 (설정정보 처리)
			설정정보가 XML 로 이동 처리 ..... 
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			dataSource.setUsername("HR");
			dataSource.setPassword("1004");
			JdbcTemplate template = new JdbcTemplate();
			template.setDataSource(dataSource);//연결하고 .....
			
			=> xml 설정 IOC 컨테이너 에서 관리하도록 처리
			
		****2단계 위 설저을 xml 도출 하고 처리
		    SELECT * FROM => 실제로는  select title,content 이런 컬럼명 반드시 명시
		    String sql = "SELECT * FROM NOTICES WHERE SEQ="+seq;
		    //template member field setter를 통해서 주소를 얻어온다
			//SELECT * FROM NOTICES ..........................
			return template.queryForObject(sql,ParameterizedBeanPropertyRowMapper.newInstance(Notice.class));
		    //RowMapper => 커리 결과(SELECT * FROM NOTICES) => 단 setter 구동하기 위한 아래코드를 자동 실행   	
		
		
		****3단계 (2단계의 불만사항) => 
		    preparestatement 기능 ( 파라메터 ? )
		    
		****4단계 (컬럼명과 DTO객체 memberfield 이름이 같이 않을 경우 (자동 매핑 불가)
		//만약에 컬럼명과 Notice가지고 있는 멤버필드명 일치하지 않다면 
		//RowMapper<T> 인터페이스 사용 작업
		//RowMapper 구현하는 클래스만들고 
		//일외용 클래스 : 익명클래스 (이름이 없다)
		/	return template.queryForObject(sql,
				        new Object[]{seq},
				        new RowMapper<Notice>(){
							@Override
							public Notice mapRow(ResultSet rs, int rownum)
									throws SQLException {
								Notice n = new Notice();
								//DB컬럼명 num -> notice seq
								n.setSeq(rs.getString("num"));  //실제 num  -> class seq 자동매핑 불가
								n.setTitle(rs.getString("title2"));
								n.setWriter(rs.getString("w"));
								n.setRegdate(rs.getDate("regdate"));
								n.setHit(rs.getInt("hit"));
								n.setContent(rs.getString("content"));
								n.setFileSrc(rs.getString("fileSrc")); 
								return n;
							}
			
		});    
		*/
		//String sql = "SELECT * FROM NOTICES WHERE SEQ=?";
		//Object[]{seq} 파라미터 값을 순서대로 설정하기
		//return template.queryForObject(sql,
		//		        new Object[]{seq},
				        //ParameterizedBeanPropertyRowMapper 반환할 Type설정시
		//		        ParameterizedBeanPropertyRowMapper.newInstance(Notice.class));
		//RowMapper => 커리 결과(SELECT * FROM NOTICES) => 단 setter 구동하기 위한 아래코드를 자동 실행   
		/*
				Notice n = new Notice();
				n.setSeq(rs.getString("seq"));
				n.setTitle(rs.getString("title"));
				n.setWriter(rs.getString("writer"));
				n.setRegdate(rs.getDate("regdate"));
				n.setHit(rs.getInt("hit"));
				n.setContent(rs.getString("content"));
				n.setFileSrc(rs.getString("fileSrc")); 
		 */
		
		
		
		
		/*// 0. 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 1. 접속
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"HR", "1004");
		// 2. 실행
		Statement st = con.createStatement();
		// 3. 결과
		ResultSet rs = st.executeQuery(sql);
		rs.next();
		
		Notice n = new Notice();
		n.setSeq(rs.getString("seq"));
		n.setTitle(rs.getString("title"));
		n.setWriter(rs.getString("writer"));
		n.setRegdate(rs.getDate("regdate"));
		n.setHit(rs.getInt("hit"));
		n.setContent(rs.getString("content"));
		n.setFileSrc(rs.getString("fileSrc"));
		
		rs.close();
		st.close();
		con.close();
		
		return n;*/
		
		/*
		확인하자
		String sql = "SELECT * FROM NOTICES WHERE SEQ="+seq;
		 try {
	           return this.template.queryForObject(sql, new BeanPropertyRowMapper<Notice>(Notice.class),sql);
	         } catch (EmptyResultDataAccessException e) {
	            // EmptyResultDataAccessException 예외 발생시 null 리턴
	            return null;
	         }*/
		String sql = "SELECT * FROM NOTICES WHERE SEQ=?";
		//Object[]{seq} 파라미터 값을 순서대로 설정하기
		return template.queryForObject(sql,
				        new Object[]{seq},
				        //ParameterizedBeanPropertyRowMapper 반환할 Type설정시
				        ParameterizedBeanPropertyRowMapper.newInstance(Notice.class));
	}

	public int insert(Notice n) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println(n.getFileSrc() + "/" + n.getFileSrc2());
		String sql = "INSERT INTO NOTICES" +
				     "(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC ,FILESRC2 ) " +
				     "VALUES( (SELECT MAX(TO_NUMBER(SEQ))+1 FROM NOTICES), ?, ?, 'kosta', SYSDATE, 0, ? , ?)";
		//DML (Insert , Update, Delete)
		//update return result => 영향 받은 행의 개수
		return template.update(sql, n.getTitle(),n.getContent(),n.getFileSrc(),n.getFileSrc2());
		/*// 0. 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 1. 접속
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"HR", "1004");
		// 2. 실행
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, n.getTitle());
		st.setString(2, n.getContent());
		st.setString(3, n.getFileSrc());
		
		int af = st.executeUpdate();
		
		st.close();
		con.close();
		
		return af;*/
	}
}
