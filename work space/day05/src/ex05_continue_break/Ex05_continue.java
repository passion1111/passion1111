package ex05_continue_break;

import java.util.Scanner;

public class Ex05_continue {
    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		char ch=' ';
		String str=null;
		int count=0;
		System.out.println("아무 값이나 입력하세요. '!'를 누르면 탈출");
		//한줄만 받기떄문에 그 윗줄들은 모두 무시,esc 아스키 코드값 27
		
		while(true){
			str=sc.next();
			//ch= str.charAt(0);
		//	ch=sc.next().charAt(0);  //이것 없으면 break가 안됨. equals함수쓰지않는이상.
			if(ch=='q')break;
			count=str.length();
			
			
    }
		System.out.println("입력 받은 문자 갯수는 : "+count );
		
		
	}
}
