/*����6] ��Ģ���� ���α׷� �ۼ�(����ó���ϱ�)
  ���� 2�� �Է� �ް�, ������(+, -, *, /) 1�� �Է� �޾Ƽ�
  ( if, switch �̿� ) 

   
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

public class Quiz_����ó�� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int su1, su2, result=0;
		//char op;
		String op = null;  //���ڿ��� ó���ϱ� ����
		
		try {
			System.out.print("## ������(+, -, *, /) �� �ϳ��� �Է��ϼ���. ");
			op = sc.next(); //������ ���ڿ��� �Է� �ޱ�
			
//			if( (op != '+') && (op != '-') && (op != '*') && (op != '/')) {
//				System.out.println("\n�߸� �Է��ϼ̽��ϴ�.(+, -, *, /) ");
//				System.exit(0);
//			} // if end
			
			System.out.print("su1 = "); su1 = sc.nextInt();
			System.out.print("su2 = "); su2 = sc.nextInt();
			
			//if �� ó��
			// == ����
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

public class Quiz_����ó�� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int su1, su2, result=0;
		char op;
		
		try {
			System.out.print("## ������(+, -, *, /) �� �ϳ��� �Է��ϼ���. ");
			op = sc.next().charAt(0);
			
			if( (op != '+') && (op != '-') && (op != '*') && (op != '/')) {
				System.out.println("\n�߸� �Է��ϼ̽��ϴ�.(+, -, *, /) ");
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

public class Quiz_����ó�� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int su1, su2, result=0;
		char op;
		
		System.out.print("## ������(+, -, *, /) �� �ϳ��� �Է��ϼ���. ");
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









