package quiz3_teache;

import java.util.Scanner;

public class Triangle extends Draw {  //Sub class
	
	public Triangle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("≥–¿Ã = ");
		this.w = sc.nextInt();
		System.out.print("≥Ù¿Ã = ");
		this.h = sc.nextInt();
	}
	
	public void show() {
		System.out.println(w + ", " + h);
	}
	public double calc() {
		result=(double)w*h/2;
		return result;
		
	}
	
}
