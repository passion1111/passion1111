package ex03.inheritance;

public class Point {
	protected int x, y;  //접근지정자 보호모드
	
	public Point() {
		x = y = 10;
		System.out.println("point default call~~~");
	}

	public Point(int x, int y) {
		super(); // Object class의 디폴트 생성자함수 
		this.x = x;
		this.y = y;
		System.out.println("point 2");
	}

	public Point(int x) {
		super();
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
//	public String toString() {
////		String str = x + ", " + y;
////		return str;
//		return x + ", " + y;
//	}
	
	public  void display() {
		System.out.print(x + ", " + y);
	}
	
}	

//class Circle extends Point {
//	int r;
//	
//	public void display() {
//		System.out.println(x + ", " + y);
//	}
//}
























