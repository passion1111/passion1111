package ex05.overload;

public class MainEntry {
	
	public static void main(String[] args) {
		plus(1.2, 3.45);
		plus("kbs", " mbc");
		plus(100, 33.567);
		plus(12.34, 30);
		plus(300);
		plus(3.4F); // 접미사 F,또는 f 적으면된다
		
	} //end main
	
	public static void plus(int x) {
		
		System.out.println(x + 9);
	}
	
	public static void plus(float x) { // 접미사 F 적으면된다
		
		System.out.println(x + 9);
	}

	public static void plus(String x, String y) {
		System.out.println(x + y);	
	}

	public static void plus(double x, double y) {
		System.out.println(x + y);	
	}
	
	public static void plus(int x, double y) {
		System.out.println(x + y);	
	}
	
	public static void plus(double x, int y) {
		System.out.println(x + y);	
	}
	
//	public static void iplus(int x, int y) {
//		System.out.println(x + y);
//	}
//	
//	public static void dplus(double x, double y) {
//		System.out.println(x + y);
//	}
//	
//	public static void splus(String x, String y) {
//		System.out.println(x + y);
//	}
//	
//	public static void diplus(int x, double y) {
//		System.out.println(x + y);
//	}
}







