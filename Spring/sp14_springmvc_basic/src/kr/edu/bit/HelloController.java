package kr.edu.bit;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

							//이게 컨트롤러를 의미.
public class HelloController implements Controller {   // Controller
	
	private static final Logger logger =
			LoggerFactory.getLogger(HelloController.class);

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("Welcome hello.jsp page move");
		

		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "sad");  // data save
		mav.setViewName("/View/Hello.jsp");	 // move view page 
		
		return mav;
	}

}
