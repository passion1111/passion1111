package ex01.method;

public class MainEntry {
	public static void info() {
		System.out.println("happydoyeon");
		System.out.println("010-9872-0202");
		System.out.println("seoul");
	}
	
	//2) �Ű����� �ְ�, ����Ÿ�� ���� ���
	public static void plus(int x, int y, String msg) {
		System.out.println("hap = " + (x + y));
		int sum = x + y;
		System.out.println("sum = " + sum);
		System.out.println(msg);
		System.out.println(x + ", " + y + ", " + msg);
	}
	
	public static void abs(int x) {
		if( x  < 0 ) x = -x;
		System.out.println("���밪 : " + x);
	}
	
	
	public static void main(String[] args) {  //������(������)
		abs(-9);
		abs(100);
		
		plus(3, 5, "hi");
		plus(100, 200, "�ȳ��ϼ���");
		
		System.out.println("main start~~~");
		info();
		System.out.println("------------");
		display();  //�Լ� ȣ��
		display();
		System.out.println("main end!!!");
		display();
		display();
		info();
	}
	
	//1) �Ű����� ����, ����Ÿ�� ���� ���
	public static void display() {   //�Լ� ���Ǻ�
		System.out.println("�ȳ��ϼ���");
		System.out.println("�̵���");
	}
	
	
	
}




