package ex03_inheritance;

public class Circle extends Point {//���
	private int r;

public Circle(int x, int y, int r) {
//	super(x, y);//point���� ������. �Ǵ�
	this.x=x;
	this.y=y;
	this.r = r;
}
	public Circle(int r) {
		this.r=r;
		//x=y=20;
	}
	public Circle() {
		System.out.println("��Ŭ�������.");
	
	}
	public void display() {
		System.out.println(x+","+y+","+r);
	}
	
	public static void main(String[] args) {
		Circle c=new Circle(5);//x,y�� �⺻���������� �ҷ��ͼ��׷�.
		c.display();
		Circle c2=new Circle();
		//���ݺ��� �θ�������Լ��� �θ� ��������ٶ�� ��¹��� �߰��ϴϱ� �˾Ƽ� �������Լ��� �߰��ż� ����̵�.
		//�� �ڼհ�ü������ �θ�������Լ��� �޸𸮻� �÷����ִ�.
		
	}
}
