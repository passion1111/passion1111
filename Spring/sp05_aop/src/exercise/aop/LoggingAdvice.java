package exercise.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAdvice {
	
	public Object around (ProceedingJoinPoint point) throws Throwable{
		
		String str1= "?´ë²? ?—°?„ ?…ì£¼ë?? ëª…ë‹¨\r\n";
		String str2= "?™„? „ ì¶•í•˜?•©?‹ˆ?‹¤.";
		
		System.out.println(str1);
		
		Object obj = point.proceed(); //?‹¤? œ ??ê²? ???ƒ ë©”ì†Œ?“œê°? ?˜¸ì¶œë˜?Š” ë¶?ë¶?
		
		System.out.println(str2);
		
		
		return obj;
		
	}
}
