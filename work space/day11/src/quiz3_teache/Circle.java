package quiz3_teache;

import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

public class Circle extends Draw {  // Sub class
	
	public Circle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("반지름 값은 = ");
		this.w = sc.nextInt();
		
	}
	
	public double calc() {
		this.result = (double)(w * w * Math.PI);
		
		return result;
	}
	
	public void show() {
		System.out.println(w + ", " + calc());
	}

	@Override
	public String toString() {
		result = calc();
		return "Circle [반지름 = " + w + ", 원의 넓이=" + result + "]";
	}
	
	

}
