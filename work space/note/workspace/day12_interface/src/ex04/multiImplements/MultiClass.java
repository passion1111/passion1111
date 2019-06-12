package ex04.multiImplements;

import ex02.Interface.IDraw;
import ex03.Abstract.Shape;

public class MultiClass extends Shape 
						implements Test, IDraw {
	
	int num = 129;

	@Override
	public void draw() {
		System.out.println("IDraw interface");
	}

	@Override
	public double calc(double x) {
		System.out.println("Shape abstract class");
		return 5.5;
	}

	@Override
	public void show(String name) {
		System.out.println("Shape abstract class show method");
	}

	@Override
	public void view() {
		System.out.println("Test interface");
	}

}







