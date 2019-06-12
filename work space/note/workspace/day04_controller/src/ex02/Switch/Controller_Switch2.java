//*
package ex02.Switch;

import java.util.Scanner;

public class Controller_Switch2 {
	public static void main(String[] args) {
		System.out.print("도시를 선택하세요(s,d,b,j) = ");
		Scanner sc = new Scanner(System.in);
//		String str = sc.next(); //문자열 입력 받기 
//		char ch = str.charAt(0);  //문자열 함수 중에 문자열에서 charAt(index) 인덱스번호 문자 가져오는 함수 

		char ch = sc.next().charAt(0);
		
		switch (ch) { 
			case 's': System.out.print("서울"); break;
			case 'd': System.out.print("대구"); break;
			case 'b': System.out.print("부산"); break;
			case 'j': System.out.print("제주"); break;
			
			default : 
				System.out.print("잘못 눌렀습니다. s,d,b,j중에서만 선택하세요....");
				System.exit(0);  // 프로그램 강제 종료
		} //switch end
		
		System.out.println("를(을) 선택하셨습니다. ");
	}
}

//*/


/*
package ex02.Switch;

import java.util.Scanner;

public class Controller_Switch2 {
	public static void main(String[] args) {
		System.out.print("도시를 선택하세요(s,d,b,j) = ");
		Scanner sc = new Scanner(System.in);
		String ch = sc.next(); //문자열 입력 받기 
		
		switch (ch) { 
			case "s": System.out.print("서울"); break;
			case "d": System.out.print("대구"); break;
			case "b": System.out.print("부산"); break;
			case "j": System.out.print("제주"); break;
			
			default : 
				System.out.print("잘못 눌렀습니다. s,d,b,j중에서만 선택하세요....");
				System.exit(0);  // 프로그램 강제 종료
		} //switch end
		
		System.out.println("를(을) 선택하셨습니다. ");
	}
}

//*/





