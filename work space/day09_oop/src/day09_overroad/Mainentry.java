package day09_overroad;
//오버로드.plus라는 하나의 메소드를 
//인자개수 데이터형에따라서 다른정의로 내릴수있다.
//
public class Mainentry {

			
	
	
	
	public static void main(String[] args) {
		plus(2.2,3.45);
		plus("kbs","tvn");
		plus(100,33.456);
		plus(11.11,345);
		plus(3.4F);//접미사f또는 F적으면된다
		
	}//end main
							//long int
							//double float 과의 충돌방지위해 생각은 필요함.
	public static void plus(float x) {
		System.out.println(x);
	}
	
	public static void plus(int x) {
		System.out.println(x);
	}
	public static void plus(int x,int y) {
		System.out.println(x+y);
		
	}
	public static void plus(double x,double y) {
		System.out.println(x+y);
	}
	public static void plus(String x,String y) {
		System.out.println(x+y);
	}
	
	public static void plus(int x,double y) {// 2번쨰줄 doulbe,int형과 다르게 인식해서 만들어줘야합니다.
		System.out.println(x+y);
	}
	
	
	
	
	
	
	
//	public static void iplus(int x,int y) {
//		
//	}
//	public static void dplus(double x,double y) {
//		
//	}
//	public static void splus(String x,String y) {
//		
//	}
//	
//	public static void diplus(int x,double y) {
//		
//	}
//	
//	
	
	
	
	
}//end class
