package day10;
//객체 생성해서 출력하나
class Circle{
	
	private int x,y,z;//멤버변수
	//setter,getter method <- 멤버 함수
	public  void setX(int xx) {	x=xx;}
	public  void setY(int yy) { y=yy;}
	public  void setZ(int zz) {	z=zz;}
	//매개변수가 멤버변수를 세팅할려고 int x, x=x로 설정할려고하면
	//셋다 매개변수로 인식을 해버림.
	//그래서 this.x로 멤버변수임을 가르킴(멤버변수) 그래서 멤버변수와 매개변수랑 다르게 인식하게할수있음.
//	  그래서 함수명을 아낄수가 있음.
//	this는 자기자신 객체가 생성될떄 그 객체의 시작 주소를 가지고 있음.
	public  int getX() {	return x;	}
	public  int gety() {	return y;	}
	public  int getz() {	return z;	}
	public void disp() {
		System.out.println(getX()+","+gety()+","+getz());
		// sysout(x+","+y+","+z);도 가능.
	}

}

public class MainEntry2{
	public static void main(String[] args) {
		Circle c=new Circle(); //객체 생성 메모리할당 생성자함수 자동호출	
		c.setX(100);		c.disp();
		
		Circle c2=new Circle();
		c2.setX(50); c2.setY(10); c2.setZ(20);
		c2.disp();
		c.disp();
		//각각의 메모리주소를 다르게 갖기떄문에 각각의 값을 저장할수가있음.
	}
}