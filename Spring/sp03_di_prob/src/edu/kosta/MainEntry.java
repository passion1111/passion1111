package edu.kosta;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		
		ApplicationContext  ctx = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MyApplication app = ctx.getBean("myApplication", MyApplication.class);
		app.processMessage("Hi~ th160!!", "happy@kosta.or.kr");
	
		MyApplication twitter = ctx.getBean("myApplication2", MyApplication.class);
		twitter.processMessage("Twitter", "https://www.facebook.com/doyeon.lee.58760");
	}
}
