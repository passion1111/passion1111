package quiz3;
//class draw intx,y; double result;
//sub class:circle,triangle
//��Ŭ: ���� ���� 
//triangle�簢������ /2
//�������Լ� getter,setter
//output -user method or toString overide
public class Draw {
	int x,y;
	double result;
	
	public Draw() {
		
	}
	public Draw(int x) {
		
		this.x = x;
		
	}
	public Draw(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	public Draw(double result) {
		
		this.result = result;
	}
	
	
	public Draw(int x, int y, double result) {
		super();
		this.x = x;
		this.y = y;
		this.result = result;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public double getResult() {
		
		return result;
	}
	
	
	

}

