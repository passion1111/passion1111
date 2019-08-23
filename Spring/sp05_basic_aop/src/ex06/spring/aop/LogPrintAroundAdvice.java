package ex06.spring.aop;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

//AroundAdvice
//보조관심사가  주관심사 전 / 후 에 전용
public class LogPrintAroundAdvice  implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		System.out.println("Around Service Invoke() START");
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		
		////////////////////////////////
		Object result = method.proceed(); //주관심사의 함수 호출
		////////////////////////////////
		
		sw.stop();
		log.info("[타이머 정지]");
		log.info("[TIME LOG ] method :" + method.getMethod());
		log.info("[TIME LOG ] args :" + Arrays.toString(method.getArguments()));
		log.info("[TIME LOG ] Process Time : " + sw.getTotalTimeMillis()/1000);
		
		return result;
	}

}
