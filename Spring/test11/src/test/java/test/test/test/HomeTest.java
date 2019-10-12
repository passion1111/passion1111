package test.test.test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
public class HomeTest {


	 private static final Logger logger = (Logger) LoggerFactory.getLogger(HomeTest.class);

	    @Autowired // Dependency Injection(의존성 주입)
	    private WebApplicationContext wac;
	    private MockMvc mock;

	    @org.junit.Before
	    public void beforeTest(){
	        logger.info("===== beforeTest() =====");
	        mock = MockMvcBuilders.webAppContextSetup(wac).build();
	        logger.info("wac: " + wac);
	        logger.info("mock: " + mock);
	    }
	
	  @Test 
	 public void doTest(){ 
		 logger.info("===== doTest() =====");
	  RequestBuilder req = MockMvcRequestBuilders.post("/checkcheck"); 
	  try { 
		mock.perform(req).andExpect(status().isOk()).andDo(print());
	  logger.info("수행 성공");
	  } 
	  catch (Exception e) { 
		  logger.error("수행 실패: " +e.getMessage()); 
		  } 
	  }
	    @Test
		public void testDoA() throws Exception {
			mock.perform(MockMvcRequestBuilders.get("/login")).andDo(print());

		}


//@Autowired
//Home home;
//	 @Test
//	 public void TestC() {
//		 Home home=new Home();
//		 Assert.assertEquals("test", home.testC());
//	 }

	    @org.junit.After
	    public void afterTest(){
	        logger.info("===== afterTest() =====");
	    }
	    
}
