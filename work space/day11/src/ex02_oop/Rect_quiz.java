package ex02_oop;
//����1] Rect class=x,y,x2,y2
public class Rect_quiz {
	int x,y,x2,y2;
//�������Լ� ���ڵ� ���� ���ʿ���� alt+shift+s������ �������Լ� ������  constructor using field <-���ڰ�����
//	constructor from super class ���ڰ����°�. 
	public Rect_quiz(int x) {
		y=y2=x2=100;
		this.x=x;
	}
	public Rect_quiz(int x,int y) {
		y2=x2=100;
		this.x=x;
		this.y=y;
	}
	public Rect_quiz(int x,int y,int x2,int y2) {
		
		this.x=x;
		this.x2=x2;
		this.y=y;
		this.y2=y2;
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
	public void display() {
		System.out.println(x+","+y+","+x2+","+y2);
	}

}
