package exercise.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("exercise/aop/appCtx.xml");
		
		Student stu = context.getBean("student", Student.class);
		
//		Student stu = context.getBean("student", Student.class);
//		stu.show();
//		
//		Employee epl = context.getBean("e", Employee.class);
//		epl.show();

	}

}
