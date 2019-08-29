package kr.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.bit.model.GuestDAO;
import kr.bit.model.GuestDTO;

@Controller
public class WriteController {
	
	@Autowired
	private GuestDAO dao;
	
	@RequestMapping("writeform.do")
	public ModelAndView writeform() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("writeform");
		
		return mav;
	}
	
	@RequestMapping("writeAction.do")
	public ModelAndView writeaction(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav=new ModelAndView();
		
		GuestDTO dto=new GuestDTO();
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setHome(request.getParameter("home"));
		dto.setContents(request.getParameter("contents"));
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		
		dao.insertGuest(dto);
		mav.setViewName("redirect:list.do");
		
		return mav;
	}
	
}
