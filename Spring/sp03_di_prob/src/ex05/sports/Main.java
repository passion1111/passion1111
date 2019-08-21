package ex05.sports;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
public static void main(String[] args) {
	
	ApplicationContext context=new ClassPathXmlApplicationContext("ex05/sports/Sports.xml");
	middle baseketball=context.getBean("info", middle.class);
	middle soccer=context.getBean("info2", middle.class);
	middle curling=context.getBean("info3", middle.class);
	
	baseketball.porcess("상구", "농구", "포워드");
	soccer.porcess("찬민", "축구", "미드필더");
	curling.porcess("우하", "컬링", "모름");
		/*
		 * Player soccer=context.getBean("info", Player.class); soccer.porcess("창현",
		 * "축구", "미드필드");
		 * 
		 * Player curling=context.getBean("info", Player.class); curling.porcess("창현",
		 * "컬링", "모름");
		 */
}
}
