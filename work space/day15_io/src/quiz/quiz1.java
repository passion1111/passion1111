package quiz;
//��Ģ���� ���α׷� �ۼ� ������(+,-,*,/)�Է¹޾Ƽ�
import java.io.*;
public class quiz1 {
	public static void main(String[] args) throws Exception {
		
		InputStream is=System.in;
		Reader reader=new InputStreamReader(is);
		BufferedReader br=new BufferedReader(reader);
		System.out.println("���� �Է�");
		Integer su1=Integer.parseInt(br.readLine());
		System.out.println("���� �Է�");
		Integer su2=Integer.parseInt(br.readLine());
		String calc=br.readLine();
		
		switch(calc) {
		case "+":System.out.println(su1+su2); break;
		case "-":System.out.println(su1-su2); break;
		case "*":System.out.println(su1*su2); break;
		case "/":while(su2==0) {
			System.out.println("0���� ������ �����ϴ�.");
			System.out.println("���� �Է�");
			su1=Integer.parseInt(br.readLine());
			
			System.out.println("���� �Է�");
			su2=Integer.parseInt(br.readLine());
		}		
		System.out.println(su1/su2);
		break;
		
		
		
		default: System.out.println("��Ģ������ �ٽ� �Է����ּ���");
			System.exit(0);
		}
		
		
//		if(calc.equals("+")) {
//
//			System.out.println(su1+su2);
//		}else if(calc.equals("+"))System.out.println(su1-su2);
//		else if(calc.equals("+"))System.out.println(su1*su2);
//		else if(calc.equals("+")) {
//			if((su1==0)||(su2==0)) {
//				System.out.println("0���� ������ �����ϴ� �ٽ� �Է����ּ���");
//				do {
//					System.out.println("���� �Է�"+su1);
//					
//					System.out.println("���� �Է�"+su2);
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
