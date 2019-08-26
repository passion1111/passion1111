package ex02.aop;

import java.lang.reflect.Proxy;

public class MainEntry {
	public static void main(String[] args) {
		
		Calc c = new CalcImpl();
		
		Calc proxy = (Calc)Proxy.newProxyInstance(
							c.getClass().getClassLoader(),	// loader : Ŭ���� ã��  			
							c.getClass().getInterfaces(), 	// interfaces : ����(�Լ�)
							new LogPrintHandlerImpl(c));	// h : �������� ����
		
		//Ŭ���� ���ؼ� ����
		System.out.println(c.add(1, 2));
		System.out.println(c.mul(10, 30));
		System.out.println("==========================");
		//Proxy�� ���ؼ� ����
		System.out.println(proxy.add(5, 5));
		System.out.println(proxy.mul(3, 9));
	}
}








