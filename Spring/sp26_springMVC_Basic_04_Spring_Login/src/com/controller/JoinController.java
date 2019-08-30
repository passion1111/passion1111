package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.MemberDAO;

@Controller
public class JoinController {
	@Autowired
	private MemberDAO memberdao; 

	@RequestMapping(value="/join.do",method=RequestMethod.GET)
	public String form(){
		//System.out.println("form 실행");
		//System.out.println(memberdao.toString());
		return "joinForm"; //view > WEB-INF/view/loginForm.jsp 
	}
	
	@RequestMapping(value="/join.do",method=RequestMethod.POST)
	public String submit
			(
			  @RequestParam(value="id",required=true) String id,
			  @RequestParam(value="name",required=true) String name,
			  @RequestParam(value="pwd",required=true) String pwd,
			  @RequestParam(value="email",required=true) String email,
			  @RequestParam(value="age",required=true) int age
			) throws Exception
	{
	    String view = null;	
		//System.out.println(id + " / " + pwd);
		
		boolean joinMember = memberdao.memberInsert(id, name, pwd, email, age);
		System.out.println(joinMember);
			if(joinMember)
			{
				view = "joinSuccess"; 
			}else{
				view = "joinForm"; 
			}
		return view;
	}
	
}
