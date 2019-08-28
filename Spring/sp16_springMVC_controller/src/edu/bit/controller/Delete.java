package edu.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import edu.bit.model.GuestDAO;
import edu.bit.model.GuestDTO;

public class Delete implements Controller {
	private GuestDAO dao;
	
	
	public void setDao(GuestDAO dao) {
		this.dao = dao;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		int num=Integer.parseInt(request.getParameter("num"));
		dao.deleteGuest(num);
		mav.setViewName("redirect:list.do");
		return mav;
	}

}
