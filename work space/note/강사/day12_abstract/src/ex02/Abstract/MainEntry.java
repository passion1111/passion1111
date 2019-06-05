package ex02.Abstract;

abstract class Shape {  //�߻�Ŭ����, Super class
	double result =0;
	public abstract double calc(); //�߻�޼ҵ�
	public abstract void draw();
	
	public void show() { //�Ϲݸ޼ҵ�
		System.out.println("Super class Shape");
	}
} // Shape end


class Circle extends Shape {  // Sub class
	double r = 5.0;
	
	@Override
	public double calc() {
		result = r * r * Math.PI;
		return result;
	}

	@Override
	public void draw() {
		calc();
		System.out.println("���� ���� : " + result +" �� ���� �׷Ƚ��ϴ�.");
	}
	
} // Circle end

class Rect extends Shape {
	int w = 3, h = 5;

	@Override
	public double calc() {
		result = w * h;
		return result;
	}

	@Override
	public void draw() {
		calc();
		System.out.println("�簢�� ���� : " + result +" �� �簢���� �׷Ƚ��ϴ�.");		
	}
	
} // Rect end

class Triangle extends Shape {
	int w =10, h =20;
	
	@Override
	public double calc() {
		result = (w * h) / 2;
		return result;
	}

	@Override
	public void draw() {
		calc();
		System.out.println("�ﰢ�� ���� : " + result +" �� �ﰢ���� �׷Ƚ��ϴ�.");		
	}
	
} // Triangle end

public class MainEntry {
	public static void main(String[] args) {
		Triangle t = new Triangle();
		t.draw();
		Rect r = new Rect();
		r.draw();
		
		Circle c = new Circle();
		c.draw();
		
		//Shape sh = new Shape(); //��ü������ ��ü ������ �� ����.
		//Shape sh = new Circle(); //��� ���� �ڼ� Ŭ�����δ� ��ü ���� �� �� �ִ�
		
	}
}








