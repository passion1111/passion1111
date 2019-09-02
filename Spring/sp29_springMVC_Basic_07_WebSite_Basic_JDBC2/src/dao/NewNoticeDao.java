package dao;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import vo.Notice;
//: SimpleJdbcTemplate 활용  == SimpleJdbcDaoSupport 상속

//SimpleJdbcTemplate 사용
//SimpleJdbcTemplate simple;
//SimpleJdbcTemplate 확장가능한 형태로 쓸수 제공 : SimpleJdbcDaoSupport 추상클래스 => 상속
public class NewNoticeDao extends SimpleJdbcDaoSupport implements NoticeDao{

//기존 JDBCTemplate 사용
//public class NewNoticeDao implements NoticeDao{ //////////////////
	//*기존 JDBCTemplate 사용
	//*사용하기 위해서
	//xml에서 별도의 주입 .....
	//private JdbcTemplate jdbcTemplate;
	//public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	//	this.jdbcTemplate = jdbcTemplate;
	//}
/////////////////////////////////////////////////////////////////////	
	
	
	//SimpleJdbcDaoSupport 상속 구현 하므로
	//SimpleJdbcTemplate 메버필드
	//SimpleJdbcTemplate setter 생략 됩니다
	@Override
	public int getCount(String field, String query)
			throws ClassNotFoundException, SQLException {
		String sql = "SELECT COUNT(*) CNT FROM NOTICES WHERE "+field+" LIKE ?";
		
		//*JdbcTemplate 코드//
		//return jdbcTemplate.queryForInt(sql, "%"+query+"%");
		
		return getSimpleJdbcTemplate().queryForInt(sql, "%"+query+"%");
		
	}
	@Override
	public List<Notice> getNotices(int page, String field, String query)
			throws ClassNotFoundException, SQLException {
		int srow = 1 + (page-1)*5; 
		int erow = 5 + (page-1)*5; 
		
		String sql = "SELECT * FROM";
		sql += "(SELECT ROWNUM NUM, N.* FROM (SELECT * FROM NOTICES WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) N)";
		sql += "WHERE NUM BETWEEN ? AND ?";
		
		/*
		 *JdbcTemplate 코드
		return jdbcTemplate.query(sql, new Object[]{"%"+query+"%",srow,erow} , new RowMapper<Notice>(){
			@Override
			public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
				Notice notice = new Notice();
				notice.setSeq(rs.getString("seq"));
				notice.setTitle(rs.getString("title"));
				notice.setWriter(rs.getString("writer"));
				notice.setContent(rs.getString("content"));
				notice.setRegdate(rs.getDate("regdate"));
				notice.setFileSrc(rs.getString("fileSrc"));
				notice.setHit(rs.getInt("hit"));
				return notice;
			}
			
		});
		return jdbcTemplate.query(sql,new Ojbect[]{"%"+query+"%",srow,erow},
		                          new BeanPropertyRowMapper<Notice>(Notice.class)); 
		*/
			
		return getSimpleJdbcTemplate().query(sql,new BeanPropertyRowMapper<Notice>(Notice.class),"%"+query+"%",srow,erow);
	}
	@Override
	public Notice getNotice(String seq) throws ClassNotFoundException,
			SQLException {
		String sql = "SELECT * FROM NOTICES WHERE SEQ=?";
		
		//* 방법_2 JdbcTemplate 코드
		//return jdbcTemplate.queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(Notice.class),seq);
		/*
		 * 방법_1 JdbcTemplate 코드
		return jdbcTemplate.queryForObject(sql, new RowMapper<Notice>(){
			@Override
			public Notice mapRow(ResultSet rs, int rownum) throws SQLException {
				Notice notice = new Notice();
				notice.setSeq(rs.getString("seq"));
				notice.setTitle(rs.getString("title"));
				notice.setWriter(rs.getString("writer"));
				notice.setContent(rs.getString("content"));
				notice.setRegdate(rs.getDate("regdate"));
				notice.setFileSrc(rs.getString("fileSrc"));
				notice.setHit(rs.getInt("hit"));
				return notice;
			}
			
		}, seq);
		*/
		return getSimpleJdbcTemplate().queryForObject(sql,new BeanPropertyRowMapper<Notice>(Notice.class),seq);
	}
	@Override
	public int delete(String seq) throws ClassNotFoundException, SQLException {
		String sql = "DELETE NOTICES WHERE SEQ=?";
		
		//*JdbcTemplate 코드
		//return jdbcTemplate.update(sql, seq);
		
		return getSimpleJdbcTemplate().update(sql, seq);
	}
	@Override
	public int update(Notice notice) throws ClassNotFoundException,
			SQLException {
		
		//확인 ...작업 
		if(notice.getFile().isEmpty()){notice.setFileSrc("");}
		String sql = "UPDATE NOTICES SET TITLE=?, CONTENT=?, FILESRC=? WHERE SEQ=?";
		
		//*JdbcTemplate 코드
		//return jdbcTemplate.update(sql,new Object[]{notice.getTitle(),notice.getContent(),notice.getFileSrc(),notice.getSeq()});
		
		return getSimpleJdbcTemplate().update(sql,notice.getTitle(),notice.getContent(),notice.getFileSrc(),notice.getSeq());
	}
	@Override
	public int insert(Notice n) throws ClassNotFoundException, SQLException {
		
		/*기존 JDBCTemplate 사용
		String sql = "INSERT INTO NOTICES(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC , FILESRC2) VALUES( (SELECT MAX(TO_NUMBER(SEQ))+1 FROM NOTICES), ?, ?, 'NEWUSER', SYSDATE, 0, ? ,?)";
		return jdbcTemplate.update(sql,new Object[]{n.getTitle(),n.getContent(),n.getFileSrc()});
		*/
		
		
		String sql = "INSERT INTO NOTICES(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC , FILESRC2) " +
				"     VALUES( (SELECT MAX(TO_NUMBER(SEQ))+1 FROM NOTICES), :title, :content, 'NEWUSER', SYSDATE, 0, :fileSrc , :fileSrc2)";
		
		/*
		Map<String,Object> parameters = new HashMap<String,Object>();
		parameters.put("content", n.getContent());
		parameters.put("fileSrc", n.getFileSrc());
		parameters.put("title", n.getTitle());
		return getSimpleJdbcTemplate().update(sql, parameters);
		*/
		return getSimpleJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(n));
	
	}

}
