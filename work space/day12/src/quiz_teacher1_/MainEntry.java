package quiz_teacher1_;

public class MainEntry {
	public static void main(String[] args) {
		//3. �迭 �̿��� ����
		Shape[] ss = new Shape[3]; //�迭 ���� �� ����
		//Shape ss = new Shape(); //��ü������ ��ü ���� ����
		ss[0] = new Circle();
		ss[1] = new Rect();
		ss[2] = new Triangle();
		String[] name = {"Circle", "Rect", "Triangle"};
		
		for (int i = 0; i < ss.length; i++) {
			ss[i].show(name[i]);
		}		
		
		System.out.println("=====================");
		//2. Shape �θ� �߻� Ŭ������ �̿��ؼ� ��ü ����
		Shape sh = new Circle();
		sh.show("Circle Circle");
		
		sh = new Rect();
		sh.show("Rect Rect");
		
		sh = new Triangle();
		sh.show("Triangel Triangle");
		
		System.out.println("=====================");
		//1. ������ Ŭ������ ��ü ���� ����
		Circle c = new Circle();
		c.show("��");
		
		Rect r = new Rect();
		r.show("Rectangle");
		
		Triangle t = new Triangle();
		t.show("�ﰢ��");
		
		Shape s = new Circle();  //������ ����....
		s.show("Circle");
	}
}