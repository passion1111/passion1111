// 문제2] 기상청. 특정달의 강수량 평균을 구하는 프로그램 작성(단, 30일 기준)

package quiz;

import java.util.Scanner;

public class Quiz_02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num = 30;
		int[] a = new int[num];
		int sum = 0;
		int avg = 0;

		for (int i = 0; i < a.length; i++) {
			System.out.println((i + 1) + "번째 강수량을 입력하세요 : ");
			a[i] = new Scanner(System.in).nextInt();
			sum += a[i];

		} // end for
		avg = sum / a.length;

		System.out.println("-----강수량 평균-----");
		System.out.println(avg);

	} // end main
} // end class
