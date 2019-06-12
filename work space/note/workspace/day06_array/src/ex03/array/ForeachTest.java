package ex03.array;

public class ForeachTest {
	public static void main(String[] args) {
		int[] a = {1, 2, 5, 6,7,90,100};
		System.out.println("오름 차순 출력");
		for(int i=0; i < a.length; i++) {
			System.out.print(a[i] + " ");
			if( i == 3 ) break;
		}
		System.out.println("\n==============");
		
		//for(자료형 변수명 : 배열명 또는 컬렉션명) { 반복실행문; }
		for(int item : a ) {
			System.out.print(item + " ");
		}
		
		System.out.println("\n내림차순 출력");
		for(int i= a.length-1 ; i >= 0 ; i--) {
			System.out.print(a[i] + " ");
		}
		
	}
}





