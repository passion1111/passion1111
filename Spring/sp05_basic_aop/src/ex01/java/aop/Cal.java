package ex01.java.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;
public class Cal {
//주관심사 : 계산 (ADD, MUL)
//보조관심 : 계산에 걸린 시간(ADD , MUL 실행시)
//	     : ADD 시작되고 계산이 끝나는 시점까지 시간 .....
//	     : 보조관심사 결과 log 출력 
	public int Add(int x, int y){
			Log log = LogFactory.getLog(this.getClass());
			StopWatch sw = new StopWatch();
			sw.start();
		
			log.info("[타이머 시작]");
		
		int result = x + y;//주관심
		
			sw.stop();
			log.info("[타이머 정지]");
			log.info("[TIME LOG ] method : ADD");
			log.info("[TIME LOG ] Process Time : " + sw.getTotalTimeMillis());
		return result;
	}
	
	public int Mul(int x , int y){
			Log log = LogFactory.getLog(this.getClass());
			StopWatch sw = new StopWatch();
			sw.start();
		
			log.info("[타이머 시작]");
		int result = x * y;
			sw.stop();
			log.info("[타이머 정지]");
			log.info("[TIME LOG ] method : MUL");
			log.info("[TIME LOG ] Process Time : " + sw.getTotalTimeMillis());
		return result;
	}
	
}
