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
		
		A a = new A(); //��ü����, �޸𸮿� �Ҵ�, �������Լ� �ڵ�ȣ��
		a.x = 9;
		a.setData(100, 200);  //object.methodName();
		A.setData(3, 4);  //ClassName.methodName();
	}
}


	//- static method : ��ü ���� ���� �ٷ� ��� ������
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
		A a = new A(); //��ü����, �޸𸮿� �Ҵ�, �������Լ� �ڵ�ȣ��
		A a =new A();//��ü ���� ,�޸𸮿� �Ҵ� ,������ �Լ�
		//�ѽ��� ��ȣ�� ������������ �Լ� Ŭ�������� �빮�� �޼ҵ���� �ҹ���
		//�ڱ��ڽ��� ��ü�� �����ϴ°��� ������ �Լ���� �Ѵ�.
		//A�� Ű a�� �����°��� �ǹ� 
		a.x=9;//AŬ������ x�� 9�� ����.
		a.setData(100, 200);
	}
	*/

/*
package ex02.method;

//- static method : ��ü ���� ���� �ٷ� ��� ������
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
		A a = new A(); //��ü����, �޸𸮿� �Ҵ�, �������Լ� �ڵ�ȣ��
		a.x = 9;
		a.setData(100, 200);  //object.methodName();
		A.setData(3, 4);  //ClassName.methodName();
	}
}
*/