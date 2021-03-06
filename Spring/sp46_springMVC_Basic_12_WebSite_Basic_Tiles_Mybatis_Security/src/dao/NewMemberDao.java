package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import vo.Member;

public class NewMemberDao  implements MemberDao{
	
	private JdbcTemplate template;
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public Member getMember(String uid) throws ClassNotFoundException, SQLException
	{
		List<Member> results = template.query(
				"SELECT * FROM TMEMBER WHERE UID=?",
				new RowMapper<Member>() {
					@Override
					public Member mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Member member = new Member(
								 rs.getString("USERID"),
								 rs.getString("PWD"),
								 rs.getString("NAME"),
								 rs.getString("GENDER"),
								 rs.getString("BIRTH"),
								 rs.getString("IS_LUNAR"),
								 rs.getString("CPHONE"),
								 rs.getString("EMAIL"),
								 rs.getString("HABIT")
								);
						return member;
					}
				},
				uid);

		return results.isEmpty() ? null : results.get(0);
	
	}
	
	public int insert(final Member member) throws ClassNotFoundException, SQLException
	{
	 return	template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String sql = "INSERT INTO TMEMBER(USERID, PWD, NAME, GENDER, BIRTH, IS_LUNAR, CPHONE, EMAIL, HABIT, REGDATE) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, member.getUserid());
				pstmt.setString(2, member.getPwd());
				pstmt.setString(3, member.getName());
				pstmt.setString(4, member.getGender());
				pstmt.setString(5, member.getBirth());
				pstmt.setString(6, member.getIsLunar());
				pstmt.setString(7, member.getCPhone());
				pstmt.setString(8, member.getEmail());
				pstmt.setString(9, member.getHabit());
				return pstmt;
			}
		});
		
	}
}
