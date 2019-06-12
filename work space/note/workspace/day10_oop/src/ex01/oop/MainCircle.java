package ex01.oop;

class Circle{
	//멤버변수
	private int x, y, r;
	//setter, getter method  - 멤버함수
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

public class MainCircle {
	// 객체 생성해서 출력 하기
	public static void main(String[] args) {
		//객체생성, 메모리에 할당, 생성자함수 자동호출
		Circle c = new Circle();
		c.disp();
		c.setR(5);  c.setX(100); c.setY(100);	c.disp();
		
		Circle c2 = new Circle();
		c2.setR(50);  c2.setX(10); c2.setY(20);	c2.disp();
		
	}
}









