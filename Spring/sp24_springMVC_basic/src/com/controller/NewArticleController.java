package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.ArticleService;

@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {
	
	private ArticleService   articleService;
	@Autowired // [타입]이 일치하는 bean 있으면 자동 주입 xml 설정 파일에서는  <context:annotation-config />
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	//요청에 대한 처리
	//글쓰기 폼을 보여주세요(Display)
	//글쓰기 폼을 전송(submit)
	
	//요청이 Get 자동 호출 >  jsp에서 form 태그에 method="Post"라고
	// 명시하지 않은 모든 요청은 Get 방식 
	//@RequestMapping(value = "/article/newArticle.do", method = RequestMethod.GET)
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		
		System.out.println("GET 방식에 대한 요청 처리");
		return "article/newArticleForm";
	}
	
	

}








