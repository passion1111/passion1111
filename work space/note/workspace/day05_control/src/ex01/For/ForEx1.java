//*
package ex01.For;
//문제2] 1~ 100까지 합을 출력하는 프로그램 작성
public class ForEx1 {
	public static void main(String[] args) {
		int sum=0; //누적할 변수 초기화
		
		for(int i=1; i <= 100; i++) {
			sum += i ;  // sum = sum + i;
		} // for end
		
		System.out.println("1~ 100까지 합 = " + sum);
	}
}
//*/


/*
package ex01.For;

public class ForEx1 {
	public static void main(String[] args) {
		
		for(int i=1; i < 6; i++) {
			System.out.print("*");
		} // for end
	}
}
//*/

/*
package ex01.For;

//문제1] 1~ 10까지 출력하는 프로그램 작성 (for문 )
public class ForEx1 {
	public static void main(String[] args) {
		for(int i=1; i <= 10; i++) {
			System.out.print(i + "\t");
		} // for end
	}
}
//*/