package ex06.spring.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.ThrowsAdvice;

public class LogPrintThrowingAdvice implements ThrowsAdvice {
	public void afterThrowing(IllegalArgumentException e) 
	throws Throwable{
		Log log = LogFactory.getLog(this.getClass());
		log.info("[afterThrowing 예외발생] :  " + e.getMessage());
	}
}
