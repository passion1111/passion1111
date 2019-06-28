package ex06.inner;


class OuterClass {  //�ܺ�Ŭ����
	static int no;
	String message = "hi~~~";
	
	public void outerMethod() {
		System.out.println("outer method call~~~");
		//System.out.println(su); //inner class ��� ���ٺҰ���
	}
	
	class InnerClass { //����Ŭ����
		
		int su = 999;
		public void show() {
			System.out.println(su); //����(�ڽ��ǰ�) ��� ����
			System.out.println(message); //�ܺ�Ŭ���� ��� ��밡��
		}
		
		public void disp() {
			outerMethod(); // �ܺ�Ŭ���� �޼ҵ� ȣ��
		}
	}//InnerClass end
	
} //OuterClass end

public class MainEntry {
	public static void main(String[] args) {
		//1.
		OuterClass oc = new OuterClass();
		OuterClass.InnerClass inner = oc.new InnerClass();
		inner.disp();		inner.show();
		System.out.println("===================");
		
		//2.
		OuterClass.InnerClass ic =
				  new OuterClass().new InnerClass();
		ic.show();
	}
}













