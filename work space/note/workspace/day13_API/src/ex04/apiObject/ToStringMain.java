package ex04.apiObject;

class Rectangle  { // extends Object {
	int x, y;
	public void disp() { //멤버 출력 함수 따로 만들었음
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
		System.out.println(r);  //toString() override 해서 사용 가능
//		System.out.println(r.toString());
	}
}









