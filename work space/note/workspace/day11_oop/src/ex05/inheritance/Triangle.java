package ex05.inheritance;

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
		System.out.println(w + ", " + h + ", result = " + calc() );
	}
	
	public double calc() {
		this.result = (w * h) / 2.0;
		
		return result;
	}

	@Override
	public String toString() {
		result = calc();
		return "Triangle [w=" + w + ", h=" + h + ", result=" + result + "]";
	}
	
}







