package quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

//�μ� �Է¹޾Ƽ� �������ϴ� ���α׷� �ۼ�(���ܤø�
// ���ڰ� �ƴ� ���� �Է� ������
// ������ �ƴ� �Ǽ� ������ �Էµ�����
// � ���� 0���� ������ ����.
public class Quiz_exception {
	public static void main(String[] args) {
		int i=0,j=0;
		
		Scanner sc=new Scanner(System.in);
		double na=0;
		
		try {
			i=sc.nextInt();
			j=sc.nextInt();
			na=i/j;
			na= (double)i/j;
			System.out.println(na);
			
		}catch(NumberFormatException e ) {
			System.out.println("������ �Է����ּ���");
			
			
		}catch(InputMismatchException e) {
			System.out.println("���ڸ� �Է��ϼ���");
		}
		catch(ArithmeticException e) {
			System.out.println("0���� ������ �����ϴ�."); 
		}


}
}