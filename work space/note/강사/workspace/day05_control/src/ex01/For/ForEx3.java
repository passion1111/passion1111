package ex01.For;

import java.util.Scanner;

//문제5] 원하는 단을 입력 받아서 구구단 출력하는 프로그램 작성
public class ForEx3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("dan = ");
		int dan = sc.nextInt();
		
		for(int i=1; i<= 9; i++) {
//			System.out.println(dan + " * " + i + " = " + (dan*i));
			System.out.printf("%d *%2d=%2d\n", dan, i, (dan*i));
		} // end for
	}
}





