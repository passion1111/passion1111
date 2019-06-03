package ex02.oop;
//한 클래스파일안에 여러개의 클래스를 만들면
//public은 main method있는곳에 public하나만 붙여야함.
class Point {
	private int x, y;  //멤버변수 - int :0, double :0.0, String :NULL
	
//	public void setXY(int xx, int yy) {
//		x = xx;		y = yy;
//	}
	public void setX(int xx) {  x = xx; }
	public void setY(int yy) {  y = yy; }
	public int getX() {	return x;	}
	public int getY() {	return y;	}
	public void disp() {
		System.out.println(getX() + ", " + getY());
		System.out.println(x + ", " + y);
	}
}
	class Circle{
		
		private int x,y,z;//멤버변수
		//setter,getter method <- 멤버 함수
		public  void setX(int xx) {	x=xx;}
		public  void setY(int yy) { y=yy;}
		public  void setZ(int zz) {	z=zz;}
		//매개변수가 멤버변수를 세팅할려고 int x, x=x로 설정할려고하면
		//셋다 매개변수로 인식을 해버림.
		//그래서 this.x로 멤버변수임을 가르킴(멤버변수) 그래서 멤버변수와 매개변수랑 다르게 인식하게할수있음.
//		  그래서 함수명을 아낄수가 있음.
//		this는 자기자신 객체가 생성될떄 그 객체의 시작 주소를 가지고 있음.
		public  int getX() {	return x;	}
		public  int gety() {	return y;	}
		public  int getz() {	return z;	}
		public void disp() {
			System.out.println(getX()+","+gety()+","+getz());
			// sysout(x+","+y+","+z);도 가능.
		}

	}
	class Rect{
		private int x,y,x2,y2;
		//setter,getter method 멤버변수
		public void setX(int x) {		this.x=x;	}
		public void setY(int y) {		this.y=y;	}
		public void setX2(int x2) {		this.x2=x2;	}
		public void setY2(int y2) {	this.y2=y2;	}
		//getter
		public int getX(int x) {		return x;	}
		public int getY(int y) {		return y;	}
		public int getX2(int x2) {		return x2;	}
		public int getY2(int y2) {		return y2;	}
		//disp
		public void disp() {	System.out.println(x+","+x2+","+y+","+y2);	}	
		
	}	
	
public class MainEntry {
	public static void main(String[] args) {
		
	}
}


