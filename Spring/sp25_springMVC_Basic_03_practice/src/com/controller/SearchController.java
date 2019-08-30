package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//implement Controller구현 않고 Annotation 사용

@Controller
public class SearchController {
	//GET  parameter
	//http://www.naver.com/search.do?query=kglim&p=2005
	//String query = request.getParameter("query");
	//int pageNumber = Integer.ParserInt(request.getParameter("p"));
	
	@RequestMapping("/search/internal.do")
	public ModelAndView searchInternal(
			@RequestParam("query") String query ,
			@RequestParam("p") int pageNumber)
	{
		System.out.println("in_parameter value : " + query + "/" + pageNumber);
		
		return new ModelAndView("search/internal");
		//WEB-INF/view/search/internal.jsp > view page구성
	}
	
	
	//parameter 값이 없는 경우 처리 ??
	//parameter 값이 없는 경우 대체할 방법은 없니 ??
	//required=false 추가  defaultValue="1" 추가
	/*@RequestMapping("/search/external.do")
	public ModelAndView searchExternal(
			@RequestParam(value="query" ,required=false) String query,
			@RequestParam(value="p" ,defaultValue="1") int pageNumber)
	{
		System.out.println("ex_parameter value : " + query + "/" + pageNumber);
		return new ModelAndView("search/external");
	}*/
	
	@RequestMapping("/search/external.do")
	public ModelAndView searchExternal(
			@RequestParam(value="query" ,defaultValue="hong") String query,
			@RequestParam(value="p" , required=false ,defaultValue="10") int pageNumber)
	{
		System.out.println("ex_parameter value : " + query + "/" + pageNumber);
		return new ModelAndView("search/external");
	}
	
}
