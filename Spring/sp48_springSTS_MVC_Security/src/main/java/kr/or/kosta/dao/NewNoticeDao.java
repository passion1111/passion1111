package kr.or.kosta.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.kosta.vo.Notice;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;
public class NewNoticeDao extends SimpleJdbcDaoSupport implements NoticeDao{
	@Override
	public int getCount(String field, String query)
			throws ClassNotFoundException, SQLException {
		String sql = "SELECT COUNT(*) CNT FROM TNOTICES WHERE "+field+" LIKE ?";
		
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
		sql += "(SELECT ROWNUM NUM, N.* FROM (SELECT * FROM TNOTICES WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) N)";
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
		String sql = "SELECT * FROM TNOTICES WHERE SEQ=?";
		
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
		String sql = "DELETE TNOTICES WHERE SEQ=?";
		
		//*JdbcTemplate 코드
		//return jdbcTemplate.update(sql, seq);
		
		return getSimpleJdbcTemplate().update(sql, seq);
	}
	@Override
	public int update(Notice notice) throws ClassNotFoundException,
			SQLException {
		
		//확인 ...작업 
		if(notice.getFile().isEmpty()){notice.setFileSrc("");}
		String sql = "UPDATE TNOTICES SET TITLE=?, CONTENT=?, FILESRC=? WHERE SEQ=?";
		
		//*JdbcTemplate 코드
		//return jdbcTemplate.update(sql,new Object[]{notice.getTitle(),notice.getContent(),notice.getFileSrc(),notice.getSeq()});
		
		return getSimpleJdbcTemplate().update(sql,notice.getTitle(),notice.getContent(),notice.getFileSrc(),notice.getSeq());
	}
	@Override
	public int insert( Notice n ) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO TNOTICES(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC , FILESRC2) " +
			"     VALUES( (SELECT MAX(TO_NUMBER(SEQ))+1 FROM TNOTICES), :title, :content, :writer, SYSDATE, 0, :fileSrc , :fileSrc2)";
	
		return getSimpleJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(n));
	
	}
	@Override
	@Transactional
	public void InsertAndPointOfMember(Notice n ,  String id) throws ClassNotFoundException, SQLException {
		 String sql = "INSERT INTO TNOTICES(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC , FILESRC2) " +
				"     VALUES( (SELECT NVL(MAX(TO_NUMBER(SEQ)),0)+1 FROM TNOTICES), :title, :content, :writer, SYSDATE, 0, :fileSrc , :fileSrc2)";
		 String sql2="update TMEMBER SET point = point+1 where name=?";
		//게시판 글쓰기
		//회원포인트 업데이트 => 하나의 논리적 단위로 처리하겠다
		getSimpleJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(n));
		getSimpleJdbcTemplate().update(sql2, id);
	
		
	}
	
}
