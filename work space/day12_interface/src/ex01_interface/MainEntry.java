package ex01_interface;

interface A{//interface-abstract method,final field�� ������.
//	final static int x=90;
	int x=90;   // static�� �˾Ƽ� ��������. static�� �ڵ����� ����ǰ��ִٴ¶�. final�� ��������.
				//��� �ʱ�ȭ ������ؿ�.�ѹ������ָ� �� ����
	char ch='A';
	public void show(); //abstract�ڵ����� ���������ϴ�. �߻�޼ҵ�
	public abstract void disp();
	public void view(String name); //{} ��ü�� �����ָ� �߻�޼ҵ尡�ƴϿ��� ��������. �������.
	
//	�������̽��� �Ϲݸ޼ҵ����ǰ� �Ұ����ϴ�.
}//A ends

interface B{
	void view();
}//B end
interface C{
	String name="happy";
	public void draw();
}//C end

//interface���� ���
//interface�������� extendsŰ���� ����Ѵ�
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
	}//RectŬ������ �޼ҵ�
}

class Shape{
	
	
}//Shape end

class Multi extends Shape implements B,C,A{//��� ���� �������̽��־������.
//	�ֳ��ϸ� �ڹٴ� Ŭ���� �ٷο��� Ŭ������������./

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
		System.out.println("A�Դϴ�");
		
	}

	@Override
	public void disp() {
		System.out.println("A�Դϴ�.2");
		
	}
	


	@Override
	public void view(String name) {
		// TODO Auto-generated method stub
		
	}
	
}//Point end

class Circle implements C{

	@Override
	public void draw() {
		System.out.println(name+"���̳׿�");
	}
	
}

public class MainEntry {
	public static void main(String[] args) {
		Circle c=new Circle(); c.draw();
		C cc=new Circle(); cc.draw();
		System.out.println("================");
		
		A a=new Point();
		//�������̽�������ִ¾ְ� �θ�� �׷��� �θ�κ��� ��ü������ �����ϴ�. A a=new Point�� �ǹ�
//		Point������ A������Ÿ�Կ� �����ϴ� a��� ��ü�� �����Ѵٴ� �ǹ��̱⵵��.
		a.disp();
		a.show();
		
	}
}
