package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.MemberDAO;
//문제 로그인 화면과 로그인 프로세스를 처리하는 
//함수를 작성하세요
//GET : POST
//시나리오
//로그인 처리 (GET : POST) 구분해서 처리
//1. GET : 로그인 화면 출력
//2. POST: ID, PWD 가지고 와서 처리
//3. LoginController [의존객체] 필요한가 ? membdaoImpl 객체 (함수)


//@RequestMapping("/login.do") 가 있다면 아래 코드 형태
//public class LoginController
//함수에서는 @RequestMapping(method=RequestMethod.GET)
@Controller
public class LoginController {
	
	@Autowired
	private MemberDAO memberdao; 
	//MemberDAOImpl 인터페이스 [타입]이 컨테이너 안에 존재한다면
	
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String form(){
		System.out.println("form 실행");
		System.out.println(memberdao.toString());
		return "loginForm"; //view > WEB-INF/view/loginForm.jsp 
	}
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String submit
			(
			  @RequestParam(value="id",required=true) String id,
			  @RequestParam(value="pwd",required=true) String pwd,
			  HttpSession session //session객체를 얻기 **
			) throws Exception
	{
	    String view = null;	
		System.out.println(id + " / " + pwd);
		
		boolean isMember = memberdao.memberCheck(id, pwd);
		System.out.println("isMember : " + isMember);
			if(isMember)
			{
				session.setAttribute("USERID", id);
				view = "loginSuccess"; //view  WEB-INF/view/loginSuccess.jsp
			}else{
				view = "loginForm"; //view     WEB-INF/view/loginForm.jsp
			}
		
		return view;
	}
	
	
}

