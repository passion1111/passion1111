package ex03_Exception;
//사칙연산 프로그램 작성
//숫자 2개 입력받고 ,연산자(+,-,*,/)1개 입력받아서 
// result>
//   3
//   4
//   5
//   3 +  5 = 8 
// 근데 0으로 나뉘었을떄는 예외처리해야하므로 try catch로 예외처리하기. if
import java.util.Scanner;

public class Exception_Try_quiz_teacher {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("숫자2개와 연산할 사칙연산을 입력해주세요");
		int su1,su2,result=0;
		char op;
		System.out.println("## 연산자(+,-,*,/)중 하나를 입력하세요. ");
		op=sc.next().charAt(0);//문자열 7.0이전에는 못받았기떄문에 char로 처리하기위한 방법
		System.out.println("##su1="); su1=sc.nextInt();
		System.out.println("##su2="); su2=sc.nextInt();
		
		
		switch(op) {
		case '+' :result=su1+su2;break;
		case '-' :result=su1-su2;break;
		case '*' :result=su1*su2;break;
		case '/' :result=su1/su2;break;
		default:System.out.println("다시입력해주세요");
		break;
		}
		System.out.println("결과는 su1"+op+"su2="+result);
	}
}
		//if((op!='+'))&&(op!='-')&&(op!='*')&&(op!='/')
//		사칙연산이외가 입력됐을떄를위한 비교

