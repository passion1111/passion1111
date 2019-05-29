//*/
package ex01.For;
//문제4] 1~ 100까지 중에서 3의 배수의 합과 개수는 ? 

public class ForEx2 {
	public static void main(String[] args) {
		
		//int sum = 0, count =0;
		int sum, count;
		sum = count = 0;
		
		for(int i=1; i < 101; i++) {
			
			if( i % 3 == 0 ) {
				sum += i; //sum = sum + i;
				count++; //count += 1;  //count = count + 1;
			} // end if
			
		} // end for
		System.out.println("3의 배수 합 : " + sum);
		System.out.println("3의 배수 개수 : " + count);
		
	} // main end
}
//*/

/*
package ex01.For;
// 문제3] 1~ 100까지 중에서 짝수 출력하고 한행에 10개씩 출력

public class ForEx2 {
	public static void main(String[] args) {
		for(int i=1; i < 101; i++) {
			
			if(i % 2 == 0) {
				System.out.print(i + "\t");
			}
			if(i % 20 == 0) {
				System.out.println();
			}
			
		} //end for
		
	}
}
//*/
