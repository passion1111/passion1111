package ex03.input;

import java.util.Scanner;

public class InputTest2  {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// next() vs nextLine()
		System.out.println("string input : ");
		//String s1 = sc.next();  // 공백 인식 못함
		String s1 = sc.nextLine();
		
		System.out.println(s1);
		
		System.out.println("===================");
		System.out.println("integer , double data input : ");
		int num = sc.nextInt();
		double num2 = sc.nextDouble();
		System.out.println(num + ", " + num2);		
		
	}
}









