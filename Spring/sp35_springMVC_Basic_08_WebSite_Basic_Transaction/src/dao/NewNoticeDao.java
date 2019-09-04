package dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import vo.Notice;

public class NewNoticeDao implements NoticeDao {
	
	private JdbcTemplate template;
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	//트랜잭션 사용 위해 추가
	@Autowired
	private TransactionTemplate transactionTemplate;
	 
	public int getCount(String field, String query) throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT COUNT(*) CNT FROM TNOTICES WHERE "+field+" LIKE ?";
		return template.queryForObject(sql, Integer.class,"%"+query+"%");
	}
	public List<Notice> getNotices(int page, String field, String query) throws ClassNotFoundException, SQLException
	{					
		int srow = 1 + (page-1)*5; // 1, 16, 31, 46, 61, ... an = a1 + (n-1)*d
		int erow = 5 + (page-1)*5; //15, 30, 45, 60, 75, ...
		
		String sql = "SELECT * FROM";
		sql += "(SELECT ROWNUM NUM, N.* FROM (SELECT * FROM TNOTICES WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) N)";
		sql += "WHERE NUM BETWEEN ? AND ?";
		return template.query(sql, 
						new Object[]{"%"+query+"%" ,srow ,erow}, 
						new BeanPropertyRowMapper<Notice>(Notice.class));
	}
	public int delete(String seq) throws ClassNotFoundException, SQLException
	{
		String sql = "DELETE TNOTICES WHERE SEQ=?";
		return template.update(sql, seq);
	}
	public int update(Notice notice) throws ClassNotFoundException, SQLException{
		
		if(notice.getFile().isEmpty()){notice.setFileSrc("");}
		
		String sql = "UPDATE TNOTICES SET CONTENT=?, FILESRC=? WHERE SEQ=?";
		return template.update(sql, notice.getContent(), 
				                    notice.getFileSrc() , notice.getSeq());
		
		
	}
	public Notice getNotice(String seq) throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT * FROM TNOTICES WHERE SEQ=?";
		return template.queryForObject(sql,
				        new Object[]{seq},
				        //ParameterizedBeanPropertyRowMapper 반환할 Type설정시
				        ParameterizedBeanPropertyRowMapper.newInstance(Notice.class));
	}
	public int insert(Notice n) throws ClassNotFoundException, SQLException {

		System.out.println(n.getFileSrc() + "/" + n.getFileSrc2());
		String sql = "INSERT INTO TNOTICES" +
				     "(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC ,FILESRC2 ) " +
				     "VALUES( (SELECT MAX(TO_NUMBER(SEQ))+1 FROM NOTICES), ?, ?, 'kosta', SYSDATE, 0, ? , ?)";
		return template.update(sql, n.getTitle(),n.getContent(),n.getFileSrc(),n.getFileSrc2());
	}
	@Override
	public void InsertAndPointOfMember(final Notice n ,final String id) throws ClassNotFoundException, SQLException {

		final String sql = "INSERT INTO TNOTICES" +
				     "(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC ,FILESRC2 ) " +
				     "VALUES( (select NVL(MAX(SEQ),0) +1 from TNOTICES), ?, ?, 'kosta', SYSDATE, 0, ? , ?)";
		final String sql2 = "update TMEMBER set point = point+1 where name=?";
		/*
		 * Transaction 없이 처리 문제 발생
		 try {
			template.update(sql, n.getTitle(),n.getContent(),n.getFileSrc(),n.getFileSrc2());
			template.update(sql2, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		try {
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				
						template.update(sql, n.getTitle(),n.getContent(),n.getFileSrc(),n.getFileSrc2());
						template.update(sql2, id);
				}
			 });
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}
}

