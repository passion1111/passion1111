package ex01.application;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		
		
		//SpringFramework Container ����
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext();
		
		//����(Context �Ǵ� Container �� bean ����)
		ctx.load("classpath:appCtx.xml");
		
		//����2
		ctx.refresh();
		
		//���
		Member m = ctx.getBean("member", Member.class);
		System.out.println("before : " + m.toString());
		System.out.println(m.getUserid());
		
		//����
		ctx.close();
	}
}



