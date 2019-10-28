package test.test.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:WEB-INF/spring/root-context.xml",
						"classpath*:WEB-INF/spring/appServlet/servlet-context.xml"})
public class TestController {
@Test
public void TestBB() {
	Assert.assertEquals("11", "11");
}
	
	
}
