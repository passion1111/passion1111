package day03.operator;
//   int su=123456;
//   시:분:초  로 표현하기
public class Ex01_operator_quiz2 {
	
	public static void main(String[] args) {
		
		  int su=123456;
		  
		  int hour;
		  int min;
		  int sec;
		  
		  hour=su/3600;
		  min=(su%3600)/60;
		  sec=((su%3600)%60);
		  
		  System.out.print(hour+"시:");
		  System.out.print(min+"분:");
		  System.out.print(sec+"초");
//		  만약 day도 구하고 싶으면 hour값에 /24하고 나머지를 hour로 연산처리.
		  
		  
	     
		
		
	}

}
