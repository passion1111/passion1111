package quiz;
//사칙연산 프로그램 작성 연산자(+,-,*,/)입력받아서
import java.io.*;
public class quiz1 {
	public static void main(String[] args) throws Exception {
		
		InputStream is=System.in;
		Reader reader=new InputStreamReader(is);
		BufferedReader br=new BufferedReader(reader);
		System.out.println("숫자 입력");
		Integer su1=Integer.parseInt(br.readLine());
		System.out.println("숫자 입력");
		Integer su2=Integer.parseInt(br.readLine());
		String calc=br.readLine();
		
		switch(calc) {
		case "+":System.out.println(su1+su2); break;
		case "-":System.out.println(su1-su2); break;
		case "*":System.out.println(su1*su2); break;
		case "/":while(su2==0) {
			System.out.println("0으로 나눌수 없습니다.");
			System.out.println("숫자 입력");
			su1=Integer.parseInt(br.readLine());
			
			System.out.println("숫자 입력");
			su2=Integer.parseInt(br.readLine());
		}		
		System.out.println(su1/su2);
		break;
		
		
		
		default: System.out.println("사칙연산을 다시 입력해주세요");
			System.exit(0);
		}
		
		
//		if(calc.equals("+")) {
//
//			System.out.println(su1+su2);
//		}else if(calc.equals("+"))System.out.println(su1-su2);
//		else if(calc.equals("+"))System.out.println(su1*su2);
//		else if(calc.equals("+")) {
//			if((su1==0)||(su2==0)) {
//				System.out.println("0으로 나눌수 없습니다 다시 입력해주세요");
//				do {
//					System.out.println("숫자 입력"+su1);
//					
//					System.out.println("숫자 입력"+su2);
//					
//					
//					
//					
//				}while(su1==0||su2==0);
//				System.out.println(su1/su2);
//			}
//		}
//	}
//	
}
}
