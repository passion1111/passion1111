package array;

import java.util.Scanner;

public class MainEntry4 {

		public static void main(String[] args) {
			int NUM = 0, sum = 0;
			
			System.out.println("�迭ũ�� �����ϱ� : ");
			NUM = new Scanner(System.in).nextInt();
			int[] a = new int[NUM];  //[size] - size�� int�� �����͸�..
			
			//System.out.println(a.length);
			System.out.println("data input = ");
			for (int i = 0; i < a.length; i++) {
				System.out.print((i+1)+"��° ������ = ");
				a[i] = new Scanner(System.in).nextInt();
				sum += a[i];
			}
			System.out.println("sum = " + sum);
			for (int i = 0; i < a.length; i++) {
				System.out.println("a[" + i + "]= " + a[i]);
			}
			
		}
	}	
	//*/

	/*
	package ex01.array;

	//����1] int[] a = {7, 5, 3, 8, 2 }; �迭�� �� ���ϴ� ���α׷��ۼ�
	public class ArrayEx4 {
		public static void main(String[] args) {
			int[] a = {7, 5, 3, 8, 2,5, 6, 9, 10};
			int arrayTotal = 0;
			//arrayTotal = a[0] + a[1]+ a[2] + a[3] + a[4];
			//System.out.println(arrayTotal);
			
			for (int i = 0; i < a.length; i++) {
				//arrayTotal = arrayTotal + a[i];
				arrayTotal += a[i];
			}
			
			System.out.println("�迭 ������ �� : " + arrayTotal);
		}
	}	
	//*/


