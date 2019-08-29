package kr.bit.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class InfoController {

	
	@RequestMapping("/info.do")
	public ModelAndView info() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("name","승");
		mav.addObject("age",22);
		mav.setViewName("info");
		return mav;
	}
}
