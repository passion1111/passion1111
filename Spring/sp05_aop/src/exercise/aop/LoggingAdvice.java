package exercise.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAdvice {
	
	public Object around (ProceedingJoinPoint point) throws Throwable{
		
		String str1= "?΄λ²? ?°? ?μ£Όλ?? λͺλ¨\r\n";
		String str2= "??  μΆν?©??€.";
		
		System.out.println(str1);
		
		Object obj = point.proceed(); //?€?  ??κ²? ??? λ©μ?κ°? ?ΈμΆλ? λΆ?λΆ?
		
		System.out.println(str2);
		
		
		return obj;
		
	}
}
