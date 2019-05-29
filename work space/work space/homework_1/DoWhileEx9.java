package ex04.While;

import java.util.Scanner;

/*문제6]이름 입력받고,
점수 3개(k, e, c)- 0~100점수만 입력받기, 
총점 평균 구하는 프로그램작성*/
public class DoWhileEx9 {
	public static void main(String[] args) {
		
		String name=null;
		int k, e, c;
		char op =' ';
		
		Scanner sc = new Scanner(System.in); //입력 그릇 생성
		System.out.print("name = ");
		name = sc.nextLine();
		
		do {
			System.out.print("kor = ");
			k = sc.nextInt();		
		}while(k < 0 || k > 101);
		
		do {
			System.out.print("eng = ");
			e = sc.nextInt();
		}while(e < 0 || e > 101);
		
		do {
			System.out.print("com = ");
			c = sc.nextInt();
		}while(c < 0 || c > 101);
		
		do {
			System.out.print("op(+,-,*,/) = ");
			op = sc.next().charAt(0);
			
		}while((op != '+') && (op != '-') &&(op != '*') &&(op != '/'));
		
		System.out.println(k + " " +  op + " " + e ); // 국어점수 연산자 영어점수
		System.out.println(name + ", " + k + ", " + e + ", " + c);
				
		
	}
}














