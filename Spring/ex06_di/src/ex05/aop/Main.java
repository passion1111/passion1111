package ex05.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//학생클래스 -이름 나이 학년 반
//회사원 클래스- 이름 나이 /직업.
public class Main {

	
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("ex05/aop/app.xml");
	
		Person st=context.getBean("student",Person.class);
		Person salaryman=context.getBean("salaryman",Person.class);
		
		st.info("박수", 13);
		salaryman.info("동수", 55);
	}
}
