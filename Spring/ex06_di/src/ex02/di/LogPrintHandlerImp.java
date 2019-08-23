package ex02.di;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

public class LogPrintHandlerImp implements InvocationHandler {
//      객체를 받으 생성자를 구현
	private Object target;

	LogPrintHandlerImp(Object target) {// 생성자=DI
		this.target = target;
	}

	// 보조프로그램을 여기에 작성.
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("invoke method start...");
		//보조업무 구현
		

		 Log log=LogFactory.getLog(this.getClass());
		 StopWatch sw=new StopWatch();
		 sw.start();
		 log.info("타이머시작");
/////////////////////실행해야할것은 이 사이에////////////////////////////////
		 int result=(int)method.invoke(target, args);
		 
		 
/////////////////////////////////////////////////////////////
		 sw.stop();
		 log.info("[TimerLog]process Time:"+sw.getTotalTimeMillis());
		 
		return result;
	}

}
