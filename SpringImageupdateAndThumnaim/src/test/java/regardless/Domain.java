package regardless;


import java.sql.SQLException;
import java.util.HashMap;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import test.test.test.testInterface;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class Domain {
	@Autowired
	@Qualifier("dataSource")
	DataSource ds;
	
	@Autowired
	SqlSessionFactory session;
	
	@Autowired
	testInterface test;
	
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
		System.out.println("check2");
		System.out.println(test.test(1).get("CONTENT"));
	}
	@Test
	public void TestList(){
		for (HashMap iterable_element : test.testList()) {
			System.out.println(iterable_element.get("CONTENT"));
			System.out.println(iterable_element.get("IDX"));
		}
	}
	@Test
	public void TestInsert(){
		System.out.println("설마22");
		HashMap hash=new HashMap();
		hash.put("CONTENT", "content");
		test.testInsert(hash);
		System.out.println(hash.get("IDX")+"셀렉키");
	}
	
	
	@Test
	public void TestUpdate(){
		HashMap insertdata=new HashMap();
		insertdata.put("CONTENT", "1111");
		insertdata.put("IDX", 1);
		test.testUpdate(insertdata);
	}
	@Test
	public void totalsubmittest(){
//      DB업데이트 		
//		Files.deleteIfExists(oriFile.toPath());
		HashMap insertdata=new HashMap();
		//insert하기위해 Content담고 insert하면 게시글 번호를 담아서 리턴해나온다 
		insertdata.put("CONTENT", "11");
		test.testInsert(insertdata);
		//그 게시글 번호를 select 해온다 
		HashMap boarddata=test.test((Integer) insertdata.get("IDX"));
		
	}
}
