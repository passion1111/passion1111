package ex01.java;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class Calc {  //��Ģ���� ���α׷� - ���ϱ�,����,������,����

	public int add(int x, int y) {
		Log log = LogFactory.getLog(this.getClass());
		
		StopWatch sw = new StopWatch();  
		sw.start();  //�������� ����
		log.info("Ÿ�̸� ����");
		
		int result = x + y;  //�߽�(����, �ְ��Ǵ�)�ڵ� 
		
		log.info("Ÿ�̸� ����");
		sw.stop();  //�ð����� ��
		
		log.info("[TimerLOG] Method : add ");
		log.info("[TimerLOG] process Time : " + sw.getTotalTimeMillis());
		
		return result;
	}
		
	public int mul(int x, int y) {
		Log log = LogFactory.getLog(this.getClass());
		
		StopWatch sw = new StopWatch();  
		sw.start();  //�������� ����
		log.info("Ÿ�̸� ����");
		
		int result = x * y;  //�߽�(����, �ְ��Ǵ�)�ڵ� 
		
		log.info("Ÿ�̸� ����");
		sw.stop();  //�ð����� ��
		
		log.info("[TimerLOG] Method : mul ");
		log.info("[TimerLOG] process Time : " + sw.getTotalTimeMillis());
		
		return result;
	}
}








