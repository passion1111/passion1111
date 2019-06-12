package ex01.oop;

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
		//System.out.println(getX() + ", " + getY());
		System.out.println(x + ", " + y);
	}

} // Point end


public class MainEntry {
	public static void main(String[] args) {
//		int su=9 ;
//		System.out.println(su);
		Point pt = new Point(); //객체생성,메모리에 할당, 생성자함수 자동호출
		//setting before call
		System.out.println(pt.getX() + ", " + pt.getY());
		
		//pt.setXY(100, 200); // setter method call setting 
		pt.setY(200);  pt.setX(100);
		pt.disp();
		//System.out.println(pt.getX() + ", " + pt.getY());
		pt.setY(90);
		pt.disp();
		//System.out.println(pt.getX() + ", " + pt.getY());
		pt.setY(8);
		System.out.println(pt.getX() + ", " + pt.getY());
		
	}

} // MainEntry class end










