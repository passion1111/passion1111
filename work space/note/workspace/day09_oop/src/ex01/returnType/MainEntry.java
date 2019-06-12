package ex01.returnType;

public class MainEntry {
	//함수 만들기
	//1. 함수 정의부 만들고
	//2. 메인함수에서 호출해서 사용함
	
	public static void main(String[] args) {
		int x = 3, y = 5;
				
		int result = methodEx(x, y);
		System.out.println(result);
		
		int[] arrResult = methodEx2();
		for(int i =0; i < arrResult.length; i++) {
			System.out.print(arrResult[i] + " ");
		}
		
	}

	private static int[] methodEx2() {
		int[] arr = { 1,2,3,4,5,6 };
		
		return arr;  //여러개의 데이터 전달은 배열, 객체(object)로 리턴한다.
	}

	public static int methodEx(int x, int y) {
		
		return x + y;  //리턴 값은 오직 1개만, 값, 변수, 수식
		//return x, y; //여러개의 값 못 보냄
	}

	
	
}










