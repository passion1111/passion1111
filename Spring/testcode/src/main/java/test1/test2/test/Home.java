package test1.test2.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class Home {

	private static final Logger logger = LoggerFactory.getLogger(Home.class);

	

	@RequestMapping("doA")
	public void doA(){

		logger.info("doA called ...");

	}

}





