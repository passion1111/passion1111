package ex03.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class LogPrintHandlerImpl implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("invoke method start.....................");
		//�������� ����
		Log log = LogFactory.getLog(this.getClass());
		
		StopWatch sw = new StopWatch();  
		sw.start();  //�������� ����
		log.info("Ÿ�̸� ����");
		
		//// main ���� ���� ///////////////////////////////////////
		Object result = invocation.proceed();
		///////////////////////////////////////////////////////////
		
		log.info("Ÿ�̸� ����");
		sw.stop();  //�ð����� ��
		
		log.info("[TimerLOG] Method :  " + invocation.getMethod());  //������ �޼ҵ� ��Ī ������
		log.info("[TimerLOG] process Time : " + sw.getTotalTimeMillis());
		
		return result;
	}

}
