package ex03.exception;

import java.util.Scanner;

public class ExceptionEx1 {
	public static void main(String[] args) {
		
		try {
			System.out.print("x , y = ");
			int x = new Scanner(System.in).nextInt();
			int y = new Scanner(System.in).nextInt();
			System.out.println(x / y);  // �� / 0 <--- �Ҵ�
		} catch(Exception e) {
			//System.out.println("0���� ������ �����ϴ�.");
			//System.out.println(e.getMessage());
			e.printStackTrace();  
		}// try end
		
		/*
		 * System.out.print("x , y = "); int x = new Scanner(System.in).nextInt(); int y
		 * = new Scanner(System.in).nextInt();
		 * 
		 * if(y == 0) { System.out.println("0���� ������ �����ϴ�."); System.exit(0); }
		 * 
		 * System.out.println(x / y); // �� / 0 <--- �Ҵ�
		 */	}
}
