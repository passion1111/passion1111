package quiz3;

public class Triangle extends Draw {
	public Triangle(int x,int y) {
		
		super(x,y);
	}
	
	public Triangle(int x) {
		
		super(x);
	}
	public void result() {
		result=(double)x*y/2;
		System.out.println(result);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		super.y = y;
	}
	
	
@Override
	public String toString() {
		
		return "Triangle [result=" + super.result + "]";
	}


}
