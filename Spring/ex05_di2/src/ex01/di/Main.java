package ex01.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
	//	AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(ApplicationContext.class);
//	Cats catsInfo=context.getBean("catsInfo",Cats.class);
//	catsInfo.getMyCatsInfo();
//	
//	Mycats cat2=context.getBean("cat2",Mycats.class);
//	catsInfo.setMyCatsInfo(cat2);
//	catsInfo.getMyCatsInfo();
	
	//xml이용
		ApplicationContext context2=new ClassPathXmlApplicationContext("appcontext.xml");
		Cats catinfo= (Cats)context2.getBean("info2");
		catinfo.getMyCatsInfo();
		
	
	}
}
