package ex06.innterclass;


class OuterClass{
	static int no;
	String message="hi~~~";
	
	public void outerMethod() {
		System.out.println("outer method call~~~");
//		System.out.println(su); 바깥에서는 당연히 내부클래스에대한 접근불가능.
	}
	
	class InnerClass{//내부클래스
			int su=999;
			public void show() {
				System.out.println(su);//내부(자신의것)사용가능
				System.out.println(message);//외부클래스 멤버 사용가능.
			}
	
			public void disp() {
				outerMethod();//외부클래스 호출
			}
	}//Inner class end
	
}//Outerclass end
public class MainEntry {
	public static void main(String[] args) {
		//1.
//		OuterClass oc=new OuterClass();
//		OuterClass.InnerClass inner=oc.new InnerClass();
//		inner.disp();
//		inner.show();
		
		//2.
		OuterClass.InnerClass ic=new OuterClass().new InnerClass();
		ic.show();
	}

}
