package ex01.This;

class Point {
	private int x, y;
	
	public Point() {
		this(2,3);  //반드시 첫줄에 있어야함
		System.out.println("Point default constructor");
	}
	
	public Point(int x) {

		this(x, 99);
		System.out.println("Point default constructor");
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
} // Point end

public class MainEntry {
	public static void main(String[] args) {
		Point pt = new Point();
		System.out.println(pt);
	}
} //MainEntry end






