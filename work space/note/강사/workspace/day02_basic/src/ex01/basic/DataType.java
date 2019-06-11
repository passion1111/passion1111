package ex01.basic;

public class DataType {
	
	static int Num;  // 정수형: 0, 실수형 : 0.0, 문자열: NULL
	static String str;
	
	public static void main(String[] args) {
		int su=30;  //지역변수는 반드시 초기화 하고 사용한다.
		System.out.println(su);
		
		su = 900;
		System.out.println(su);
		System.out.println(Num);
		System.out.println(str);
		
		
	} // main end
} // class end
