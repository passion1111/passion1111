package ex02.oop;

class Point {
	private int x, y;  //¸â¹öº¯¼ö - int :0, double :0.0, String :NULL

	public void setX(int xx) {  x = xx; }
	public void setY(int yy) {  y = yy; }
	public int getX() {	return x;	}
	public int getY() {	return y;	}
	public void disp() {
		//System.out.println(getX() + ", " + getY());
		System.out.println(x + ", " + y);
	}
} // Point end


class Circle{
	//¸â¹öº¯¼ö
	private int x, y, r;
	//setter, getter method  - ¸â¹öÇÔ¼ö
	public int getX() {	return x;	}
	public void setX(int x) {	
		this.x = x;	
	}
	
	public int getR() {	return r;	}
	public void setR(int r) {	this.r = r;	}
	
	public int getY() {	return y;	}
	public void setY(int y) {	this.y = y;	}
	//output method 
	public void disp() {
		//System.out.println(getX() +", " + getY() + ", " + getR());
		System.out.println(x +", " + y + ", " + r);
	}
} // circle end

class Rect {
	int x, y, x2, y2;
	//setter, getter method  - ¸â¹öÇÔ¼ö
	
	//output method 
	
} // Rect end

public class MainEntry {
	public static void main(String[] args) {
		
	}
}






