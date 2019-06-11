package sort;

import java.util.Arrays;

//선택 정렬
public class ArraysSortTest {
	public static void main(String[] args) {
		int[] a = { 7,3,5,2,8 };
		int temp ; 
		System.out.println("******* sort전 출력 : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
		System.out.println("\n오름차순 정렬됨");
		Arrays.sort(a);  //정렬 알고리즘이 이미 내부적으로 처리돼있는 메소드
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		} // for end
		
		System.out.println("\n내림차순 정렬됨");
		// i = a.length-1는 data 개수는 5지만, 배열의 인덱스는
				// 0부터 시작하기 때문에 4로 시작해야함
		for (int i = a.length-1; i >= 0 ; i--) {
			System.out.print(a[i] + "\t");
		} // for end
		
	}
}

		
		
		
		
		
		
		
		
		
