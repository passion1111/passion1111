package kosta.mvc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.web.dto.TransferDTO;
import kosta.mvc.web.exception.MyException;
import kosta.mvc.web.service.TransferService;

@Controller
public class TransferController {
	
	@Autowired
	TransferService transferService;
	
  @RequestMapping("/")
  public String url() {
	  return "transaction";
  }
  
  @RequestMapping("/transfer")
  public String transfer(TransferDTO dto) {
	  transferService.transfer(dto);
	  
	  return "result";
  }
  
  @ExceptionHandler(MyException.class)
  public ModelAndView error(Exception e) {
	  
	  return new ModelAndView("error", "errMessage", e.getMessage());
  }
  
  
}






