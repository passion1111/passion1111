package ex02_oop;

public class MainEntry {
	public static void main(String[] args) {
		Point pt=new Point();
		pt.display();
		System.out.println("============");
		Circle c=new Circle(10,20);
		c.display();
		System.out.println("============");
		Circle c2=new Circle(5);
		c2.display();
		c2.setX(100);
		c2.setY(300);
		c2.display();
		System.out.println("=============");
		c2.setR(50000);
		c2.display();
		System.out.println("�簢�� �簢 �簢");
		Rect_quiz r=new Rect_quiz(500);
		r.display();//1��¥��
		System.out.println("================");
		Rect_quiz r2=new Rect_quiz(500,100);
		r2.display();
		System.out.println("==============");
		Rect_quiz r3=new Rect_quiz(100,200,300,400);
		r3.display();
		
		//r=new Rect()<-- �̷��� ��뵵 ����.
	}

}
