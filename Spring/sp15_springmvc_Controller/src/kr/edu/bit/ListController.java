package kr.edu.bit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ListController implements Controller {

	private static final Logger logger =
			LoggerFactory.getLogger(HelloController.class);
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Welcome hello.jsp page move");
		

		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "승"); 
		mav.addObject("age","333");
		
		mav.setViewName("list");	 // move view page 
		return mav;
	}

}
