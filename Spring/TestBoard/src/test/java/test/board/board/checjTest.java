package test.board.board;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		 "file:src/main/webapp/WEB-INF/spring/root-context.xml",
						"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class checjTest {

	 @Autowired
	    private RequestMappingHandlerAdapter handleAdapter;

	    @Autowired
	    private RequestMappingHandlerMapping handlerMapping;
	    
	    AnnotationMethodHandlerAdapter   adapter = null;
    	MockHttpServletRequest request2 =null;
    	MockHttpServletResponse response2 = null;
    	ObjectMapper  mapper =null;
    	
	    @Before
	    public void setUp() {
	    	   adapter = new AnnotationMethodHandlerAdapter();
	    	 request2 = new MockHttpServletRequest();
	    	 response2 = new MockHttpServletResponse();
	           mapper = new ObjectMapper();
	    }
	    @Test
	    public void testAddUser() throws Exception {
	        request2.setMethod("POST");
	        request2.setContentType(MediaType.APPLICATION_JSON_VALUE);
	        request2.setRequestURI("/3");

	        ObjectNode userJson = mapper.createObjectNode();
	        userJson.put("userId", "jonnybz");
	        userJson.put("email", "test@gmail.com");
	        userJson.put("password", "password");
	        userJson.put("longitude",-10.127205999);
	        userJson.put("latitude", 57.252269);
	        ArrayNode arrNode = mapper.createArrayNode();
	        arrNode.add(-10.1272059999);
	        arrNode.add(57.2522);
	        userJson.put("lonLat",arrNode);
	        request2.setContent(mapper.writeValueAsBytes(userJson));
	        response2.setContentType("application/text; charset=UTF-8");
	        Object handler = handlerMapping.getHandler(request2).getHandler();
	        handleAdapter.handle(request2, response2, handler); 
	        String content = response2.getContentAsString();
	        System.out.println(content);
	        assertEquals(200, response2.getStatus());
	    }
	    	
	    @Test
	    public void playerControllerTest() throws Exception{
	    	MockHttpServletResponse response = new MockHttpServletResponse();
	    	MockHttpServletRequest request = new MockHttpServletRequest();
	        request.setRequestURI("/2");
	        request.setMethod("GET");
	        HttpSession session=request.getSession();
	        session.setAttribute("name", "22");
			request.setSession(session);
	        Object handler = handlerMapping.getHandler(request).getHandler();
	        ModelAndView mav = handleAdapter.handle(request, response,handler);
	        System.out.println(mav.toString());
	        
	        ModelAndViewAssert.assertViewName(mav,"home");
	    }	
	    
    	
//    @Test
//    public void AjaxTest() throws Exception{
//    	    ObjectMapper mapper = new ObjectMapper();
//    	    ObjectNode 
//    	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//    	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
//    	    String requestJson=ow.writeValueAsString(anObject );
//    	
//    	
//    	MockHttpServletResponse response = new MockHttpServletResponse();
//    	MockHttpServletRequest request = new MockHttpServletRequest();
//        request.setRequestURI("/3");
//        request.setMethod("POST");
//        HttpSession session=request.getSession();
//        session.setAttribute("name", "22");
//		request.setSession(session);
//		request.setContentType(MediaType.APPLICATION_JSON_VALUE);
//		request.setContent(content);
//        Object handler = handlerMapping.getHandler(request).getHandler();
//        ModelAndView mav = handleAdapter.handle(request, response,handler);
//        System.out.println(mav.toString());
//        
//    }	

	}
