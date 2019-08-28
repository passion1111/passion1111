package edu.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import edu.bit.model.GuestDAO;

public class ListController implements Controller {

	private GuestDAO guestDAO;
	public void setGuestDAO(GuestDAO guestDAO) {
		this.guestDAO = guestDAO;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		List list=guestDAO.listGuest();
		mav.addObject("list", list);
		mav.setViewName("list");
		
		return mav;
	}

}
