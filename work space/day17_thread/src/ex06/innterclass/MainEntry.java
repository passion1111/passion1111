package ex06.innterclass;


class OuterClass{
	static int no;
	String message="hi~~~";
	
	public void outerMethod() {
		System.out.println("outer method call~~~");
//		System.out.println(su); �ٱ������� �翬�� ����Ŭ���������� ���ٺҰ���.
	}
	
	class InnerClass{//����Ŭ����
			int su=999;
			public void show() {
				System.out.println(su);//����(�ڽ��ǰ�)��밡��
				System.out.println(message);//�ܺ�Ŭ���� ��� ��밡��.
			}
	
			public void disp() {
				outerMethod();//�ܺ�Ŭ���� ȣ��
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
