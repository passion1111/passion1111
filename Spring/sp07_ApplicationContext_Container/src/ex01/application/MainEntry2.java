package ex01.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEntry2 {
	public static void main(String[] args) {
		
		//container 생성 및 설정
		ApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		//load, reflesh
		//사용
		Member m = ctx.getBean("member", Member.class);
		System.out.println(m.getUserid());
		
		Member m2 = (Member)ctx.getBean("member");
		
		System.out.println("spring Framework 기업 환경(자원의 효율) : " 
				+ " 생성된 bean Singleton 으로 관리");
		System.out.println("m : " + m.toString() + "\n"
				+ "m2 : " + m2.toString() + "\n"
				+ "== 비교 : " + (m == m2));
		
	}
}





