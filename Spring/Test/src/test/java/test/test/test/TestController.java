package test.test.test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
		int a=0;
		
		//쿼리오류 이유 찾아보기
		//System.out.println(dao.insertAA());
		
	}
	@Test
	public void TestStream() {
		List<String> names = Arrays.asList("jeong", "pro", "jdk", "java");
		names.stream(); //Collection에서 스트림 생성
		 
		Double[] dArray = {3.1, 3.2, 3.3};
		Arrays.stream(dArray);//배열로 스트림 생성
		 
		Stream<Integer> str = Stream.of(1,2); // 스트림 직접 생성
		Stream<String> a = names.stream().filter(x -> x.contains("o"));
		names.stream().filter(x -> x.contains("o")).forEach(x->System.out.println(x));



		
	}
	
	
}
