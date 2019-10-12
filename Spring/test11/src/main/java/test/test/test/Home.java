package test.test.test;


import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import test.test2.model.TestDao;

@Controller
public class Home {
	
@Autowired
TestDao dao;

	private static final Logger logger = LoggerFactory.getLogger(Home.class);

	

	@PostMapping(value="/login")
	public void doA(@RequestParam String userid,@RequestParam String pwd){
		System.out.println(userid+"유저아이디"+pwd+"패스워드");
		logger.info("doA called ...");
		
	}
	@GetMapping(value="/login")
	public void doB() {
		dao.TestList();
	}
	
	
	@PostMapping(value="/checkcheck")
	public List<HashMap<String, String>> doC(){
		
		
		return dao.TestList();
	}
	public String testC() {
		return "test";
	}

}





