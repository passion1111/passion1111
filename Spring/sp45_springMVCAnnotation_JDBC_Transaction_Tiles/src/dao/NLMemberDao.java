package dao;

import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import vo.Member;

public class NLMemberDao extends SimpleJdbcDaoSupport implements MemberDao {
	public Member getMember(String id) throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT * FROM TMEMBER WHERE \"ID\"=?";
		return getSimpleJdbcTemplate().queryForObject(sql, 
				new BeanPropertyRowMapper<Member>(Member.class), 
				id);
		
		
		//getSimpleJdbcTemplate().... 수정
	/*	// 0. 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 1. 접속
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"HR", "11111");
		// 2. 실행
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, uid);
		// 3. 결과
		ResultSet rs = st.executeQuery();
		
		Member member = null;
		
		if(rs.next())
		{
			member = new Member();
			member.setUid(rs.getString("uid"));
			member.setPwd(rs.getString("pwd"));
			member.setName(rs.getString("name"));
			member.setGender(rs.getString("gender"));
			member.setBirth(rs.getString("birth"));
			member.setIsLunar(rs.getString("is_lunar"));
			member.setCPhone(rs.getString("cphone"));
			member.setEmail(rs.getString("email"));
			member.setHabit(rs.getString("habit"));
			member.setRegDate(rs.getDate("regdate"));
		}
		
		rs.close();
		st.close();
		con.close();
		
		return member;*/
	}
	
	public int insert(Member member) throws ClassNotFoundException, SQLException
	{
	
		String sql = "INSERT INTO TMEMBER(ID,PWD,NAME,GENDER,BIRTH,IS_LUNAR,CPHONE,EMAIL, HABIT, REGDATE) " +
				"VALUES( :id, :pwd, :name ,:gender, :birth, :isLunar, :cPhone, :email, :habit, SYSDATE )";
	
		
		return getSimpleJdbcTemplate().update(sql, 
									  new BeanPropertySqlParameterSource(member));
		
		//getSimpleJdbcTemplate().... 수정
		
		/*// 0. 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 1. 접속
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"HR", "11111");
		// 2. 실행
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, member.getUid());
		st.setString(2, member.getPwd());
		st.setString(3, member.getName());
		st.setString(4, member.getGender());
		st.setString(5, member.getBirth());
		st.setString(6, member.getIsLunar());
		st.setString(7, member.getCPhone());
		st.setString(8, member.getEmail());
		st.setString(9, member.getHabit());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;*/
	}
}
