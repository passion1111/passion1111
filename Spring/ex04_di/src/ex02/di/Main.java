package ex02.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("ex02/di/Person.xml");
		Student student=context.getBean("student",Student.class); //이렇게 만들거나
//		Person student=context.getBean("student",Person.class); //이렇게 만들거나 둘중하나.
		student.info();
		Salaryman sal=context.getBean("salaryman",Salaryman.class);
		sal.info();
		
		
	}
}
