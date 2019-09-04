package dao;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
		return template.queryForObject(sql, Integer.class,"%"+query+"%");
	
	}
	
	public List<Notice> getNotices(int page, String field, String query) throws ClassNotFoundException, SQLException
	{					
		
		int srow = 1 + (page-1)*5; // 1, 16, 31, 46, 61, ... an = a1 + (n-1)*d
		int erow = 5 + (page-1)*5; //15, 30, 45, 60, 75, ...
		
		String sql = "SELECT * FROM";
		sql += "(SELECT ROWNUM NUM, N.* FROM (SELECT * FROM NOTICES WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) N)";
		sql += "WHERE NUM BETWEEN ? AND ?";
	
		return template.query(sql, 
						new Object[]{"%"+query+"%" ,srow ,erow}, 
						new BeanPropertyRowMapper<Notice>(Notice.class));
		
	}
	
	public int delete(String seq) throws ClassNotFoundException, SQLException
	{
		
		String sql = "DELETE NOTICES WHERE SEQ=?";
		return template.update(sql, seq);
		
	}
	
	public int update(Notice notice) throws ClassNotFoundException, SQLException{
		
		
		if(notice.getFile().isEmpty()){notice.setFileSrc("");}
		
		String sql = "UPDATE NOTICES SET CONTENT=?, FILESRC=? WHERE SEQ=?";
		return template.update(sql, notice.getContent(), 
				                    notice.getFileSrc() , notice.getSeq());
	}

	public Notice getNotice(String seq) throws ClassNotFoundException, SQLException
	{

		String sql = "SELECT * FROM NOTICES WHERE SEQ=?";
		return template.queryForObject(sql,
				        new Object[]{seq},
				        //ParameterizedBeanPropertyRowMapper 반환할 Type설정시
				        ParameterizedBeanPropertyRowMapper.newInstance(Notice.class));
	}

	public int insert(Notice n) throws ClassNotFoundException, SQLException {
	
		System.out.println(n.getFileSrc() + "/" + n.getFileSrc2());
		String sql = "INSERT INTO NOTICES" +
				     "(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC ,FILESRC2 ) " +
				     "VALUES( (select NVL(MAX(SEQ),0) +1 from NOTICES), ?, ?, 'kosta', SYSDATE, 0, ? , ?)";
		return template.update(sql, n.getTitle(),n.getContent(),n.getFileSrc(),n.getFileSrc2());

	}
}
