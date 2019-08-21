package ex01.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//ApplicationContext context=new ClassPathXmlApplicationContext("ex01/di/Messagebeans.xml");
		//만약 xml이 여러개인 경우아래처럼.
		
		//ApplicationContext context =new ClassPathXmlApplicationContext(new String[] {"ex01/di/Messagebeans.xml" ,"ex01/di/appContext.xml"});
		
		
		//만약 xml이 경로 밖에 있다면?
		
		ApplicationContext context =new ClassPathXmlApplicationContext("appContext2.xml");
		
		
		
		
//		MessageBean bean=(MessageBean)context.getBean("messageBeanImp");
//		인스턴스(객체)명을 넣어서.
//		MessageBean bean=context.getBean("MessageBean",MessageBean.class);
			//원래 이름으로.
		
		MessageBean bean=context.getBean("mimp",MessageBean.class);
		//별칭으로.
		bean.sayHello();
	}
}
