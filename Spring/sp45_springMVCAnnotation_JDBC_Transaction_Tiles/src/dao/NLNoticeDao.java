package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
/////////////////////////////JDBCTemplate////////////////////////////////
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
/////////////////////////////////////////////////////////////
import vo.Notice;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;
public class NLNoticeDao  extends SimpleJdbcDaoSupport implements NoticeDao{
	
	//기본 Spring 트랜잭션 
	//transactionManager 스프링이 제공하는 트랜잭션 객체(DataSourceTransactionManager)
		
	/*
	   **2단계  처리 
		private TransactionTemplate  transactionTemplate;
		public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	*/
	/*
	    **1단계 처리 *********************************************************
		private PlatformTransactionManager  transactionManager;
		public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}*/

	
	
	//extends JdbcDaoSupport 클래스안 setter 구성 dataSource xml 잡아주다
	//jdk1.5 이상 가장 큰 변화
	//Spring 제공 => SimpleJDBCTemplate(확장기능)
	//List<notice> 
	// ? 파라메터 => 명명된 이름 순서 ->  ? , ? , ?  (a,b,c) ->
	//           => 순서에 상관없이 사용
	
	
	//Template 관련 setter 구성
    /*	
		이런 식으로  JdbcTemplate 의 주소를 얻어 올려면  Spring 에서
		xml NoticeDao객체 IOC컨테이너에 올라갈때 JdbcTemplate의 주소를 가지고
		가록 property를 통해서 구현
		
		private JdbcTemplate template;
		public void setTemplate(JdbcTemplate template) {
			this.template = template;
		}
	*/
	//xml의 설정의 통해서 template 객체의 주소를 가지고 오기
	///////////////////////////////////////////////////

	


	public int getCount(String field, String query) throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT COUNT(*) CNT FROM TNOTICES WHERE "+field+" LIKE ?";
		
		
		//쿼리문의 결과가 단일값 (sum() ,max() ,min(), count(*) 
		return getSimpleJdbcTemplate().queryForInt(sql,"%"+query+"%");
		
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
	
	public List<Notice> getNotices(int page, String field, String query) throws ClassNotFoundException, SQLException
	{					
		
		//int srow = 1 + (page-1)*15; // 1, 16, 31, 46, 61, ... an = a1 + (n-1)*d
		//int erow = 15 + (page-1)*15; //15, 30, 45, 60, 75, ...
		
		int srow = 1 + (page-1)*5; // 1, 16, 31, 46, 61, ... an = a1 + (n-1)*d
		int erow = 5 + (page-1)*5; //15, 30, 45, 60, 75, ...
		
		String sql = "SELECT * FROM";
		sql += "(SELECT ROWNUM NUM, N.* FROM (SELECT * FROM TNOTICES WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) N)";
		sql += "WHERE NUM BETWEEN ? AND ?";
		
		//객체를 (vo) 객체에 담아서 처리하기
		//query 는 배열로 리턴 (목록 출력하기)
		//return getSimpleJdbcTemplate().query(sql, 
		//				new Object[]{"%"+query+"%" ,srow ,erow}, 
		//				new BeanPropertyRowMapper<Notice>(Notice.class));
		
		return getSimpleJdbcTemplate().query(sql,
								new BeanPropertyRowMapper<Notice>(Notice.class)  
								,"%"+query+"%" ,srow ,erow);
		
		
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
		String sql = "DELETE TNOTICES WHERE SEQ=?";
		return getSimpleJdbcTemplate().update(sql, seq);
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
		
		String sql = "UPDATE TNOTICES SET CONTENT=?, FILESRC=? WHERE SEQ=?";
		return getSimpleJdbcTemplate().update(sql, notice.getContent(), 
				                    notice.getFileSrc() , notice.getSeq());
		
		// 0. 드라이버 로드
		/*Class.forName("oracle.jdbc.driver.OracleDriver");
		// 1. 접속
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"HR", "1004");
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
			
		****2단계 위 설저을 xml 도출 하고 처리
		    String sql = "SELECT * FROM NOTICES WHERE SEQ="+seq;
		    //template member field setter를 통해서 주소를 얻어온다
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
								n.setSeq(rs.getString("num"));
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
		String sql = "SELECT * FROM TNOTICES WHERE SEQ=?";
		//Object[]{seq} 파라미터 값을 순서대로 설정하기
		return getSimpleJdbcTemplate().queryForObject(sql, 
				new BeanPropertyRowMapper<Notice>(Notice.class), 
				seq);
		
		
		//return getSimpleJdbcTemplate().queryForObject(sql,
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
	}
    
	public int insert(Notice n) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO TNOTICES" +
				     "(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC) " +
				     "VALUES( (SELECT NVL(MAX(TO_NUMBER(SEQ)),0)+1 FROM TNOTICES)," +
				     ":title, :content, 'kosta', SYSDATE, 0, :fileSrc)";
	    return getSimpleJdbcTemplate().update(sql, 
	    		new BeanPropertySqlParameterSource(n));	
	}
	/*어노테이션 설정*/
	@Transactional
	public void InsertAndPointOfMember( Notice n , String id){
	  	String sql = "INSERT INTO TNOTICES" +
			     "(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC) " +
			     "VALUES( (SELECT NVL(MAX(TO_NUMBER(SEQ)),0)+1 FROM TNOTICES)," +
			     ":title, :content, 'kosta', SYSDATE, 0, :fileSrc)";
	  	String sql2 = "UPDATE TMEMBER SET POINT = POINT+1 WHERE ID=?";
		try{
			getSimpleJdbcTemplate().update(sql,	new BeanPropertySqlParameterSource(n));	
			getSimpleJdbcTemplate().update(sql2,id);				
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		/*
		*****************1단계  처리 방법**********************************  
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try{
			getSimpleJdbcTemplate().update(sql,	new BeanPropertySqlParameterSource(n));	
			getSimpleJdbcTemplate().update(sql2,id);
			transactionManager.commit(status);
		}catch(DataAccessException ex){
			transactionManager.rollback(status);
			//System.out.println(ex.getMessage());
			throw ex;
		}
		
		*************2단계 **************************************************
		  final	String sql = "INSERT INTO TNOTICES" +
			     "(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC) " +
			     "VALUES( (SELECT NVL(MAX(TO_NUMBER(SEQ)),0)+1 FROM TNOTICES)," +
			     ":title, :content, 'kosta', SYSDATE, 0, :fileSrc)";
	  		final	String sql2 = "UPDATE TMEMBER SET POINT = POINT+1 WHERE ID=?";
		transactionTemplate.execute(new TransactionCallbackWithoutResult(){
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				getSimpleJdbcTemplate().update(sql,	new BeanPropertySqlParameterSource(n));	
				getSimpleJdbcTemplate().update(sql2,id);				
			}
		});
		
	
		 return 이 존재할 경우 사용
		 transactionTemplate.execute(new TransactionCallback<T>() {

			@Override
			public T doInTransaction(TransactionStatus arg0) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		*/
	}
}
