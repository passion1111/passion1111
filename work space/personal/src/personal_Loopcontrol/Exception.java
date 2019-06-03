package personal_Loopcontrol;
//자바는 goto 구문이 없기떄문에 exception 처리시 안에 do while문등을 만들어서
//다시 입력값을 확인할수있도록 하자. 
//

public class Exception {
	public static void main(String[] args) {
		int i=5;
		int i1=0;
		int na;
		
		try {
		na=i/i1;	
			
		}catch(ArithmeticException e) {
			System.out.println("안돼");
			
		}
		
		
		
	}

}
