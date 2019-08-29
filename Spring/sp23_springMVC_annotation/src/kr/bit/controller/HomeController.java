package kr.bit.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {//annotation 기반.
	
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("greeting",getGreeting());
		mav.setViewName("hello");
		
		return mav;
	}


private Object getGreeting() {
	int hour=Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	
	if(hour>=6&&hour<=11) {
		return "좋은아침";
	}
	else if(hour>=12&&hour<=15) {
	return "점심 맛나게 드세여";
	}else if(hour>=18&&hour<=120) {
	return "저녁드세여";
	}
	return "하이";
}

}
