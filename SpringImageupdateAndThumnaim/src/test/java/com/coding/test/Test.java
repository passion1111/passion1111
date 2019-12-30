package com.coding.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.coding.web.notice.service.noticeService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class Test extends AbstractJUnit4SpringContextTests {

	@Autowired
	@Qualifier("dataSource")
	DataSource ds;
	
	@Autowired
	SqlSessionFactory session;
	
	@Autowired
	@Qualifier("noticeService")
	noticeService notice;
	
	@org.junit.Test
	public void dothatthing() throws SQLException {
		ds.getConnection();
	}
	@org.junit.Test
	public void dothatthingA() {
		SqlSession sessionB=session.openSession();
	}
	
	@org.junit.Test
	@Transactional
	public void Testdao(){
		notice.noticeMainList(5).toString();
		
	}
}
