package homework;

import java.util.Scanner;

public class Homework_01 {

	public static void main(String[] args) {
		try {
		
		
		// 3개 정수 입력받아서 큰 순서대로 출력
//		3항 / 10진법
		/*
		 * result 
			5 > 4> 3 각 항의 숫자를 셔플해서
			넣어보자 (검사)
		 */
		String str1, str2, str3 = null;
		System.out.println("비교할 3개의 정수를 입력하시오. ");
		System.out.print("\nA항 : ");
		int a = new Scanner(System.in).nextInt();
		System.out.print("\nB항 : ");
		int b = new Scanner(System.in).nextInt();
		System.out.print("\nC항 : ");
		int c = new Scanner(System.in).nextInt();
//		321
		
		
		if((a>b)&&(a>c)) {
		
			str1 = (a > b && ( b > c )) ? ("A항 : "+a+" > " + "B항 : "+b+" > "+"C항 : " +c) 
				: (a > b && ( c > b )) ? ("A항 : "+a+" > " + "C항 : "+c+" > "+"B항 : " +b) : "비교 대상이 아닙니다";
				
				System.out.println(str1);	
		}
		else if ((b>c)&&(b>a)) {
		str2 = (b > a && ( a > c )) ? ("B항 : "+b+" > " + "A항 : "+a+" > "+"C항 : " +c) 
						: (b > c && ( c > a )) ? ("B항 : "+b+" > " + "C항 : "+c+" > "+"A항 : " +a) : "비교 대상이 아닙니다";
						
						System.out.println(str2);
		}
		else if ((c>b)&&(c>a)) {
		str3 = (c > a && ( a > b )) ? ("C항 : "+c+" > " + "A항 : "+a+" > "+"B항 : " +b) 
								: (c > b && ( b > a )) ? ("C항 : "+c+" > " + "B항 : "+b+" > "+"A항 : " +a) : "비교 대상이 아닙니다";
								
								System.out.println(str3);
		}
		}				
		
		  catch(Exception e) {  System.out.println("입력하신신 값이 숫자가 아닙니다.");  
		  e.printStackTrace();}
		  
		
		

		
		
		
		
		
	}

}
