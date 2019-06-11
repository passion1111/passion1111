package day10;

class Rect{
	private int x,y,x2,y2;
	//setter,getter method ¸â¹öº¯¼ö
	public void setX(int x) {		this.x=x;	}
	public void setY(int y) {		this.y=y;	}
	public void setX2(int x2) {		this.x2=x2;	}
	public void setY2(int y2) {	this.y2=y2;	}
	//getter
	public int getX(int x) {		return x;	}
	public int getY(int y) {		return y;	}
	public int getX2(int x2) {		return x2;	}
	public int getY2(int y2) {		return y2;	}
	//disp
	public void disp() {	System.out.println(x+","+x2+","+y+","+y2);	}	
	
}	

public class MainRect{
public static void main(String[] args) {
		Rect r=new Rect();
		r.setX(3);
		r.setX2(5);
		r.setY(5);
		r.setY2(7);
		r.disp();
}
}
