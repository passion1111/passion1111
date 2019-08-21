package ex04.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		
//		NewRecordImpl record = new NewRecordImpl();
//		NewRecordViewImpl view = new NewRecordViewImpl();
//		
//		//조립
//		view.setRecord(record);
//		view.input();
//		view.print();
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("appCtx.xml");
		//Interface 타입으로 설정 가능
		IRecordView  view = (NewRecordViewImpl)context.getBean("view");
		view.print();
		
	}
}
