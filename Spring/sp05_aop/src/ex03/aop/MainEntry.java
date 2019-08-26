package ex03.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {
		
		String config = "classpath:ex03/aop/appCtx.xml";
		//Proxy ����� ��ü�� �ѱ�� �ʿ��� ��ü�� �����ϴ� �۾��� �̹� xml ���� ������ ���ؼ� ������
		ApplicationContext context =
				new ClassPathXmlApplicationContext(config);
		
		Calc proxy = context.getBean("proxy", Calc.class);
		System.out.println(proxy.add(20, 30));
		System.out.println(proxy.sub(1, 2, 3));
		System.out.println(proxy.mul(3, 5));
	}
}
