package ex03.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
public static void main(String[] args) {
	ApplicationContext context=new ClassPathXmlApplicationContext("ex03/di/Score.xml");
	ScoreShow show=context.getBean("show",ScoreShow.class);
	//ScoreShow show=context.getBean("show",ScoreShow.class);
//	ScoreShow show=(ScoreShow) context.getBean("show");
	show.print();
	
	System.out.println("---------------");
	show.input();
	show.print();
}
}
