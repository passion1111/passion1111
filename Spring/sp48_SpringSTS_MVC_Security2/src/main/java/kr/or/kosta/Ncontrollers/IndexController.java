package kr.or.kosta.Ncontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class IndexController {
	@RequestMapping("index.htm")
	public String join(){
		//Tiles 적용 이전
		//return "index.jsp";
	    
		return "home.index";
	}
}
