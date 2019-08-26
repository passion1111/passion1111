package edu.bit.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogApp {   // Advice class - around ����
	
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
	}
}
