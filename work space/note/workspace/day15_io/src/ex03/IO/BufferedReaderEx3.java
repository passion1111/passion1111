package ex03.IO;
import java.io.*;

public class BufferedReaderEx3 {
	public static void main(String[] args) {
		
		try {
			BufferedReader  br = new BufferedReader(
					      new InputStreamReader(System.in));
//			int result = 0;
			
			System.out.print("���� �Է� = ");			int su1 = Integer.parseInt(br.readLine());
			System.out.print("���� �Է� = ");			int su2 = Integer.parseInt(br.readLine());
			System.out.print("������(+,-,*,/) �Է� = ");	
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
//					default : System.out.println("�����ڸ� �߸� �Է��ϼ̽��ϴ�.");
//			} // switch end
			
		}catch (NumberFormatException e) {
			System.out.println("������ �����Ͱ� �ƴմϴ�");
			//System.out.println(e.getMessage());
			//e.printStackTrace();			
		} catch (IOException e) {
			e.printStackTrace();
		} catch( ArithmeticException e){
			System.out.println("0���� ���� �� �����ϴ�.");
		}
	}
}







