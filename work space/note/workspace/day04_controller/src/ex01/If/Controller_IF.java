package ex01.If;

import java.util.Scanner;  //

public class Controller_IF {

	public static void main(String[] args) {
		System.out.print("integer data input : ");
		int su = new Scanner(System.in).nextInt();
		
		//짝,홀수 판정 if
		if(su % 2 == 0) {
			System.out.println("짝수");
		}
		else {
			System.out.println("홀수");
		}// if end
		
		System.out.println("===============");
		
		// 양수,음수,0 판정 if
		if(su > 0) {
			System.out.println("양수");
		}
		else if(su < 0) {
			System.out.println("음수");
		}
		else System.out.println("0이군요");
	}

}








