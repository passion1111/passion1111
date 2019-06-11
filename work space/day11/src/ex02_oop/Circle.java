package ex02_oop;

public class Circle {
	private int x,y,r;

	public Circle(int x,int y){
		this.x=x;
		this.y=y;
		r=5;
	}
	public Circle(int r) {
		x=y=0;
		this.r=r;
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

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}
	public void display() {
		System.out.println(x+","+y+","+r);
	}

}
