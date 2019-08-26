package edu.bit.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class LogApp {   // Advice class - around ����
	
	@Pointcut("within(edu.bit.aop.*)")  // Ư��(������)�󿡸� ����
//	@Pointcut("bean(student)")
	private void pointCutMethod() {  }
	
	@Around("pointCutMethod()")
	public Object loggerApp(ProceedingJoinPoint point) throws Throwable {
		
		String signatureStr = point.getSignature().toLongString();
		System.out.println(signatureStr + " is start......");
		long st = System.currentTimeMillis();
		
		try {
			
			Object obj = point.proceed();
			return obj;
			
		} finally {
			long end = System.currentTimeMillis();
			System.out.println(signatureStr + " is finished.");
			System.out.println(signatureStr + " ��� �ð� : " + (end - st));
		}
	} // around
	
	@Before("pointCutMethod()")
	public void beforeAdvice() {
		System.out.println("beforeAdvice()");
	}
}







