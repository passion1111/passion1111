package ex03_abstract;

public class MainEntry {
	public static void main(String[] args) {
//		1.각자의 클래스로 객체생성한다.
//		Circle c=new Circle();
//		c.show("원");
//		
//		Rect r=new Rect();
//		r.show("Rect");
//		
//		Triangle t=new Triangle();
//		t.show("삼각형");
		
//		Shape s=new Circle();//다형성 구현...
//		s.show("Circle");
		
//		2.Shape 부모 추상 클래스를 이용해서 객체 생성
		Shape sh=new Circle();
//		sh.show("circle");
		
//		sh=new Rect();
//		sh.show("Rect Rect");
//		sh=new Triangle();
//		sh.show("Triangle");
		
//		다형성의 대표는 중복함수 ,생성자함수,추상클래스로 구현가능하다.
		
//		3.
		Shape[] ss=new Shape[3];//배열 선언 및 생성
//		Shape ss=new Shape(); //<--객체생성안됨 추상화는
		ss[0]=new Circle();
		ss[1]=new Rect();
		ss[2]=new Triangle();
		String[] name= {"Circle","사각","삼각"};
		for(int i=0;i<ss.length;i++) {
			ss[i].show(name[i]);
		}
		
	}

}
