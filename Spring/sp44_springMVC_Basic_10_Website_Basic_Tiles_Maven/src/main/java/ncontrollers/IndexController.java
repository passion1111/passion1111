package ncontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class IndexController {
	
	@RequestMapping("index.htm")
	public String index()
	{
		System.out.println("index.htm 실행");
		//Tiles 적용
		return "home.index";
		//Tiles 적용 전 코드
		//return "index.jsp";
	}
}
