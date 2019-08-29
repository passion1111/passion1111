package kr.bit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.bit.model.GuestDAO;

@Controller
public class ListController {
	
	
	@Autowired
	private GuestDAO dao;
	
	
	@RequestMapping("list.do")
	public ModelAndView list() {
		ModelAndView mav=new ModelAndView();
		List list=dao.listGuest();
		mav.addObject("list",list);
		mav.setViewName("list");
		return mav;
	}
	
}
