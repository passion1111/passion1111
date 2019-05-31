package day09_oop;

public class Methodreturntype {
	
	public static int methodex(double d1,double d2) {
		double hap=d1+d2;
		
		//flxjsgksms gkatndml wkfyguddl dntjstnsdnlrk shvdma.
//		  리턴하는 함수의 자료형이 우선순위가 높음.
		return hap;//리턴타입과 함수타입(자료형)이 다르면 에러뜸
		
	}
	
	public static void main(String[] args) {
		int result=methodex(1.2,1.5);
	}
}
