package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.MemberDAO;
import com.model.MemberVO;

@Controller
public class MemberCheckController {
	@Autowired
	private MemberDAO memberdao; 

	@RequestMapping(value="/check.do",method=RequestMethod.GET)
	public String form(){
		//System.out.println("form 실행");
		//System.out.println(memberdao.toString());
		return "membercheckForm"; //view > WEB-INF/view/loginForm.jsp 
	}
	
	@RequestMapping(value="/check.do",method=RequestMethod.POST)
	public ModelAndView submit
			(
			  @RequestParam(value="id",required=true) String id
			) throws Exception
	{
	    String view = null;	
		//System.out.println(id + " / " + pwd);
		
		MemberVO memberok = memberdao.selectMemberById(id);
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("memberok", memberok);
			if(memberok != null)
			{
				mv.setViewName("membercheckSuccess"); 
			}else{
				mv.setViewName("membercheckForm"); 
			}
		return mv;
	}
}
