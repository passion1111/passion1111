package exercise.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAdvice {
	
	public Object around (ProceedingJoinPoint point) throws Throwable{
		
		String str1= "?���? ?��?�� ?��주�?? 명단\r\n";
		String str2= "?��?�� 축하?��?��?��.";
		
		System.out.println(str1);
		
		Object obj = point.proceed(); //?��?�� ??�? ???�� 메소?���? ?��출되?�� �?�?
		
		System.out.println(str2);
		
		
		return obj;
		
	}
}
