package edu.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import edu.bit.model.GuestDAO;
import edu.bit.model.GuestDTO;

public class WriteFormController2 implements Controller {
	


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		
		mav.setViewName("Writeform");
		
		return mav;
	}

}
