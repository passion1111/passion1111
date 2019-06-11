package ex01.returnType;

public class MethodTest {
	
	public static int methodEx(double d1, double d2) {
		double hap = d1 + d2;
		
		//리턴하는 함수의 자료형이 우선 순위 높음
		return (int)hap; //리턴타입과 함수타입(자료형)이 다르면 에러다. 
	}
	
	public static void main(String[] args) {
		
		int result = methodEx(1.2, 5.7);
	}
}
