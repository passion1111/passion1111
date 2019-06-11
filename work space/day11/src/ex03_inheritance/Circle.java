package ex03_inheritance;

public class Circle extends Point {//상속
	private int r;

public Circle(int x, int y, int r) {
//	super(x, y);//point에서 가져옴. 또는
	this.x=x;
	this.y=y;
	this.r = r;
}
	public Circle(int r) {
		this.r=r;
		//x=y=20;
	}
	public Circle() {
		System.out.println("서클만들었다.");
	
	}
	public void display() {
		System.out.println(x+","+y+","+r);
	}
	
	public static void main(String[] args) {
		Circle c=new Circle(5);//x,y의 기본설정값으로 불러와서그럼.
		c.display();
		Circle c2=new Circle();
		//지금보면 부모생성자함수에 부모가 만들어졌다라는 출력문을 추가하니까 알아서 생성자함수가 추가돼서 출력이됨.
		//즉 자손객체생성시 부모생성자함수는 메모리상에 올려져있다.
		
	}
}
