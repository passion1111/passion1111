package quiz.person;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAdvice {
	
	public Object around(ProceedingJoinPoint point) throws Throwable{
		String methodName = point.getSignature().getName();
		System.out.println("[LOG] "+ methodName +" 함수 호출 전");
		Object obj = point.proceed();
		System.out.println("[LOG] "+ methodName +" 함수 호출 후");
		return obj;
	}
}
