package ex01.Interface;

interface A {  //interface - abstract method, final field만 갖는다
	int x = 90; //final static int x = 90;
	final int y = 777;
	char ch = 'A';
	
	//추상메소드, abstract 생략가능함 - 무조건 추상메소드임
	public void show(); //public abstract void show();
	public abstract void disp();	
} // A end

interface B {
	void view();
} // B end

interface C {
	String name ="happy";
	public void draw();
} // C end

// interface 간에 상속에서도 extends 키워드 사용한다
interface D extends B {
	void dview();
} // D end

class Rect implements D {

	@Override
	public void view() {  // B interface method
		
	}

	@Override
	public void dview() {  // D interface method
		
	}
	
	public int plus(int x, int y) {
		return x + y;
	}
	
} // Rect end

class Shape{
	
} // Shape end

class Multi extends Shape implements B, C, A { //

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void view() {
		// TODO Auto-generated method stub
		
	}
	
} // Multi end

class Point implements A {

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disp() {
		// TODO Auto-generated method stub
		
	}

} // Point end


class Circle implements C {

	@Override
	public void draw() {
		System.out.println(name + "님이네요.");
		
	}
	
} // Circle end

public class MainEntry {
	public static void main(String[] args) {
		Circle c = new Circle();   c.draw();
		C cc = new Circle();   cc.draw();
		System.out.println("$$$$$$$$$$$$$$$$$");
		
		A a = new Point();
		a.disp();		a.show();
	}
}






















