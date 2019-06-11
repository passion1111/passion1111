package ex03.inheritance;

public class MainEntry {
	
	public static void main(String[] args) {
		//자손객체 생성시 부모 생성자함수 메모리상에 올려져있다
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
