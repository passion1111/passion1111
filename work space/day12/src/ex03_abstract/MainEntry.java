package ex03_abstract;

public class MainEntry {
	public static void main(String[] args) {
//		1.������ Ŭ������ ��ü�����Ѵ�.
//		Circle c=new Circle();
//		c.show("��");
//		
//		Rect r=new Rect();
//		r.show("Rect");
//		
//		Triangle t=new Triangle();
//		t.show("�ﰢ��");
		
//		Shape s=new Circle();//������ ����...
//		s.show("Circle");
		
//		2.Shape �θ� �߻� Ŭ������ �̿��ؼ� ��ü ����
		Shape sh=new Circle();
//		sh.show("circle");
		
//		sh=new Rect();
//		sh.show("Rect Rect");
//		sh=new Triangle();
//		sh.show("Triangle");
		
//		�������� ��ǥ�� �ߺ��Լ� ,�������Լ�,�߻�Ŭ������ ���������ϴ�.
		
//		3.
		Shape[] ss=new Shape[3];//�迭 ���� �� ����
//		Shape ss=new Shape(); //<--��ü�����ȵ� �߻�ȭ��
		ss[0]=new Circle();
		ss[1]=new Rect();
		ss[2]=new Triangle();
		String[] name= {"Circle","�簢","�ﰢ"};
		for(int i=0;i<ss.length;i++) {
			ss[i].show(name[i]);
		}
		
	}

}
