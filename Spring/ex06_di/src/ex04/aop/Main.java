package ex04.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("ex04/aop/ctx.xml");
		
		MessageBean bean=context.getBean("messageimp",MessageBean.class);
		bean.sayHello();
		System.out.println("---------------");
		bean.engHello();
		
		
		System.out.println("\n\n\n\n\n\n\n--------------");
		BookBean book=(BookBean)context.getBean("bookimp");
		book.testHello("안녕");
		
		book.korHello();
	}
}
