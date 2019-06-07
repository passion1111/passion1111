package ex04_multiimplements;

import ex02_interface.IDraw;

public class Multiclass extends Shape implements IDraw, TEst {

	int num=129;
	
	@Override
	public void view() {
		System.out.println("test interface");

	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	System.out.println("IDraw interface");
	}

	@Override
	public double calc(double x) {
		System.out.println("Shape extends");
		return 0;
	}

	@Override
	public double calc(double x, double y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void show(String name) {
		// TODO Auto-generated method stub
		
	}

}
