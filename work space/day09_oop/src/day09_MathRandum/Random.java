package day09_MathRandum;
			//자동 임포트해준다. java.lang pakage
public class Random {

	

	
	
	
	public static void main(String[] args) {
		System.out.println(Math.abs(-3));// abs static keyword
		//random():난수 발생 0.0~1.0
		System.out.println(Math.random());
			//0~n-1값 출력 원하면
		System.out.println(Math.random()*5);
			//1~5   Math방법은 *숫자로 어디까지할것인지 정함 +숫자로 어디부터할것인지 정함.
		System.out.println((int)(Math.random()*5)+1 );
		
		
		for(int i=0;i<6;i++) {
			System.out.println((int)(Math.random()*45)+1);
		}
	}
}
