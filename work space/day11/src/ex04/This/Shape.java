package ex04.This;

public class Shape {
	int x,y,result;
	
	public void display() {
		System.out.println(x+","+y);
	}

	public Shape() {
		this(1,2);
	}
	public Shape(int x) {
		this(x,9999);
		//		this.x=x;
	}
	public Shape(int x,int y) {
		this.x=x;
		this.y=y;
	}

}
