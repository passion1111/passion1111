package kr.or.kosta.dao;

import java.sql.SQLException;

import kr.or.kosta.vo.Member;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class NewMemberDao extends SimpleJdbcDaoSupport implements MemberDao {

	@Override
	public Member getMember(String uid) throws ClassNotFoundException,
			SQLException {
		String sql = "SELECT * FROM member WHERE id=?";
		return getSimpleJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<Member>(Member.class), uid);
	}

	@Override
	public int insert(Member member) throws ClassNotFoundException,
			SQLException {
		String sql = "INSERT INTO member(no, id, PassWD, NAME, jumin, an_key, an_key_dap) " +
				                 "VALUES(:no,  :id, :passwd, :name, :jumin, :an_key,  :an_key_dap )";
		 						 //values (안의 값은 member 클래스의 memberfile명 동일 (주입)
		return getSimpleJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(member)); //:title hint 주어야 합니다
		//순수한 JDBC 이해를 하고 ...... 
	}

}
