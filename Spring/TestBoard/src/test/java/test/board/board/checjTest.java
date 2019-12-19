package test.board.board;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;
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
	    
	    
	    	
	    @Test
	    public void playerControllerTest() throws Exception{

	    	MockHttpServletResponse response = new MockHttpServletResponse();
	    	MockHttpServletRequest request = new MockHttpServletRequest();
	        request.setRequestURI("/");
	        request.setMethod("GET");

	        Object handler = handlerMapping.getHandler(request).getHandler();
	        ModelAndView mav = handleAdapter.handle(request, response,handler);
	        System.out.println(mav.toString());
	        ModelAndViewAssert.assertViewName(mav,"home");

	    }

	}
