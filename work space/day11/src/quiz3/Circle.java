package quiz3;

public class Circle extends Draw {
	
	
	

	

	public Circle(int x) {
		this.x=x;
		
		
		
	}
	public void result() {
		result=x*x*3.14;
		System.out.println(result);
	}
	

	
	

	@Override
	public String toString() {
		result=3.14*x;
		return "Circle [x=" + result + "]";
	}
	public int getR() {
		return x;
	}

	public void setR(int r) {
		x = r;
	}

	
}	
	