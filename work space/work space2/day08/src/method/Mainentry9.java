package method;



class A {
	int x, y;
	//static method
	public static void setData(int xx, int yy) {
		System.out.println(xx + ", " + yy);
	}
} // A class end

public class Mainentry9 {
	public static void main(String[] args) {
		
		A a = new A(); //객체생성, 메모리에 할당, 생성자함수 자동호출
		a.x = 9;
		a.setData(100, 200);  //object.methodName();
		A.setData(3, 4);  //ClassName.methodName();
	}
}


	//- static method : 객체 생성 없이 바로 사용 가능함
//  object.methodName();
//  ClassName.methodName();  
/*
class A {
	default int x, y;
	
	public static void setData(int xx, int yy) {
		System.out.println(xx + ", " + yy);
	}
} // A class end

public class StaticMethod {
	public static void main(String[] args) {
		A a = new A(); //객체생성, 메모리에 할당, 생성자함수 자동호출
		A a =new A();//객체 생성 ,메모리에 할당 ,생성자 함수
		//한쌍의 괄호를 가지고있으면 함수 클래스명은 대문자 메소드명은 소문자
		//자기자신의 객체를 생성하는것을 생성자 함수라고 한다.
		//A의 키 a를 만들어내는것을 의미 
		a.x=9;//A클래스의 x에 9를 대입.
		a.setData(100, 200);
	}
	*/

/*
package ex02.method;

//- static method : 객체 생성 없이 바로 사용 가능함
//object.methodName();
//ClassName.methodName();  

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
*/