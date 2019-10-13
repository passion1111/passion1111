package test.test.test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
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
import org.springframework.web.servlet.tags.Param;

import test.test2.model.TestDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
public class HomeTest2 {

	 private static final Logger logger = (Logger) LoggerFactory.getLogger(HomeTest.class);

	    @Autowired // Dependency Injection(의존성 주입)
	    private WebApplicationContext wac;
	    private MockMvc mock;
	    @Autowired
	    TestDao dao;
	    
	    @Before
	    public void beforeTest(){
	        logger.info("===== beforeTest() =====");
	        mock = MockMvcBuilders.webAppContextSetup(wac).build();
	        logger.info("wac: " + wac);
	        logger.info("mock: " + mock);
	    }
	
//	  @Test 
//	 public void doTest(){ 
//		 logger.info("===== doTest() =====");
	//  RequestBuilder req = MockMvcRequestBuilders.post("/login").param("userid","admin"). param("pwd","!@#$"); 
//	  try { 
		//mock.perform(req).andExpect(status().isOk()).andDo(print());
	  
		 // Assert.assertEquals(type, actual);
		  
		// List<HashMap<String, String>> list=new ArrayList<HashMap<String,String>>();
		// Assert.assertEquals(2, dao.TestList().get(0).size());
		// System.out.println(dao.TestList().get(0).size());
		 	//  Assert.assertThat(list, type);
		//  Assert.assertTrue(list is List<E>);
//		  logger.info("수행 성공");
//	  } 
//	  catch (Exception e) { 
//		  logger.error("수행 실패: " +e.getMessage()); 
//		  } 
//	  }
	  
//	  @Test
//	  public void testC() {
//		  logger.info("===== testC() =====");
//		  RequestBuilder req = MockMvcRequestBuilders.post("/login").param("userid","admin"). param("pwd","!@#$"); 
//		  try { 
//			mock.perform(req).andExpect(status().isOk()).andDo(print());
//		  logger.info("수행 성공");
//		  } 
//		  catch (Exception e) { 
//			  logger.error("수행 실패: " +e.getMessage()); 
//			  } 
//	  }
//	    @Test
//		public void testDoA() throws Exception {
//
//			mock.perform(MockMvcRequestBuilders.post("/checkcheck")).andDo(print());
//
//		}
	    
	    
//	@Test
//	public void testDoB() throws Exception {
//
//	//	mock.perform(MockMvcRequestBuilders.post("/checkpro"));
////		.andDo(print());
//		HashMap aa =new HashMap();
//		dao.selectprocedure(aa);
//		List<HashMap<String, String>> list=new ArrayList<HashMap<String,String>>();
//		
//		list=(List<HashMap<String, String>>) aa.get("result");
//		System.out.println(list.get(0).get("TESTSTRING"));
//
//	}//테스트완료
	
	@Test
	public void testDoC() throws Exception {

		mock.perform(MockMvcRequestBuilders.post("/checkpro")).andDo(print());
		

	}//테스트완료
	

	 

	    @After
	    public void afterTest(){
	        logger.info("===== afterTest() =====");
	    }
	    
}
	