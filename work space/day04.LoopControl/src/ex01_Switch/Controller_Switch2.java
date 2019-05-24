

package ex01_Switch;

import java.util.Scanner;

public class Controller_Switch2 {
	public static void main(String[] args) {
		
		System.out.println("도시를 선택하세요 (s,d,b,j): ");
		String city=new Scanner(System.in).next();  //이것은 문자열입력받는거.
		
//		char ch=city.charAt(0); //charAt(0)의 기능은 문자열 함수 중에서 문자열 인덱스번호 0번쨰를 가져옴.
		//	Scanner sc=new Scanner(System.in);	
		//  char ch=스캔함수.next().charAt(0); 한번에 위  세줄 해결함
		
		
		switch (city) { // 조건-문자형,정수형(long형제외) ,실수형 안됨.
							// 문자열넣을려면 case에 " " 문자는 ' ' jdk6.0이상부터 문자열가능
		case "s":
			System.out.print("서울");
			break;        //break안걸면 밑에까지 쭉 실행됨.
		case "d":
			System.out.print("대구");
			break;		
		case "b":
			System.out.print("부산");
		case "j":
		 	System.out.print("제주도.");
		 	break;
		
		default:
			System.out.println("다시입력해주세요");
			System.exit(0);      //프로그램 강제종료 예전에는 0 정상종료 -1비정상종료 현재는 상관없음.
			

		}// switch end
			System.out.println("을(를) 선택하셨습니다.");
	}
}

