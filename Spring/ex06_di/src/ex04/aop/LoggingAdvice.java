package ex04.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

//xml기반 pojo방식의 asperctj를 이용한 aop
public class LoggingAdvice {
//	arround 방식의 사전/사후 처리 aop
//	arround 방식으로 할떄는 인수는 proceedingjoinpoint필수 ,리턴-object 필수.
	public Object around(ProceedingJoinPoint point) throws Throwable {
		String methodname=point.getKind();
		String methodname2=point.getSignature().getName();
		
		System.out.println("로그 메소드 네임"+methodname+",메소드2="+methodname2+"호출되기전.");
		StopWatch sw=new StopWatch();
		sw.start(methodname);
		Object obj=point.proceed();
		sw.stop();
		System.out.println("로그"+methodname2+"호출완료");
		System.out.println("실행시간"+sw.getTotalTimeMillis()/1000+"초");
		return obj;
		
	}
	
	
	
}
