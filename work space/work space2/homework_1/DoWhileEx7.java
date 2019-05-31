package ex04.While;

// 구구단 전단 출력 프로그램 (do~while 이용)
public class DoWhileEx7 {
	public static void main(String[] args) {
		
		int i=1, j=1;  //초기화
		
		do {
			
			j = 1;  //while or do~while문의 안쪽변수의 초기화가 있어야한다
			do {
				
				System.out.print(j +"*"+i +"=" + (i*j) +"\t");
				j++; //증감식
			} while(j < 10); // end j - 조건
			
			i++; //
			System.out.println();
			
		}while(i < 10); // end i - 조건
		
	}
}




