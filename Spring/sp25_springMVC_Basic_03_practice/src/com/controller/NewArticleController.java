package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.NewArticleCommand;
import com.service.ArticleService;


//controller 등록 (Annotation)

//URL : /article/newArticle.do
//RequestMapping 를 클래스에 사용
//NewArticleController 클래스가
//판단(GET : POST) => 요청에 대한 처리

@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {
	
	//요청에 대한 처리
	//글쓰기 폼을 보여주세요(Display)
	//글쓰기 폼을 전송(sumit)
	
	//요청이 GET  자동 호출 (default > <form 태그에 method="POST" 라고
	//명시하지 않은 모든 요청은 GET 방식
	@RequestMapping(method=RequestMethod.GET)
	public String form(){
		System.out.println("GET 방식에 대한 요청 처리");
		return "article/newArticleForm";
		
		//viewResolver 에 의해서 (Forward)
	    //result > /WEB-INF/view/article/newArticleForm.jsp
		//Client 에게 newAricleForm.jsp 화면을 출력해라
	}
	
	
	private ArticleService articleservice;
	@Autowired //[타입]이 일치하는 bean 있으면 자동 주입 (xml파일에서는 > <context:annotation-config />
	public void setArticleservice(ArticleService articleservice) {
		this.articleservice = articleservice;
	}


	//요청이  POST 자동 호출
	//Form 태그에서 제목 입력, 내용입력하고 submit 버튼을 누르면
	//? 1. FORM 태그에 action 속성이 없어요 (action="article/newArticle.do") 정상
	//<form method="POST"> 여기에 ..
	//질문) action 은 어떻게 만들어 질까요 
	//답변) http://localhost:8090/SpringMVC_Basic_03_practice/article/newArticle.do
	//     article/newArticle.do  요놈을  action 값으로 그대로 사용
	
	
	//질문) public String submit(NewArticleCommand command)
	//command 에 어떻게 객체 정보가 넘오 오나요
	//<form 태그에서 전송하면 
	//원래 : String title = request.getParameter("title") ....
	//원래 : NewArticleCommand command = new NewArticleCommand();
	//원래 : command.setTitle(title); 
	//위 에 처럼 하는 방법이 정석이죠 ^^
	
	//이상하게 위 코드는 생략 
	//public String submit(NewArticleCommand command) DTO객체가 
	//parameter 쓰였다
	//답변) 
	//From 태그 > 전송 > 파라메터(DTO객체)
	
	//1 . NewArticleCommand command
	//2 . NewArticleCommand 내부적으로 객체가 생성
	//3 . 객체가 생성되고 Form 태그에서 넘어온 값을 setter 로 자동 주입
	//4 . 단 전제 조건은 Form 태그가 가지는 <input type="" name="title"
	//    name값이 변수명과 같다면 setter 동작 값설정
	//    point > memberfield명하고  input 태그 name 값 동일
	
	
	//그런데 화면에서 입력값 출력 (newArticleSubmitted.jsp)
	//기존에 
	//ModelAndView mb= new ModelAndView();
	//mb.addObject("newCommand",command) // request.setAttri....
	
	//5 . NewArticleCommand 자동으로 bean 으로 등록 
	//    <bean id="newArticleCommand"  class="">
	//    클래스의 [첫문자]만 [소문자]로 만들어서 bean으로 등록
	
	//6 . 그럼 view 페이지에서
	//ModelAndView mb= new ModelAndView();
	//mb.addObject("newCommand",command) // request.setAttri....
	//위 처럼 만든 코드  >> request.getAttribute("newCommand");
	
	//현재 [[[[  id값 ]]]] 으로 객체를 사용합니다
	
	//7 . view 에 던지는  객체의 이름을 변경하고 싶어요
	//    현재  NewArticleCommand - > newAr....  사용
	//@ModelAttribute 사용하면 view에서 사용하는 객체의 이름 변경 가능
	//public String submit(NewArticleCommand command){ 주석처리
	@RequestMapping(method=RequestMethod.POST)
	public String submit(@ModelAttribute("ArticleData")NewArticleCommand command){
	System.out.println("POST에 대한 요청 처리");
			System.out.println("Form Data : ");
			System.out.println(command.getTitle() + " / "
							   + command.getContent() + " / "	
							   + command.getParentId());
			
			//서비스 객체를 통해서 write 실행
			//글쓰기 서비스 실행
			articleservice.writeArticle(command);
			return  "article/newArticleSubmitted";
			
			
//			1.ModelAndView 객체를 통해서 데이터 저장 및 이동할 뷰 페이지.
//			2.model
//			3.@ModelAttribute객체
			
			
			//viewResolver
			//result >> /WEB-INF/view/article/newAricleSubmitted.jsp
	}
	
}





