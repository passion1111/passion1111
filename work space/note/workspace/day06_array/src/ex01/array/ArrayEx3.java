package ex01.array;

import java.util.Scanner;

public class ArrayEx3 {
	public static void main(String[] args) {
		int[] a = new int[5];
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 데이터 1개 입력 : ");
		int x = sc.nextInt();
		System.out.println("array data 5개 입력 : ");
//		a[0] = sc.nextInt();
//		a[1] = sc.nextInt();
//		a[2] = sc.nextInt();
//		a[3] = sc.nextInt();
//		a[4] = sc.nextInt();
		
		for(int i=0; i < a.length; i++) {
			System.out.println((i+1)+"번째 데이터 = ");
			a[i] = sc.nextInt();
		}
		
		System.out.println("x = " + x);
		System.out.println("\n-------------------------");
		for(int i=0; i < a.length; i++) {
			System.out.println("a[" + i + "] = " + a[i]);
		}
		
		System.out.println("\n-------------------------");
		for(int i=0; i < a.length; i++) {
			System.out.println((i+1)+"번째 데이터 = " + a[i]);
		}
		
	}
}













