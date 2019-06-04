package ex06_constructor;
//default constructor /API 만들기.
public class MainEntry {
	/** 
	 * 
	 *
	 * @param args 메인은 아무값도 넘겨받지않습니다.
	 * @param x곱을 구하는것에 첫번쨰 정수형 변수
	 * @param y곱을 구하는것에 두번쨰 정수형 변수
	 * @param gob 변수는 x와 y 두 정수의 곱을 저장하는 변수
	*/  //<--/**   */  <- doc주석 @param <-- annotation 어노테이션
	
	
	public static void main(String[] args) {
		int x,y,gob=1;
		char ch='A';
		String msg;
		
		x=5; y=10;
		msg="th129 Hello~~";
		gob=gob(x,y);
		System.out.println(ch);
		System.out.println(msg);
		System.out.println(x+"*"+y+"="+gob);
	}

	private static int gob(int x, int y) {
		
		return x*y;
	}
}


