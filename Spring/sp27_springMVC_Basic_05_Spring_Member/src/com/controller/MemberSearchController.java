package com.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.MemberDAO;
import com.model.MemberVO;


@Controller
public class MemberSearchController {
	
	@Autowired
	private MemberDAO memberdao;
	
	@RequestMapping("/MemberSearch.do")
	public ModelAndView MemberSearch(
			@RequestParam(value="id" , required=true) String id
			) throws SQLException
	{
		
		System.out.println("id : " + id );
		MemberVO member = memberdao.selectMemberById(id);
		ModelAndView mv = new ModelAndView();
		if(member == null){
			mv.setViewName("MemberSearch");
		}else{
			mv.addObject("Singlemember",member);
			mv.setViewName("MemberSearch");
			System.out.println(member.toString());
		}
		return mv;
	}
	
	
	
	@RequestMapping("/MemberInsert.do")
	public String MemberInsert(@ModelAttribute("memberdata") MemberVO member) throws SQLException{
		/*System.out.println(
				member.getId() + " / " +
				member.getName() + " / "+
				member.getPwd() + " / " +
				member.getEmail() + " / " +
				member.getAge()
		);*/
		String view = null;
		int result = 0;
		result = memberdao.memberInsert(member);
		System.out.println("result : " + result);
		if(result > 0){
			view = "loginForm";
		}else{
			view ="MemberInsert";
		}
			
		
		return view;
	}
	@RequestMapping("/MemberInsertview.do")
	public String MemberView(){
		return "MemberInsert";
	}
}
