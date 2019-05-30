package method;
//매개변수 x 리턴타입 x
public class Mainentry {
	
	public static void infor() {
		System.out.println("나이: ~살");
		System.out.println("이름:~~~");
		System.out.println("연락처:~~~");
		System.out.println("주소:~~~~");
	}
	public static void display() { //함수 정의
		System.out.println("hi");
		System.out.println("누구야");
	}
	
	public static void main(String[] args) {//진입점이라서 무조건 있어야 한다.
		System.out.println("main start~~");
		display();  //함수 정의
		infor();
		System.out.println("main end");
	}

}
