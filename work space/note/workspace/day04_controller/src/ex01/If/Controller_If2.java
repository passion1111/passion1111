package ex01.If;

import java.util.Scanner;

public class Controller_If2 {
	public static void main(String[] args) {
		
		System.out.print("integer data input : ");
		int su = new Scanner(System.in).nextInt();
		
				
		if(su % 2 == 0) {
			System.out.println("짝수");
			
			if( su > 0 ) {
				System.out.println("양수");
			} else if( su < 0 ) {
				System.out.println("음수");
			} else {
				System.out.println("0이군요");
			}
		}
		else {
			
			System.out.println("홀수");
			
			if( su > 0 ) {
				System.out.println("양수");
			} else if( su < 0 ) {
				System.out.println("음수");
			} else {
				System.out.println("0이군요");
			}
		}// if end
	}
}




