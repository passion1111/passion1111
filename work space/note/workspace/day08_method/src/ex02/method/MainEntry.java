package ex02.method;

public class MainEntry {
	
	public static void loopLine() {
		for(int i =1; i < 7 ; i++) {
			System.out.println("--------------");
		}
	}
	
	public static void loopLine(int n) {
		for(int i =1; i <= n ; i++) {
			System.out.println("*************");
		}
	}
	
//	public static void loopLine(int n1, int n2) {
//		if(n1 > n2 ) {
//			for(int i = n1; i <= n2 ; i++) {
//				System.out.println("##############");
//			}
//		} else {
//			for(int i = n2; i <= n1 ; i++) {
//				System.out.println("##############");
//			}
//		}
//		
//	}
	
	
	public static void loopLine(int n1, int n2) {
		if( n1 > n2 ) {
			int temp = n1;
			n1 = n2;
			n2 = temp;
		}
		
		for (int i = n1; i <= n2; i++) {
			System.out.println("##############");
		}
	}
	
	public static void main(String[] args) {
		loopLine();
		loopLine(3, 7);
		loopLine(3);
		System.out.println("=================");
		loopLine(10, 5); //문제소지 있음 -해결할것!!
		loopLine(-30); //문제소지 있음 -해결할것!!
	}
}






