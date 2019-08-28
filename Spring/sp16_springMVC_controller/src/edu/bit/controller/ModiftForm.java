package edu.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import edu.bit.model.GuestDAO;

public class ModiftForm  implements Controller{
	private GuestDAO dao;

	public void setDao(GuestDAO dao) {
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	List list=	dao.modifySelect(Integer.parseInt(request.getParameter("num")));
	ModelAndView mav=new ModelAndView();
	mav.addObject("list",list);
	mav.setViewName("modify");
	
		return mav;
	}
	
}
