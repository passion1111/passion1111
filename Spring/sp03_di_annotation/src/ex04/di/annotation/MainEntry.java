package ex04.di.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MainEntry {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:ex04/di/annotation/ApplicationContext.xml");
		MonitorViewer viewer = ctx.getBean("monitorViewer", MonitorViewer.class);

	}
}
