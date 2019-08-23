package ex05.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAdvice {
	public Object around(ProceedingJoinPoint point) throws Throwable {
		String methodname=point.getKind();
		String methodname2=point.getSignature().getName();
		
		System.out.println("xml메소드 네임"+methodname+"클래스 안 메소드 네임"+methodname2);
		
		Object obj=point.proceed();
		
		System.out.println("끝끝");
		return obj;
	}
}
