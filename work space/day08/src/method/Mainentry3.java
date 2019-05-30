package method;
//매개변수 x 리턴타입 o
public class Mainentry3 {
	
	public static int show() {
		//return 0;
		int num=90;
		return num;
		
	}
		
	
	public static void main(String[] args) {//진입점이라서 무조건 있어야 한다.
		System.out.println("main start~~");
		
		int result=show();
		System.out.println(show());
		System.out.println("main end");
	}

}
