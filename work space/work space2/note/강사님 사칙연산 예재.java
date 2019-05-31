package ex01.method;

import java.util.Scanner;

public class MethodEx2 {
	//사칙연산 함수 만들기 - add(+), sub(-), mul(*), div(/) 
	//2개는 리턴 타입으로 만들기 
	public static void main(String[] args) {
		
		try{
			Scanner sc = new Scanner(System.in);
			System.out.print("input data ==> ");
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			add(num1, num2);
			sub(num1, num2, 1.2);
			
			System.out.println(num1+ " * " + num2 + " = " + (num1 *num2) );
			int na = div(num1 , num2 );
			System.out.println(num1+ " * " + num2 + " = " + na );
			
			System.out.println(mul(num1, num2));
			int gob = mul(num1, num2);
			System.out.println(gob);
			
		} catch(Exception e)  {
			e.printStackTrace();
		}
		
	} //main end
	
	public static int div(int num1, int num2) {
		try{
			if( num2 != 0 ) return num1 / num2;
			/*else {
				System.out.println("0으로 나눌 수 없습니다.");
				System.exit(0);
			}*/
		} catch(Exception e) {
			//System.out.println("0으로 나눌 수 없습니다.");
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return 0;
	}

	public static int mul(int x, int y) {
		//int gob = x * y; 
		return ( x * y );  // return  gob ;
	}

	public static void sub(int x, int y, double z) {
		System.out.println(x + " - " + y + " - " + z+ " = " + (x-y-z) );
		
	}

	public static void add(int x, int y) {
		System.out.println(x + " + " + y + " = " + (x+y) );
		
	}
}
