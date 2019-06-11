package ex01.method;

public class MainEntry {
	public static void info() {
		System.out.println("happydoyeon");
		System.out.println("010-9872-0202");
		System.out.println("seoul");
	}
	
	//2) 매개변수 있고, 리턴타입 없는 경우
	public static void plus(int x, int y, String msg) {
		System.out.println("hap = " + (x + y));
		int sum = x + y;
		System.out.println("sum = " + sum);
		System.out.println(msg);
		System.out.println(x + ", " + y + ", " + msg);
	}
	
	public static void abs(int x) {
		if( x  < 0 ) x = -x;
		System.out.println("절대값 : " + x);
	}
	
	
	public static void main(String[] args) {  //시작점(진입점)
		abs(-9);
		abs(100);
		
		plus(3, 5, "hi");
		plus(100, 200, "안녕하세요");
		
		System.out.println("main start~~~");
		info();
		System.out.println("------------");
		display();  //함수 호출
		display();
		System.out.println("main end!!!");
		display();
		display();
		info();
	}
	
	//1) 매개변수 없고, 리턴타입 없는 경우
	public static void display() {   //함수 정의부
		System.out.println("안녕하세요");
		System.out.println("이도연");
	}
	
	
	
}





