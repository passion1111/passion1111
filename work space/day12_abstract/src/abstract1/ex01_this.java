package abstract1;
//�߻�Ŭ���� �̿ϼ�Ŭ���� 
//��ü������ �̿ϼ��޼ҵ尡 �ϳ��� �����ϸ� �̿ϼ� Ŭ����
//��ü������ ��ü �����Ҽ�����
//������ ���� ��ӹ��� �ڼ�Ŭ�����δ� ��ü �����Ҽ�����
//�߻�޼ҵ带 �������ִ�.
//public void dsip(){}  <  {} �߰�ȣ �������ִ�. �Ϲ� �޼ҵ�
//public abstract void disp()  <--�߻�޼ҵ�.
//abstract�� �����.
//���� abstract pulbic class Point{
//    void disp(){ }
//    abstract void show();
//}

abstract class Shape{//�߻�Ŭ����,super class
	double result=0;
	public abstract double calc();//�߻� �޼ҵ�
	public abstract void draw();
	
	public void show() {//�Ϲ� �޼ҵ�
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
		System.out.println("���� ���̴�"+result);
		
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
			System.out.println("�簢���� ����:"+result+"�� �簢���� �׷Ƚ��ϴ�.");
			
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
			System.out.println("�ﰢ���� ���̴� :"+result+"�� �ﰢ���Դϴ�.");
		}
		
		
	}
	

public class ex01_this {
	public static void main(String[] args) {
//		Shape sh=new Shape(); // <-- error �߻� ��ü������ ��ü�����A�����Ƿ�.
		Shape sh=new Circle(); // <-- shŸ�Կ�  Circle�����Ѱ��� �ִ°�.
		sh.calc();
		sh.draw();
		Shape t=new Triangle();
		t.calc();
		t.draw();
	}
	

}
