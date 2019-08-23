package ex01.di;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class Calc {//사칙연산 더 뺴 나 곱
 public int add(int x,int y) {

	 Log log=LogFactory.getLog(this.getClass());
	 StopWatch sw=new StopWatch();
	 sw.start();
	 log.info("타이머시작");
	 sw.stop();
	 log.info("타이머 메소드는 add");
	 log.info("[TimerLog]process Time:"+sw.getTotalTimeMillis());
	 
	 int result=x+y;
	 
	 return result;
 }
 public int minus(int x,int y) {

	 Log log=LogFactory.getLog(this.getClass());
	 StopWatch sw=new StopWatch();
	 sw.start();
	 log.info("타이머시작");
	 sw.stop();
	 log.info("타이머 메소드는 minus");
	 log.info("[TimerLog]process Time:"+sw.getTotalTimeMillis());
	 
	 int result=x-y;//중심코드
	 
	 return result;
 }
 public int na(int x,int y) {

	 Log log=LogFactory.getLog(this.getClass());
	 StopWatch sw=new StopWatch();
	 sw.start();
	 log.info("타이머시작");
	 sw.stop();
	 log.info("타이머 메소드는 나누기");
	 log.info("[TimerLog]process Time:"+sw.getTotalTimeMillis());
	 
	 int result=x/y;//중심코드
	 
	 return result;
 }
 
 public int mul(int x,int y) {

	 Log log=LogFactory.getLog(this.getClass());
	 StopWatch sw=new StopWatch();
	 sw.start();
	 log.info("타이머시작");
	 sw.stop();
	 log.info("타이머 메소드는 곱하기");
	 log.info("[TimerLog]process Time:"+sw.getTotalTimeMillis());
	 
	 int result=x*y;//중심코드
	 
	 return result;
 }
 
 
	
}
