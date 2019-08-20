package ex03.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
//		MessageBean bean = new MessageBeanImplKr();
//		bean.sayHello("스프링");
//		
//		
//		bean = new MessageBeanImplEn();
//		bean.sayHello("Spring");
		
		ApplicationContext context =
				new ClassPathXmlApplicationContext("ex03/di/applicationContext.xml");
		
		MessageBean en = (MessageBean)context.getBean("en");
		en.SayHello("Spring Fun!!!");
		
		MessageBean kr = context.getBean("kr", MessageBean.class);
		kr.SayHello("안녕");
		
		
	}

}





