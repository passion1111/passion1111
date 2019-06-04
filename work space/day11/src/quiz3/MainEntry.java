package quiz3;
//오버라이딩 개념
public class MainEntry {
	public static void main(String[] args) {
		Circle c=new Circle(5);
		c.result();
		System.out.println(c);
		Triangle t=new Triangle(5,10);
		t.result();
		System.out.println(t);
	}

}
