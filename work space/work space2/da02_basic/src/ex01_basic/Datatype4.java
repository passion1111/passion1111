package ex01_basic;

public class Datatype4 {
	public static void main(String[] args) 
		
	 {
		int su=10;
			System.out.println("10진수: "+su); //%d 10진수,%o 8진수,%x  16진수,%X
			System.out.printf("10진수: %d \n" ,su);
			System.out.printf("8진수: %o \n" ,su);
			System.out.printf("16진수 %x, %X \n" , su , su); //x,X차이는 abcdef까지 소문자 대문자차이
			System.out.printf("%d %x %o %X  \n",10,10,10,10);
			System.out.printf("%.2f  \n",32.132);
			
			
			
			System.out.printf("%d \n" ,012); //012(8진수) ->10진수 10 출력
			System.out.printf("%d \n", 0xA); //0xA(16진수)->10진수 10 출력
			
			double f= 12.34;
			System.out.println(f);
			/*float ff=5.6;
			System.out.println(ff);*/ //대입연산은 뒤에있는값을 앞으로 넘김 그래서 5.6읽자마자
			//정확도가 높은 double형으로 선언을해버려서 에러가 떠버림.해결할려면 f를 해줘야함.
	}
         //0숫자 -> 8진수 ,0x붙이면 16진수
			
}
