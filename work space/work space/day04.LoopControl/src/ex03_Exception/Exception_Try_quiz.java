package ex03_Exception;
//��Ģ���� ���α׷� �ۼ�
//���� 2�� �Է¹ް� ,������(+,-,*,/)1�� �Է¹޾Ƽ� 
// result>
//   3
//   4
//   5
//   3 +  5 = 8 
// �ٵ� 0���� ������������ ����ó���ؾ��ϹǷ� try catch�� ����ó���ϱ�.
import java.util.Scanner;

public class Exception_Try_quiz {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("����2���� ������ ��Ģ������ �Է����ּ���");
		int su1= sc.nextInt();
		int su2= sc.nextInt();
		int sum= su1+su2;
		int cha= su1-su2;
		int gob=su1*su2;
		double na=(float)su1/(float)su2;
		String a=sc.next();
		switch(a) {	
		case "+":
			 System.out.printf("%d + %d=%d",su1,su2,sum); break;
		case "-":
			 System.out.printf("\n %d - %d=%d",su1,su2,cha); break;
		case "*":  
			 System.out.printf("\n %d*%d=%d",su1,su2,gob); break;
		case "/": 
		{
			try {
				 System.out.printf("\n %d/%d=%.2f",su1,su2,na); break;
		
		} catch(Exception e) {  //e�� ������ ����
			e.printStackTrace();
			
			break;
		}	
		}
			 default: System.out.println("�ٽ��Է����ּ���");
		}		
}
}

