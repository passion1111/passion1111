package ex01_interface;

interface A{//interface-abstract method,final field만 가진다.
//	final static int x=90;
	int x=90;   // static은 알아서 누워버림. static이 자동으로 적용되고있다는뜻. final도 마찬가지.
				//상수 초기화 해줘야해요.한번정해주면 쭉 적용
	char ch='A';
	public void show(); //abstract자동적용 생략가능하다. 추상메소드
	public abstract void disp();
	public void view(String name); //{} 몸체를 정해주면 추상메소드가아니여서 에러가뜸. 없어야함.
	
//	인터페이스는 일반메소드정의가 불가능하다.
}//A ends

interface B{
	void view();
}//B end
interface C{
	String name="happy";
	public void draw();
}//C end

//interface간에 상속
//interface간에서도 extends키워드 사용한다
interface D extends B{
	void dview();
}//D ends

class Rect implements D{

	@Override
	public void view() {//B interface method
		
	}

	@Override
	public void dview() {//D interface method

	}
	public int plus(int x,int y) {
		return x+y;
	}//Rect클래스의 메소드
}

class Shape{
	
	
}//Shape end

class Multi extends Shape implements B,C,A{//상속 다음 인터페이스넣어줘야함.
//	왜냐하면 자바는 클래스 바로옆을 클래스라고생각함./

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void view(String name) {
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
	
}//multi end

class Point implements A{

	@Override
	public void show() {
		System.out.println("A입니다");
		
	}

	@Override
	public void disp() {
		System.out.println("A입니다.2");
		
	}
	


	@Override
	public void view(String name) {
		// TODO Auto-generated method stub
		
	}
	
}//Point end

class Circle implements C{

	@Override
	public void draw() {
		System.out.println(name+"님이네여");
	}
	
}

public class MainEntry {
	public static void main(String[] args) {
		Circle c=new Circle(); c.draw();
		C cc=new Circle(); cc.draw();
		System.out.println("================");
		
		A a=new Point();
		//인터페이스상속해주는애가 부모다 그러니 부모로부터 객체생성도 가능하다. A a=new Point의 의미
//		Point형식을 A데이터타입에 대입하는 a라는 객체를 생성한다는 의미이기도함.
		a.disp();
		a.show();
		
	}
}
