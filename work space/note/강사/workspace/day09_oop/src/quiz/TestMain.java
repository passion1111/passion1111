package quiz;

public class TestMain {
	public static void main(String[] args) {
		int i=1, j=1;   //변수 초기화
		
		do {
			
			j = 1; //안쪽 변수의 초기화가 있어야함
			
			do {
				
				System.out.print(j+ " ");
				j++; // 증감식
			} while( j < 11);  //조건
			
			//j = 1;
			
			i++; //증감식
			System.out.println();
		}while(i < 11);  //조건
		
		
	}
}
