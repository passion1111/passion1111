package ex02.method;

//- static method : ��ü ���� ���� �ٷ� ��� ������
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
		A a = new A(); //��ü����, �޸𸮿� �Ҵ�, �������Լ� �ڵ�ȣ��
		a.x = 9;
		a.setData(100, 200);  //object.methodName();
		A.setData(3, 4);  //ClassName.methodName();
	}
}









