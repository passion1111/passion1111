package ex01.method;

import java.util.Scanner;

public class MethodEx {
	
	//3) 매개변수 없고, 리턴타입 있는 경우 
	public static int show() {
		//return 100;
		int num = 90;
		return num;
	}
	
	public static int max() {
		System.out.println("x, y = ");
		int x = new Scanner(System.in).nextInt();
		int y = new Scanner(System.in).nextInt();
		
		if(x > y) return x;
		else return y;

	}
	
	// 4) 매개변수 있고, 리턴타입 있는 경우
	public static String name(int x, String irum) {
		System.out.println("x = " + x);
		return irum;
	}
	
	public static void main(String[] args) {
		String str = name(10, "doyeon");
		System.out.println(str);
		
		System.out.println("name() call : " + name(999, "gil dong"));
		
		System.out.println("================");
		System.out.println("max = " + max());
		int m = max();
		System.out.println("max = " + m);
		
		System.out.println("main statr");
		int result = show();
		System.out.println(result);
		System.out.println("show method call result : " + show());
	}
}	









