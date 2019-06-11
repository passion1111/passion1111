package ex03.inheritance;

public class Circle extends Point {  //»ó¼Ó
	private int r;

	public Circle() {
		super();
		System.out.println("circle constructor call");
	}
	public Circle(int x, int y, int r) {
		super();
		this.r = r;
	}
	public Circle(int r) {
		this.r = r;
		//x = y = 20;
	}
	
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	
	@Override
	public String toString() {
		return "Circle [r=" + r + ", x=" + x + ", y=" + y + "]";
	}
	
//	public String toString() {
//		String str = x + ", " + y + ", " + r;
//		return str;
//		//return x + ", " + y;
//	}
	
	//override method
	public void display() {
		super.display();
		System.out.println(", " + r);
	}
	
	
}





