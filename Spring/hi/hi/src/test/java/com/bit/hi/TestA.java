package com.bit.hi;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
//@ContextConfiguration(locations = {"classpath*:WEB-INF/spring/root-context.xml","classpath*:WEB-INF/spring/appServlet/servlet-context.xml"})
public class TestA {
	
	
	@Autowired
	DataSource ds;
	@Autowired
	SqlSession sqlsession;
	@Autowired
	com.bit.hi.Test test;
	
	
	
	@Test
	public void TestA() throws  SQLException{
		
	
			ds.getConnection();
			
		
	}
	
	
	
	@Test
	public void Testsqlsession() {
		sqlsession.getConnection();
	
	}
	
	@Test
	public void TestDAO() {
		test.TestAA();
	
	}
	

}
