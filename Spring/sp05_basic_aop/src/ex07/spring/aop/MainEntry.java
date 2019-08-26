package ex07.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



public class MainEntry {

	public static void main(String[] args) {
		
		ApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:ex07/spring/aop/ApplicationContext.xml");
		
		ICalc proxyCal = (ICalc)ctx.getBean("proxy");
		
		System.out.println(proxyCal.ADD(5,10));
		System.out.println(proxyCal.MUL(5,10));
		System.out.println(proxyCal.SUB(10,5));
	}

}
