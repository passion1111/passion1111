

package ex01_Switch;

import java.util.Scanner;

public class Controller_Switch3 {
	public static void main(String[] args) {
		
		System.out.println("당신의 포인트: ");
		int point=new Scanner(System.in).nextInt();
		
		switch (point) { // 조건-문자형,정수형(long형제외) ,실수형 안됨.
							// 문자열넣을려면 case에 " " 문자는 ' ' jdk6.0이상부터 문자열가능
		case 1:
			System.out.print("집 ");
		//	break;        //break안걸면 밑에까지 쭉 실행됨.
		case 2:
			System.out.print("피아노 ");
		//	break;		
		case 3:
			System.out.print("우산 ");
			break;          //누적해야하는 상황에는 break안걸면된다.
		default:
			System.out.println("다시입력해주세요");
			System.exit(0);      //프로그램 강제종료 예전에는 0 정상종료 -1비정상종료 현재는 상관없음.
			

		}// switch end
			System.out.println("상품에 당첨 되셨습니다.");
	}
}

