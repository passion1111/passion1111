package com.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//일반 클래스가 SpringMVC 에서 Controller 클래스가 되기 위한 조건
//1. 첫번째 방법
/*public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}*/

//2. 두번째 방법 (Annotation  활용하기)
// @Controller 사용해서 -> 
@Controller  
public class HelloController{
	
	@RequestMapping("/hello.do") //함수 단위로 요청을 처리 가능
	public ModelAndView hello(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		mv.addObject("greeting", getGreeting());
		//http://localhost:8090/SpringMVC_Basic_03_practice/hello.do
		//결과의 내용 Hello.jsp의 내용이 출력(forward)
		return mv;
	}
	
	private String getGreeting(){
	  int hour =Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		  if(hour >= 6 && hour <=10){
			  return "좋은 아침";
		  }else if(hour >= 11 && hour <=15){
			  return "즐거운 점심시간";
		  }else if(hour >=16){
			  return "공부하기 좋은 시간";
		  }else{
			  return "go home";
		  }
	}
	
}

