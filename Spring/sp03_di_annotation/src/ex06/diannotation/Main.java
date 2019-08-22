package ex06.diannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import ex05.di.annotation.ConfigContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context =
                new GenericXmlApplicationContext("ex06/diannotation/Appcontext.xml");

		
		SalaryMan sal=(SalaryMan) context.getBean("SalaryMan");
		Student student=(Student) context.getBean("students");
		student.info();
		sal.info();

		
		
		
	}
}
