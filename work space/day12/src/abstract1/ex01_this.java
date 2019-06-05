package abstract1;
//추상클래스 미완성클래스 
//자체적으로 미완성메소드가 하나라도 존재하면 미완성 클래스
//자체적으로 객체 생성할수없다
//하지만 나를 상속받은 자손클래스로는 객체 생성할수없다
//추상메소드를 가지고있다.
//public void dsip(){}  <  {} 중괄호 가지고있다. 일반 메소드
//public abstract void disp()  <--추상메소드.
//abstract를 써야함.
//형식 abstract pulbic class Point{
//    void disp(){ }
//    abstract void show();
//}

abstract class Shape{//추상클래스,super class
	double result=0;
	public abstract double calc();//추상 메소드
	public abstract void draw();
	
	public void show() {//일반 메소드
		System.out.println("super class Shape");
	}
}

class Circle extends Shape{

	double r=5.0;
	@Override
	public double calc() {
		result= r*r*Math.PI;
		return result;
	}

	@Override
	public void draw() {
		System.out.println("원의 넓이는"+result);
		
	}
}
	class Rect extends Shape {
		int w=3,h=5;
		
		@Override
		public double calc() {
			
			
			result=w*h;
			return result;
		}

		@Override
		public void draw() {
			System.out.println("사각형의 넓이:"+result+"인 사각형을 그렸습니다.");
			
		}
		
	}
	class Triangle extends Shape{
		int w=5;
		int h=3;
		@Override
		public double calc() {
			result=w*h/2.;
			return result;
		}

		@Override
		public void draw() {
			System.out.println("삼각형의 넓이는 :"+result+"인 삼각형입니다.");
		}
		
		
	}
	

public class ex01_this {
	public static void main(String[] args) {
//		Shape sh=new Shape(); // <-- error 발생 자체적으로 객체생성핤없으므로.
		Shape sh=new Circle(); // <-- sh타입에  Circle에대한것을 넣는것.
		sh.calc();
		sh.draw();
		Shape t=new Triangle();
		t.calc();
		t.draw();
	}
	

}
