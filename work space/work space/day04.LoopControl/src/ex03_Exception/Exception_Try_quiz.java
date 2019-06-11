package ex03_Exception;
//사칙연산 프로그램 작성
//숫자 2개 입력받고 ,연산자(+,-,*,/)1개 입력받아서 
// result>
//   3
//   4
//   5
//   3 +  5 = 8 
// 근데 0으로 나뉘었을떄는 예외처리해야하므로 try catch로 예외처리하기.
import java.util.Scanner;

public class Exception_Try_quiz {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("숫자2개와 연산할 사칙연산을 입력해주세요");
		int su1= sc.nextInt();
		int su2= sc.nextInt();
		int sum= su1+su2;
		int cha= su1-su2;
		int gob=su1*su2;
		double na=(float)su1/(float)su2;
		String a=sc.next();
		switch(a) {	
		case "+":
			 System.out.printf("%d + %d=%d",su1,su2,sum); break;
		case "-":
			 System.out.printf("\n %d - %d=%d",su1,su2,cha); break;
		case "*":  
			 System.out.printf("\n %d*%d=%d",su1,su2,gob); break;
		case "/": 
		{
			try {
				 System.out.printf("\n %d/%d=%.2f",su1,su2,na); break;
		
		} catch(Exception e) {  //e는 예외의 모든것
			e.printStackTrace();
			
			break;
		}	
		}
			 default: System.out.println("다시입력해주세요");
		}		
}
}


