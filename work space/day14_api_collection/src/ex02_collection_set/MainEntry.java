package ex02_collection_set;


class A{
	
	
}
class B extends A{
	
}

public class MainEntry {
	public static void main(String[] args) {
		A a=new A();
		B b=new B();
//		B a1=new A();//�Ҽ����� A�� �׸��� B�� �׸��� ����������.
		
		System.out.println("a instanceof A "+(a instanceof A));//a�� a�θ������������
		System.out.println("b instanceof A "+(b instanceof A));//b�� a�� ����������. instanceof ������.
		System.out.println("a instanceof B "+(a instanceof B));//a�� b�� �������������.
		System.out.println("b instanceof B "+(b instanceof B));//b�� b�θ������������
	}
}
