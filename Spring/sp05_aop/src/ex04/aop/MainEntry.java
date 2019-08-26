package ex04.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("ex04/aop/ctx.xml");
		
		MessageBean bean = context.getBean("messageBean", MessageBean.class);
		bean.sayHello();
		System.out.println("------------------------------");
		bean.engHello();
		
		System.out.println("\n\n=========================");
		BookBean book = (BookBean)context.getBean("bookBean");
		book.testHello("¾È³ç");
		book.korHello();
	}
}







