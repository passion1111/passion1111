package ex01.java;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class Calc {  //사칙연산 프로그램 - 더하기,빼기,나눗셈,곱셈

	public int add(int x, int y) {
		Log log = LogFactory.getLog(this.getClass());
		
		StopWatch sw = new StopWatch();  
		sw.start();  //시작측정 시작
		log.info("타이머 시작");
		
		int result = x + y;  //중심(관심, 주가되는)코드 
		
		log.info("타이머 정지");
		sw.stop();  //시간측정 끝
		
		log.info("[TimerLOG] Method : add ");
		log.info("[TimerLOG] process Time : " + sw.getTotalTimeMillis());
		
		return result;
	}
		
	public int mul(int x, int y) {
		Log log = LogFactory.getLog(this.getClass());
		
		StopWatch sw = new StopWatch();  
		sw.start();  //시작측정 시작
		log.info("타이머 시작");
		
		int result = x * y;  //중심(관심, 주가되는)코드 
		
		log.info("타이머 정지");
		sw.stop();  //시간측정 끝
		
		log.info("[TimerLOG] Method : mul ");
		log.info("[TimerLOG] process Time : " + sw.getTotalTimeMillis());
		
		return result;
	}
}








