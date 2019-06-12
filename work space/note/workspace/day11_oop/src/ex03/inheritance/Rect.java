package ex03.inheritance;

public class Rect extends Point {
	private int x2, y2;

	public Rect() {
		super();		
	}

	public Rect(int x2, int y2) {
		//super(x, y);
		this.x2 = x2;
		this.y2 = y2;		
	}

	public Rect(int x,int x2, int y2) {
		super(x);
		this.x2 = x2;
		this.y2 = y2;	
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	@Override
	public String toString() {
		return "Rect [x2=" + x2 + ", y2=" + y2 + ", x=" + x + ", y=" + y + "]";
	}
	
	
	
//	public String toString() {
//		String str = x + ", " + y + ", " + x2 + ", " + y2;
//		return str;
//		
//	}
	
	//override method
	public void display() {
		super.display();
		System.out.println(", "+ x2 + ", " + y2);
	}
	

}
