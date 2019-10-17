package test.test.test;


import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import test.test2.model.TestDao;

@Controller
@CrossOrigin	(origins = {"http://127.0.0.1:5501"} )
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
	@PostMapping(value="/checkpro")
	@ResponseBody
	public List<HashMap<String, String>> testC() {
		HashMap aa=new HashMap();
		dao.selectprocedure(aa);
		return (List<HashMap<String, String>>) aa.get("result");
	} // result와 매개변수 둘다 값이 담김.
	
	@GetMapping(value="/hwai")
	@ResponseBody
	public String hwai() {
		return 		"{hi:'dd'}";
	}

}





