package ex03.IO;
import java.io.*;

public class BufferedReaderEx3 {
	public static void main(String[] args) {
		
		try {
			BufferedReader  br = new BufferedReader(
					      new InputStreamReader(System.in));
//			int result = 0;
			
			System.out.print("숫자 입력 = ");			int su1 = Integer.parseInt(br.readLine());
			System.out.print("숫자 입력 = ");			int su2 = Integer.parseInt(br.readLine());
			System.out.print("연산자(+,-,*,/) 입력 = ");	
			String op = br.readLine();
			
			
			if(op.equals("+")) {
				System.out.println(su1 + " + " + su2 + " = " + (su1 + su2));
			} else if(op.equals("-")) {
				System.out.println(su1 + " - " + su2 + " = " + (su1 - su2));
			}
			
			
//			switch( op ) {
//				case "+" :
//					System.out.println(su1 + " + " + su2 + " = " + (su1 + su2));
//					break;
//				case "-" :
//					System.out.println(su1 + " - " + su2 + " = " + (su1 - su2));
//					break;
//				case "*" :
//					System.out.println(su1 + " * " + su2 + " = " + (su1 * su2));
//					break;
//				case "/" :
//					System.out.println(su1 + " / " + su2 + " = " + (su1 / su2));
//					break;
//					default : System.out.println("연산자를 잘못 입력하셨습니다.");
//			} // switch end
			
		}catch (NumberFormatException e) {
			System.out.println("정수형 데이터가 아닙니다");
			//System.out.println(e.getMessage());
			//e.printStackTrace();			
		} catch (IOException e) {
			e.printStackTrace();
		} catch( ArithmeticException e){
			System.out.println("0으로 나눌 수 없습니다.");
		}
	}
}







