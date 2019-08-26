package exercise.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry2 {
	public static void main(String[] args) {
		
		String config = "exercise/aop/appCtx.xml";
		
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		
		Student s = context.getBean("student", Student.class);
		s.show();
	}
}
