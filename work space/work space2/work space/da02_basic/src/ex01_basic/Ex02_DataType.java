package ex01_basic;

public class Ex02_DataType {
		static int num;			//class안에는 static 변수선언하면 상관없음.
		static String str;		//정수형:0 실수형:0.0 문자열:Null로 초기화
									//알아서함.
		
	public static void main(String[] args) {
		int su=29;   //지역변수는 반드시 초기화하고 사용한다.
						//ex)int su; <--이렇게하면 초기화해달라고요구함.
					    //메소드안에있으면 모두 지역변수
		System.out.println(su);
		su=300;
		System.out.println(su);
		System.out.println(num);
		System.out.println(str);
	}  //main end
	
}// class end
