package method;

import java.util.Scanner;

//quiz2 max(){두개 정수 입력받아서 큰수 리턴하는 함수}
public class Mainentry_calcu{
	public static void add() {//+
		int x, y;
		 System.out.println("더하고 싶은 두수를 입력하세요");
		 x=new Scanner(System.in).nextInt();
		 y=new Scanner(System.in).nextInt();
		 System.out.println(x+y);
		 

		
	}
	public static void sub() {//-
		int x, y;
		System.out.println("뺴고싶은 두수를 순서대로 입력하세요");
		x=new Scanner(System.in).nextInt();
		y=new Scanner(System.in).nextInt();
		System.out.println(x-y);
		
	}
	public static int mul() {//곱하기
		int x, y;
		int mul;
		
		System.out.println("곱하고싶은 두 수를 입력하세요");
		x=new Scanner(System.in).nextInt();
		y=new Scanner(System.in).nextInt();
		mul=x*y;
		
		return mul;
		
		
	}
	public static double div() {//나누기  try catch만들기.
		int x, y;
		double div=0;
		System.out.println("나누고 싶은 두 수를 입력하세요");
		x=new Scanner(System.in).nextInt();
		y=new Scanner(System.in).nextInt();
		div=(double)x/y;
		return div;
		
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		//스위치로 입력값비교후  함수호출하게 만듬.
		add();
		sub();
		
	double div11=	div();
	System.out.println(div11);
	
	int mul11=mul();
	System.out.println(mul11);
		
	
	}
}
