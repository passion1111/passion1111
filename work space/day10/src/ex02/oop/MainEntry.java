package ex02.oop;
//�� Ŭ�������Ͼȿ� �������� Ŭ������ �����
//public�� main method�ִ°��� public�ϳ��� �ٿ�����.
class Point {
	private int x, y;  //������� - int :0, double :0.0, String :NULL
	
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
		
		private int x,y,z;//�������
		//setter,getter method <- ��� �Լ�
		public  void setX(int xx) {	x=xx;}
		public  void setY(int yy) { y=yy;}
		public  void setZ(int zz) {	z=zz;}
		//�Ű������� ��������� �����ҷ��� int x, x=x�� �����ҷ����ϸ�
		//�´� �Ű������� �ν��� �ع���.
		//�׷��� this.x�� ����������� ����Ŵ(�������) �׷��� ��������� �Ű������� �ٸ��� �ν��ϰ��Ҽ�����.
//		  �׷��� �Լ����� �Ƴ����� ����.
//		this�� �ڱ��ڽ� ��ü�� �����ɋ� �� ��ü�� ���� �ּҸ� ������ ����.
		public  int getX() {	return x;	}
		public  int gety() {	return y;	}
		public  int getz() {	return z;	}
		public void disp() {
			System.out.println(getX()+","+gety()+","+getz());
			// sysout(x+","+y+","+z);�� ����.
		}

	}
	class Rect{
		private int x,y,x2,y2;
		//setter,getter method �������
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


