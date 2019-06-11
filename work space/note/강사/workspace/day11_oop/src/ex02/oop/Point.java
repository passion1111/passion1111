package ex02.oop;

public class Point extends Object {
	private int x, y;
	static int z;
	
	public Point() {
		x = y = 100;
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
	
	public void display() {
		System.out.println(x + ", " + y);
	}
	
	public static void main(String[] args) {
		Point pt = new Point();
		
		
	}
}




