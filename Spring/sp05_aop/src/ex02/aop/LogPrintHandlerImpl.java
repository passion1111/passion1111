package ex02.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;


public class LogPrintHandlerImpl implements InvocationHandler {
	//��ü�� ���� ������ ����
	private Object target;
	public LogPrintHandlerImpl(Object target) {   // ������ - DI
		this.target = target;
	}

	@Override  // ���� ���α׷��� ���⿡ �ۼ�
	public Object invoke(Object proxy, Method method, Object[] args) 
			throws Throwable {
		System.out.println("invoke method start....................");
		//���� ���� ����
		Log log = LogFactory.getLog(this.getClass());
		
		StopWatch sw = new StopWatch();  
		sw.start();  //�������� ����
		log.info("Ÿ�̸� ����");
		
		//// main ���� ���� ///////////////////////////////////////
		int result = (int)method.invoke(target, args);
		///////////////////////////////////////////////////////////
		
		log.info("Ÿ�̸� ����");
		sw.stop();  //�ð����� ��
		
		log.info("[TimerLOG] Method :  " + method.getName());  //������ �޼ҵ� ��Ī ������
		log.info("[TimerLOG] process Time : " + sw.getTotalTimeMillis());
		
		return result;
	}

}








