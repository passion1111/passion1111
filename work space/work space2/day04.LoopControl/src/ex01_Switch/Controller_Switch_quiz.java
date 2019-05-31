package ex01_Switch;

import java.util.Scanner;

//문제4 짝,홀수 판정 switch~case로 만들기
public class Controller_Switch_quiz {
	public static void main(String[] args) {
		
		int point=new Scanner(System.in).nextInt();
		
			switch (point%2) { // 조건-문자형,정수형(long형제외) ,실수형 안됨.
								// 문자열넣을려면 case에 " " 문자는 ' ' jdk6.0이상부터 문자열가능
			case (0):
				System.out.println("짝수입니다.");
				break;
	
			case 1:
				System.out.println("홀수입니다.");
				break;
	
			
			default:
				System.out.println("다시입력해주세요");
				
				
		}// switch end
			
	}
}