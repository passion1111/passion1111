package personal2_practice_oop;

public class Rect extends Point {
	private int x2,y2;

	public Rect() { //�θ��� �Ű��������� �������Լ��� ���� ��������. ������ָ� �����ȶ�.
					//�θ��� ������ �޴´�.
		
	}
	 
	public Rect(int x,int y,int x2, int y2) {
		super(x,y);
		this.x2 = x2;
		this.y2 = y2;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}
	public void display() {
		System.out.println(x+","+y+","+x2+","+y2);
	}
	
	public static void main(String[] args) {
		Rect r=new Rect(4,10,5,10);
		r.display();
	}
	

}
