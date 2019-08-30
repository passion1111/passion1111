package com.model;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

//기존 : java.sql.* > JDBC 를 사용
//현재 : Spring 제공 > jdbcTemplate 사용 CRUD 작업

public class MemberDAOImpl implements MemberDAO {

	//injection 대상
	//
	
	private JdbcTemplate jdbcTemplate;
	@Autowired  // xml 코드 상단에  <context:annotation-config />
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public MemberVO selectMemberById(String id) throws SQLException {

		//jdbcTemplate.query(psc, rse)
		System.out.println(id);
		String sql ="select * from UserMember where id=?";
		  try {
			  return this.jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<MemberVO>(MemberVO.class),id);
	        } catch (EmptyResultDataAccessException e) {
	            // EmptyResultDataAccessException 예외 발생시 null 리턴
	            return null;
	        }
		 
		//내부적으로 select 해온 결과 : 
		//1.  MemberVo m = new MemberVo() 생성
		//2.  m.setId(컬럼) ... 
		//3.  m객체를 리턴
		//동작 전제 조건 :VO객체가 가지는 member변수명 == 컬럼명
	}

	@Override
	public boolean memberCheck(String id, String pwd) throws SQLException {
		String sql = "select * from UserMember where id=? and pwd=?";
		boolean result=false;
		Object[] params = {id,pwd};
		//params[0] = kingsmile
		//params[1] = 1004
		//this.jdbcTemplate.queryForList(sql,params) 리턴 List
		if(this.jdbcTemplate.queryForList(sql, params).size() >0){
			result = true;
		}
		return result;
		
	}
	
	@Override
	public boolean memberInsert(String id, String name, String pwd, String email, int age) throws SQLException {
		String sql = "insert into UserMember values(?,?,?,?,?)";
		boolean result=false;
		Object[] params = {id,name,pwd,email,age};
		//params[0] = kingsmile
		//params[1] = 1004
		//this.jdbcTemplate.queryForList(sql,params) 리턴 List
		if(this.jdbcTemplate.update(sql, params) >0){
			result = true;
		}
		return result;
	}

}
