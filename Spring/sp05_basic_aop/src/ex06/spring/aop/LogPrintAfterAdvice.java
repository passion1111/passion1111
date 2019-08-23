package ex06.spring.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;

//After Advice
//주관심사의 결과값을 가지고 로직을 제어시 사용...
//Ex) session 값 허용 ....

public class LogPrintAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnvalue, 
			Method method, 
			Object[] args,
			Object target) throws Throwable {
		
			System.out.println("AfterReturningAdvice Start");
			Log log = LogFactory.getLog(this.getClass());
		    log.info("[주업무 실행되고 돌아와서 바로 실행 ]");
		    log.info("[AfterReturning Method  ]: " + method.getName());
		    log.info("[Return value ]: " + returnvalue);
		    log.info("[args  values ]: " + Arrays.toString(args));

	}

}
