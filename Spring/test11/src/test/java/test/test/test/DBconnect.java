package test.test.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import test.test2.model.TestDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DBconnect {

	@Autowired
	DataSource ds;
	
	@Autowired
	SqlSessionFactory session;
	
	@Test
	public void dothatthing() throws SQLException {
	
		ds.getConnection();
	}

	@Test
	public void dothatthingA() {
		SqlSession sessionB=session.openSession();
		
	}
}
