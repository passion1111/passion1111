package ex03.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.lang.*;

public class Main {
	public static void main(String[] args) {
		
		String config = "classpath:ex03/aop/aopcontext.xml";
		//Proxy 만들고 객체를 넘기고 필요한 객체를 생성하는 작업은 이미 xml 설정 파일을 통해서 설정함
		ApplicationContext context =
				new ClassPathXmlApplicationContext(config);
		
		Calc proxy = context.getBean("proxy", Calc.class);
		System.out.println(proxy.add(20, 30));
		System.out.println(proxy.mul(3, 5));
	}
}
