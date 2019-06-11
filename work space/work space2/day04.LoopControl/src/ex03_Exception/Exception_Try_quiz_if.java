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

public class Exception_Try_quiz_if {
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
		String a1="+";
		String a2="-";
		String a3="*";
		String a4="/";
	
		if(a.equals("+"))  {  //char이면 비교가능 입력을 변수=스캐너변수명.next().charAt(배열순서)으로받아야함.
//			                         ==는 값비교 String 변수는 "A"의 경우A뒤에\0(null)값이 들어가있으므로값이다르고
//									%s는 null문자만나기전까지 출력 String타입은 객체이기떄문. char는 값으로 비교가능.
//			                       String은 객체이므로(클래스이므로) new를 선언해줘야하지만 print안에 들어가서 비교하는것(System.out.print<-여기의 프린트)
//                                 비교할려면 변수.equals("문자열"); 연산자를 변수받고나서 아래에서 next와 nextLIne으로받으면 문제생길수있음.
			System.out.printf("%d + %d=%d",su1,su2,sum);
		}
		else if(a.equals(a2)) {
             System.out.printf("\n %d - %d=%d",su1,su2,cha);
		}
		else if(a.equals(a3))
		{
		 System.out.printf("\n %d*%d=%d",su1,su2,gob); 
		}
		else if(a.equals(a4))
						try {
					System.out.printf("\n %d/%d=%.2f",su1,su2,na); 
}
						catch(ArithmeticException e) {
					  System.out.print("0으로 나눌수없습니다.");
		}
		
}
}

//실수형타입의 경우 0으로 받았을때는 formatmismatch로 데이터타입변환을시켜줌.
//또는 inputmismatchexception으로 입력값이 잘못됐다고 예외처리하면됨.

