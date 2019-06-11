/*문제6] 사칙연산 프로그램 작성(예외처리하기)
  숫자 2개 입력 받고, 연산자(+, -, *, /) 1개 입력 받아서
  ( if, switch 이용 ) 

   
  result> 
    3
    5
    +

   3 + 5 = 8*/


//*
package quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.omg.IOP.CodecPackage.FormatMismatch;

public class Quiz_예외처리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int su1, su2, result=0;
		//char op;
		String op = null;  //문자열로 처리하기 위해
		
		try {
			System.out.print("## 연산자(+, -, *, /) 중 하나를 입력하세요. ");
			op = sc.next(); //연산자 문자열로 입력 받기
			
//			if( (op != '+') && (op != '-') && (op != '*') && (op != '/')) {
//				System.out.println("\n잘못 입력하셨습니다.(+, -, *, /) ");
//				System.exit(0);
//			} // if end
			
			System.out.print("su1 = "); su1 = sc.nextInt();
			System.out.print("su2 = "); su2 = sc.nextInt();
			
			//if 로 처리
			// == 값비교
			if( op.equals("+") ) result = su1 + su2;
			else if( op.equals("-") ) result = su1 - su2;
			else if( op.equals("*") ) result = su1 * su2;
			else if( op.equals("/") ) result = su1 / su2;
			
//			if( op == '+' ) result = su1 + su2;
//			else if( op == '-' ) result = su1 - su2;
//			else if( op == '*' ) result = su1 * su2;
//			else if( op == '/' ) result = su1 / su2;
			
			System.out.println("\n\n" + su1 +" "+ op +" " + su2 + " = " + result);
				
		} catch (InputMismatchException e) {
			e.printStackTrace();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
//*/

/*
package quiz;

import java.util.Scanner;

public class Quiz_예외처리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int su1, su2, result=0;
		char op;
		
		try {
			System.out.print("## 연산자(+, -, *, /) 중 하나를 입력하세요. ");
			op = sc.next().charAt(0);
			
			if( (op != '+') && (op != '-') && (op != '*') && (op != '/')) {
				System.out.println("\n잘못 입력하셨습니다.(+, -, *, /) ");
				System.exit(0);
			} // if end
			
			System.out.print("su1 = "); su1 = sc.nextInt();
			System.out.print("su2 = "); su2 = sc.nextInt();
			
			switch ( op ) {
				case '+': result = su1 + su2; break;
				case '-': result = su1 - su2; break;
				case '*': result = su1 * su2; break;
				case '/': result = su1 / su2; break; // exception 
			} // switch end
			
			System.out.println("\n\n" + su1 +" "+ op +" " + su2 + " = " + result);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
//*/


/*
package quiz;

import java.util.Scanner;

public class Quiz_예외처리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int su1, su2, result=0;
		char op;
		
		System.out.print("## 연산자(+, -, *, /) 중 하나를 입력하세요. ");
		op = sc.next().charAt(0);
		
		System.out.print("su1 = "); su1 = sc.nextInt();
		System.out.print("su2 = "); su2 = sc.nextInt();
		
		switch ( op ) {
			case '+': result = su1 + su2; break;
			case '-': result = su1 - su2; break;
			case '*': result = su1 * su2; break;
			case '/': result = su1 / su2; break;
		} // switch end
		
		System.out.println("\n\n" + su1 +" "+ op +" " + su2 + " = " + result);
		
	}
}
//*/









