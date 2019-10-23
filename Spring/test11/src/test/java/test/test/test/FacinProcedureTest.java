package test.test.test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
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

import test.test2.model.FacilitiesInspectionDAO;
import test.test2.model.TestDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
public class FacinProcedureTest {

	 private static final Logger logger = (Logger) LoggerFactory.getLogger(HomeTest.class);

	    @Autowired // Dependency Injection(의존성 주입)
	    private WebApplicationContext wac;
	    private MockMvc mock;
	    @Autowired
	    TestDao dao;
	    @Autowired
	    FacilitiesInspectionDAO fao;
	    
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
	
//	@Test
//	public void testDoC() throws Exception {
//
//		mock.perform(MockMvcRequestBuilders.get("/test22")).andDo(print()).andExpect(status().isOk());
//		
//
//	}//테스트완료
//	    @Test
//	    public void testinsert() {
//			  RequestBuilder req = MockMvcRequestBuilders.get("/hohoho423d#wqdqw");
//			  try { 
//				mock.perform(req).andDo(print());
//			  logger.info("수행 성공");
//			  } 
//			  catch (Exception e) { 
//				  logger.error("수행 실패: " +e.getMessage()); 
//				  } 
//		  }
////	    	dao.insert("201801",1);
//	    @Test
//	    public void testsplit() {
//	    	String hash ="aaadd";
//	    	System.out.println(hash.split("#").length);
//	    	System.out.println(hash.indexOf("#") );
//	    	HashMap<String, HashMap<String, String>> hashhash=new HashMap<String, HashMap<String,String>>();
//	    	HashMap<String,String> hashin=new HashMap<String,String>();
//	    	hashin.put("hi","di");
//	    	hashhash.put("hi", hashin);
//	    	System.out.println(hashhash.get("hi").get("hi"));
//	    	
//	    	//System.out.println(ha.length+i);
//	    }
//	 
//	    @Test
//	    public void callabletest() {
//	    	HashMap map=new HashMap();
//	    	List<HashMap<String, String>> List=new ArrayList<HashMap<String,String>>();
//	    	HashMap hash=new HashMap();
//	    	dao.callable(map);
//	    	hash=map;
//	    	List=(java.util.List<HashMap<String, String>>) hash.get("result");
//	    	String hoho=List.toString();
//	    	System.out.println(List.get(0));
//	    	ArrayList<HashMap> List2=new ArrayList();
//
//	    	//	    	for (String s : hoho.replace("[","").replace("]","").split("},")   ) {
////					System.out.println(s+"ddd");
////			}
//	    	for (String s : hoho.replace("[","").replace("]","").replace("{", "").replace(",", "").split("}") ) {
//				//System.out.println(s.trim());
//				HashMap hash=new HashMap();
//				List2.add(hash);
////					System.out.println(sd.trim());
//				//	System.out.println(s);
//					for (String total: s.trim().split(" ")) {
//						System.out.println(total);
//						String[] total2 = total.split("=");
//							hash.put(total2[0], total2[1]);
//					}	
////							String[] howparsing=total.split("=");
////									hash.put(howparsing[0], howparsing[1]);
////							
//////							for (int j = 0; j < howparsing.length; j++) {
//////								
//////								if((j+1)%2==0) {
//////								}
//////							}
////						
//			
//				
//				
//				}
//	    //}
//	    		for (HashMap hashcheck : List2) {
//	    			System.out.println("리스트당");
//	    			for (Object ha : hashcheck.keySet()) {
//							System.out.println("키 = "+ha+",밸류="+hashcheck.get(ha)   );
//						}
//				}
	    		
	    //}
	
	
//	@Test
//	public void Testarray() {
//		List<HashMap<String, String>>list =new ArrayList<HashMap<String,String>>();
//		HashMap<String, String> hash=new HashMap<String, String>();
//		HashMap<String, String> hash2=new HashMap<String, String>();
//
//		hash.put("select2","or");
//		hash.put("select","nono");
//		hash.put("text","976");
//		
//		hash2.put("select2","or");
//		hash2.put("select","nono");
//		hash2.put("text","976");
//
//		list.add(hash);
//		list.add(hash2);
//
//		logger.info("ddd"+dao.test22(list));
//	}
	    
	    @Test
	    public void checjtest() {
	    	
	    //	logger.info(fao.facinselect().toString().toString());
	    	HashMap<String, String> map=new  HashMap<String, String>();
	    	map.put("FacIn_name","테스트용");
	    	map.put("facin_address","테스트장소");
	    	map.put("f_cycle","66");
	    	fao.facininsertprocedure(map);
	    }
	    
	    @Test
	    public void checkupdate() {
	    	HashMap<String, String> map=new  HashMap<String, String>();
	    	map.put("FacIn_name","테스트용");
	    	map.put("facin_address","테스트장소");
	    	fao.facininsertprocedure(map);
	    	
	    	
	    }
	    @After
	    public void afterTest(){
	        logger.info("===== afterTest() =====");
	    }
	    
	    
	    
}
	