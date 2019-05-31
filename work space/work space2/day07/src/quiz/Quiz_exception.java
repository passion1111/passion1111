package quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

//두수 입력받아서 나눗셈하는 프로그램 작성(예외ㅓ리
// 숫자가 아닌 문자 입력 됐을떄
// 정수가 아닌 실수 데이터 입력됐을떄
// 어떤 수를 0으로 나눌수 없다.
public class Quiz_exception {
	public static void main(String[] args) {
		int i=0,j=0;
		
		Scanner sc=new Scanner(System.in);
		double na=0;
		
		try {
			i=sc.nextInt();
			j=sc.nextInt();
			na=i/j;
			na= (double)i/j;
			System.out.println(na);
			
		}catch(NumberFormatException e ) {
			System.out.println("정수를 입력해주세요");
			
			
		}catch(InputMismatchException e) {
			System.out.println("숫자를 입력하세요");
		}
		catch(ArithmeticException e) {
			System.out.println("0으로 나눌수 없습니다."); 
		}


}
}
