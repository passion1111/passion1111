package ex03.inheritance;

public class MainEntry {
	
	public static void main(String[] args) {
		//�ڼհ�ü ������ �θ� �������Լ� �޸𸮻� �÷����ִ�
		Circle c = new Circle();  
		//c.display();
		System.out.println(c.toString());
		
		
		System.out.println("================");
		Rect r = new Rect(1, 2);
		//r.display();
		System.out.println(r);
		System.out.println(r.toString());
	}
}
