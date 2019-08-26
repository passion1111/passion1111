package edu.bit.aop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		
		String config = "edu/bit/aop/appCtx.xml";
		
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(config);
		
		
		Student student = ctx.getBean("student", Student.class);
		student.getStudentInfo();
		
		Worker worker = (Worker) ctx.getBean("worker");
		worker.getWorkerInfo();
	}
}







