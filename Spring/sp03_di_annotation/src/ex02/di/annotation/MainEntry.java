package ex02.di.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MainEntry {

	public static void main(String[] args) {
		
		// 이 코드를 실행하면, MemberInfoPrinter 클래스의 @Autowired가 적용된 
		//setPrinter() 메서드에 MemberPrinter 타입의 두 빈 객체 중 어떤 객체를 주입해야 할지 모르기 때문에 익셉션이 발생한다.
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:ex02/di/annotation/ApplicationContext.xml");
		MonitorViewer viewer = ctx.getBean("monitorViewer", MonitorViewer.class);

	}
}
