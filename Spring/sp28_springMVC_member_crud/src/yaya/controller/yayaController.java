package yaya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import yaya.model.yayaDAOImp;
import yaya.model.yayaVO;



@Controller
public class yayaController {

	@Autowired
	private yayaDAOImp dao;
	


	public String update(yayaVO p) {
		
	dao.update(p.getId());	
		
	return "redirext:list.do";	
	}
	
	public String delte(yayaVO p) {
		
		dao.delete(p.getId());
		
		return "redirext:list.do";
	}
	
	
	@RequestMapping(value="list.do")
	public String list(Model model) {
		System.out.println("ddd");
		List list=dao.select();
		model.addAttribute("list",list);
		return "list";
	}
	
	
	@RequestMapping(value="insert.do")
	public String insert(yayaVO p) {
		
		dao.insert(p.getId(),p.getPwd());
		
		return "redirect:list.do";
	}
	
	
}
