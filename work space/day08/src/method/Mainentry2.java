package method;
//매개변수 o 리턴타입 x
public class Mainentry2 {
	
	public static void plus(int x,int y,String msg) {
		System.out.println("hap ="+(x+y));
		int sum= x+ y;
		System.out.println("sum="+sum);
		System.out.println(msg);
		
	}
		
	
	public static void main(String[] args) {//진입점이라서 무조건 있어야 한다.
		System.out.println("main start~~");
		plus(3,5, null);  //함수 호출
		plus(3,5,"hi");
		System.out.println("main end");
	}

}
