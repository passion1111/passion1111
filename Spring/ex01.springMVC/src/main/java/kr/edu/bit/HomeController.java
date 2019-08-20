package kr.edu.bit;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	//어디로 가라고할수도 있는것이다~.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
									//model이라는애에 보냄    보내는 방식은 3방식 model modelandview    modelmap
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		//request.setattribute("변수명",   데이터)  같은개념.
		model.addAttribute("serverTime", formattedDate );
		
		return "home";  //WEB-INF/views/+home+.jsp   prefix : //WEB-INF/views/   postfix : jsp  그래서 home만 적어도 알아서 돌아가버림.
	//	return "main";
	}
	
}
