package ex01.di.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEntry {

	public static void main(String[] args) {
		
		//MonitorViewer viewer = new MonitorViewer();
		//viewer.setRecorder(new Recorder());
		//System.out.println(viewer.getRecorder().toString());
		
		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:ex01/di/annotation/ApplicationContext.xml");
		MonitorViewer viewer = context.getBean("monitorViewer",MonitorViewer.class);
		System.out.println(viewer.getRecorder().toString());
		//viewer.RecorderMethodPrint();   // 3번 테스트 할때~
	

	}

}
