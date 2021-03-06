package edu.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import edu.bit.model.GuestDAO;
import edu.bit.model.GuestDTO;

public class modifyAction implements Controller {
 private GuestDAO dao;
	public void setDao(GuestDAO dao) {
	this.dao = dao;
}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GuestDTO dto=new GuestDTO();
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setHome(request.getParameter("home"));
		dto.setContents(request.getParameter("contents"));
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		dao.modifyGuest(dto);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:list.do");
		return mav;
	}

}
