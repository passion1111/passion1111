package ex02_collection_set;


class A{
	
	
}
class B extends A{
	
}

public class MainEntry {
	public static void main(String[] args) {
		A a=new A();
		B b=new B();
//		B a1=new A();//할수없음 A의 그릇을 B의 그릇에 담을수없음.
		
		System.out.println("a instanceof A "+(a instanceof A));//a는 a로만들어질수있음
		System.out.println("b instanceof A "+(b instanceof A));//b를 a에 넣을수있음. instanceof 연산자.
		System.out.println("a instanceof B "+(a instanceof B));//a를 b에 집어넣을수없음.
		System.out.println("b instanceof B "+(b instanceof B));//b는 b로만들어질수있음
	}
}
