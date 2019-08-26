package quiz.person;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("quiz/person/ctx.xml");
		Person person = context.getBean("personImpl", Person.class);
		person.student("쿵", 8, 1, "천사");
//		person.employee("수아", 25, "여행자");
	}
}
