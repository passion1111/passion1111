package ex01.oop;

public class MainEntry {
	public static void main(String[] args) {
					//default constructor(����Ʈ�������Լ�)
		TV tv = new TV(); //��ü����, �޸𸮿��Ҵ�, �������Լ� �ڵ�ȣ��
		tv.disp();  //������� �ʱⰪ ���
		System.out.println("========================");
		tv.setChannel(15);
		tv.setColor("���");
		tv.disp();
		System.out.println("========================");
		
		TV tv2 = new TV(11, "yellow");
		tv2.disp();
		System.out.println("========================");
		
		TV tv3 = new TV("red");
		tv3.disp();
		
	}
}









