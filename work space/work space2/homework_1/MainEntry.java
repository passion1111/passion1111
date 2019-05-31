package ex05_break_continue;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ch =' ';
		String str = null;
		int count =0;
		
		System.out.println("아무 값이나 입력하세요. "
								+ "'!' 를 누르면 탈출 : ");
		
		
		while( true ) { // 무한루프.. <-- 탈출 구문을 넣어라
			str = sc.next();
			ch = str.charAt(0);
//			ch = sc.next().charAt(0);
			
			count = str.length();  // 1개만 받음 - !
			
			//탈출 구문 
			if( ch == '!' ) break; //if( ch == 'q' ) break;
//			count = str.length();
			
		} // while end
		
		System.out.println("입력 받은 문자 갯수는 : " + count + "개.");
		
	}
}








