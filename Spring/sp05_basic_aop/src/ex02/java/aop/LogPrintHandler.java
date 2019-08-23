package ex02.java.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class LogPrintHandler implements InvocationHandler {
	
	private Object target;
	public LogPrintHandler(Object target) {
		System.out.println("LogPrintHandler 생성자 호출");
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("Invoke 메서드 호출 START");
		//보조업무 구현
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		//int result = x * y; 주업무 ....///////////////////////
		//실제 주업무를 가진 객체의 함수를 호출할수 있는 코드
		int result = (int)method.invoke(this.target, args); //MUL , ADD , SUB > parameter 값을 가지고
		//////////////////////////////////////////////////////
		sw.stop();
		log.info("[타이머 정지]");
		log.info("[TIME LOG ] method :");
		log.info("[TIME LOG ] Process Time : " + sw.getTotalTimeMillis()/1000);
		log.info("[args] values : " + Arrays.toString(args));
		
		return result;
	}

}
