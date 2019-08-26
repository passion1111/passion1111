package ex01.application;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		
		
		//SpringFramework Container 생성
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext();
		
		//설정(Context 또는 Container 에 bean 생성)
		ctx.load("classpath:appCtx.xml");
		
		//설정2
		ctx.refresh();
		
		//사용
		Member m = ctx.getBean("member", Member.class);
		System.out.println("before : " + m.toString());
		System.out.println(m.getUserid());
		
		//종료
		ctx.close();
	}
}



