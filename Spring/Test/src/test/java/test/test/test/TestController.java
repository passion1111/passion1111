package test.test.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
						"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class TestController {
	@Autowired
	DataSource ds;
	@Autowired
	TestDao dao;
	@Test
public void TestBB() throws SQLException {
	Assert.assertEquals("11", "11");
	ds.getConnection();
}
	
	@Test
public void TestAB() {
		dao.AA();
	}

	
	
}
