package ex02.di;

import java.lang.reflect.Proxy;

public class Main {
	public static void main(String[] args) {
		Calc c=new CalcImp();
		
		
		
		Calc proxy=(Calc) Proxy.newProxyInstance(
				c.getClass().getClassLoader(),  // loader:클래스 찾기
				c.getClass().getInterfaces(),   //interfaces:행위(함수)
				new LogPrintHandlerImp(c));           //h: 보조업무 구현.
	//클래스 통해서 실행.
		System.out.println(c.add(1, 2));
		System.out.println(c.mul(2, 30));
		//Proxy를 통해서 실행
		System.out.println(proxy.add(3, 4));
		System.out.println(proxy.mul(2, 400));
		
	}
}
