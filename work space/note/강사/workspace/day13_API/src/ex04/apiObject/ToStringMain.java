package ex04.apiObject;

class Rectangle  { // extends Object {
	int x, y;
	public void disp() { //��� ��� �Լ� ���� �������
		System.out.println(x + ", " + y);
	}
	@Override
	public String toString() {
		return "Rectangle [x=" + x + ", y=" + y + "]";
	}
	
//	public String toString() {  
//		return x + ", " + y;
//	}
	
}

public class ToStringMain {
	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		r.disp();
		System.out.println(r);  //toString() override �ؼ� ��� ����
//		System.out.println(r.toString());
	}
}









