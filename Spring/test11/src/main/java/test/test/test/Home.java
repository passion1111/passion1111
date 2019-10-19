package test.test.test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import test.test2.model.TestDao;

@Controller
@CrossOrigin	(origins = {"*"} )
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
	
	@GetMapping(value="/hwai",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List hwai(HttpServletRequest request) {
		//확인
		String ip = request.getHeader("X-Forwarded-For");
		 
        logger.info(">>>> X-FORWARDED-FOR : " + ip);
 
        if (ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
            logger.info(">>>> Proxy-Client-IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP"); // 웹로직
            logger.info(">>>> WL-Proxy-Client-IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            logger.info(">>>> HTTP_CLIENT_IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            logger.info(">>>> HTTP_X_FORWARDED_FOR : " + ip);
        }
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        
        logger.info(">>>> Result : IP Address : "+ip  + "\n" + request.getHeaderNames());
 
		List list=new ArrayList();
		HashMap<String, String> ha=new HashMap<String, String>();
		ha.put("1", "2");
		list.add(ha);
		
		return 	list;
	}

	 @RequestMapping(value = "/hwa2",method = RequestMethod.POST)
	 @ResponseBody
	    public void findAll(@RequestBody List<HashMap<String, String>> hi,String request) {
		 System.out.println(request);
		 
	 }
	 @RequestMapping("/hohoho{aa:[a-zA-Z0-9#]*}")
	public void hoho(@PathVariable String aa) {
		 System.out.println(aa);
	 }
}





