package day10;
//��ü �����ؼ� ����ϳ�
class Circle{
	
	private int x,y,z;//�������
	//setter,getter method <- ��� �Լ�
	public  void setX(int xx) {	x=xx;}
	public  void setY(int yy) { y=yy;}
	public  void setZ(int zz) {	z=zz;}
	//�Ű������� ��������� �����ҷ��� int x, x=x�� �����ҷ����ϸ�
	//�´� �Ű������� �ν��� �ع���.
	//�׷��� this.x�� ����������� ����Ŵ(�������) �׷��� ��������� �Ű������� �ٸ��� �ν��ϰ��Ҽ�����.
//	  �׷��� �Լ����� �Ƴ����� ����.
//	this�� �ڱ��ڽ� ��ü�� �����ɋ� �� ��ü�� ���� �ּҸ� ������ ����.
	public  int getX() {	return x;	}
	public  int gety() {	return y;	}
	public  int getz() {	return z;	}
	public void disp() {
		System.out.println(getX()+","+gety()+","+getz());
		// sysout(x+","+y+","+z);�� ����.
	}

}

public class MainEntry2{
	public static void main(String[] args) {
		Circle c=new Circle(); //��ü ���� �޸��Ҵ� �������Լ� �ڵ�ȣ��	
		c.setX(100);		c.disp();
		
		Circle c2=new Circle();
		c2.setX(50); c2.setY(10); c2.setZ(20);
		c2.disp();
		c.disp();
		//������ �޸��ּҸ� �ٸ��� ���⋚���� ������ ���� �����Ҽ�������.
	}
}