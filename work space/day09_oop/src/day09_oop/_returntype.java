package day09_oop;

public class _returntype {
	//함수만들기
	//	1.함수정의버 만들고
	// 2.메인함수에서 호출해서 사용함.
	// 일반적으로 위의 과정을 따르는데.
	// 먼저 함수부 호출을 만들고 난후에
	// 나중에 함수를 만드는것도 방법
		public static void main(String[] args) {
			int x=3,y=5;
		int result=	methodex(x,y);
		System.out.println(result);
		
		
		int[] arrResult=methodex();
		for(int i=0;i<arrResult.length;i++)System.out.println(arrResult[i]);
		
		
		}

	public static int[] methodex() {
		int[] arr= {1,2,3,4,5};
		
		return arr;//여러개의 데이터 전달은 배열,객체(object)를 통해서 보낸다.
		
		
		
	}

	public static int methodex(int x, int y) {//데이터 형을 정해주면 {
                 
		return x+y; //리턴값은 오직 1개만,값,변수,수식
	}
}
