package ex02_interface;

public class MainEntry {
	public static void main(String[] args) {
		//1.�ڱ��ڽ����� ��ü ����
		BB b=new BB();
//		b.draw();
		System.out.println(b.su);
		System.out.println("*****************");
		//2.�θ� �������̽��� ��ü����
		IDraw bb=new BB();
//		IDraw d=new IDraw();//Ŭ�������ƴϱ⋚���� �����ȵ�.
		bb.draw();
		System.out.println(bb.su);
		
	}
}
