package ex01.next;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		// next() vs nextLine() 메모리?
		
		Scanner sc = new Scanner(System.in);
		
//		String name = sc.nextLine();
//		String s = sc.nextLine();
		
		String name = sc.next();
		sc.next();		 sc.next();  // 공백처리함 
		String s = sc.next();
		
		System.out.println(name+ ", " + s);

	}
}










