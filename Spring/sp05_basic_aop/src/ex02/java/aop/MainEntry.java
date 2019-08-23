package ex02.java.aop;

import java.lang.reflect.Proxy;


public class MainEntry {

	public static void main(String[] args) {
	ICalc calc = new CalcImpl();
		//calc.ADD(100, 100);
		
		//가짜를 생성 (Proxy 객체 생성)
	 ICalc proxy =(ICalc)Proxy.newProxyInstance(calc.getClass().getClassLoader(),  //클래스를 찾는 코드
				               calc.getClass().getInterfaces(),   //행위정보(interface)
				               new LogPrintHandler(calc)); 
	 //int result = proxy.ADD(100,100);
	 int result = proxy.MUL(100, 100);
	 System.out.println(result);
		

	}

}
