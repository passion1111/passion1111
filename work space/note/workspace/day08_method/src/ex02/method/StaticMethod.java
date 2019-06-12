package ex02.method;

//- static method : 객체 생성 없이 바로 사용 가능함
//  object.methodName();
//  ClassName.methodName();  

class A {
	int x, y;
	//static method
	public static void setData(int xx, int yy) {
		System.out.println(xx + ", " + yy);
	}
} // A class end

public class StaticMethod {
	public static void main(String[] args) {
		A a = new A(); //객체생성, 메모리에 할당, 생성자함수 자동호출
		a.x = 9;
		a.setData(100, 200);  //object.methodName();
		A.setData(3, 4);  //ClassName.methodName();
	}
}









