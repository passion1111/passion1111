package ex06.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



public class MainEntry {

	public static void main(String[] args) {
		/*
		기존 자바에서 Proxy 객체 생성 Handler 사용코드
		>> Spring 의 xml 설정으로 전환
		
		Calc calc = new NewCalc();
	    //가짜를 생성 (Proxy 객체 생성)
	    Calc proxy =(Calc)Proxy.newProxyInstance(calc.getClass().getClassLoader(),  //클래스를 찿는 코드
				               calc.getClass().getInterfaces(),   //행위정보(interface)
				               new LogPrintHandler(calc)); 
	    int result = proxy.MUL(100, 100);
	    System.out.println(result);
		*/
		ApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:ex06/spring/aop/ApplicationContext.xml");
		
		ICalc proxyCal = (ICalc)ctx.getBean("proxy");
//		System.out.println(proxyCal.SUB(5,10));  // exception 발생
		System.out.println(proxyCal.SUB(50,10));
	}

}
