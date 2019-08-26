package ex01.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEntry2 {
	public static void main(String[] args) {
		
		//container ���� �� ����
		ApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		//load, reflesh
		//���
		Member m = ctx.getBean("member", Member.class);
		System.out.println(m.getUserid());
		
		Member m2 = (Member)ctx.getBean("member");
		
		System.out.println("spring Framework ��� ȯ��(�ڿ��� ȿ��) : " 
				+ " ������ bean Singleton ���� ����");
		System.out.println("m : " + m.toString() + "\n"
				+ "m2 : " + m2.toString() + "\n"
				+ "== �� : " + (m == m2));
		
	}
}





