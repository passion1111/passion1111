package com.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


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
		// TODO Auto-generated method stub
		//jdbcTemplate.query(psc, rse)
		String sql ="select id,pwd,name,email,age from UserMember where id=?";
		//System.out.println("MemberVO");
		//return this.jdbcTemplate.queryForObject(sql,MemberVO.class, id); 
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
		if(this.jdbcTemplate.queryForList(sql,params).size() >0){
			result = true;
		}
		return result;
		
	}

	@Override
	public int memberInsert(MemberVO membervo) throws SQLException {
		String sql = "insert into UserMember(id,pwd,name,email,age) values(?,?,?,?,?)";
		
		/*Map<String,Object> parameters = new HashMap<String,Object>();
		parameters.put("id", membervo.getId());
		parameters.put("pwd", membervo.getPwd());
		parameters.put("name", membervo.getName());
		parameters.put("email", membervo.getEmail());
		parameters.put("age", membervo.getAge());*/
		//System.out.println(parameters.get("id") + " / " + parameters.get("age"));
		Object[] parameters = {membervo.getId(),membervo.getPwd(), membervo.getName(),membervo.getEmail(), membervo.getAge()};
		//System.out.println(parameters.toString());
	 	return this.jdbcTemplate.update(sql,parameters);

	}
	
	

}
