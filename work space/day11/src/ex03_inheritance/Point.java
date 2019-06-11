package ex03_inheritance;

public class Point {
	protected int x,y;

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

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Point(int x) {
		super();
		this.x = x;
	}

	public Point() {
		x=y=10;
		System.out.println("부모가 만들어졌다.");
	}
	public void display() {
		System.out.println(x+","+y);
	}

}
