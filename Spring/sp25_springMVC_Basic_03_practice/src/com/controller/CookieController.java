package com.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//하나의 클래스 (컨트롤러)에 여러개의 메소드작동하게할수있음.
@Controller
public class CookieController {

	@RequestMapping("cookie/make.do")
	public String make(HttpServletResponse response){
		//HttpServletResponse response 클라이언트 쪽에 cookie 값저장 
		response.addCookie(new Cookie("auth", "1"));
		return "cookie/cookieMake";
		
		//WEB-INF/view/cookie/cookieMake.jsp >
		
		//문자열 return (View 정보)
		//내부적으로 ModelAndView 자동 생성 
		//리턴되는 문자열이   mv.setViewName("cookie/cookieMake");
		//ModelAndView mv = new ModelAndView();
		//mv.addObject("name", "kingsmile");
		//mv.setViewName("cookie/cookieMake");
		
		
	}	
	
	@RequestMapping("/cookie/view.do")
	public String View(@CookieValue(value="auth" ,defaultValue="0") String auth)
	{
		System.out.println("클라이언트에서 받은 쿠키값 : " + auth);
		
		return "cookie/cookieview";
	}
	
	
}






