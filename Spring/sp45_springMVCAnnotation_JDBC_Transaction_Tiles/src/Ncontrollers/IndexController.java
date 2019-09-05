package Ncontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/*")
public class IndexController {
	@RequestMapping("index.htm")
	public String join(){
		return "home.index";
	}
}
