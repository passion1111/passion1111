package ex04.While;

import java.util.Scanner;

/*����6]�̸� �Է¹ް�,
���� 3��(k, e, c)- 0~100������ �Է¹ޱ�, 
���� ��� ���ϴ� ���α׷��ۼ�*/
public class DoWhileEx9 {
	public static void main(String[] args) {
		
		String name=null;
		int k, e, c;
		char op =' ';
		
		Scanner sc = new Scanner(System.in); //�Է� �׸� ����
		System.out.print("name = ");
		name = sc.nextLine();
		
		do {
			System.out.print("kor = ");
			k = sc.nextInt();		
		}while(k < 0 || k > 101);
		
		do {
			System.out.print("eng = ");
			e = sc.nextInt();
		}while(e < 0 || e > 101);
		
		do {
			System.out.print("com = ");
			c = sc.nextInt();
		}while(c < 0 || c > 101);
		
		do {
			System.out.print("op(+,-,*,/) = ");
			op = sc.next().charAt(0);
			
		}while((op != '+') && (op != '-') &&(op != '*') &&(op != '/'));
		
		System.out.println(k + " " +  op + " " + e ); // �������� ������ ��������
		System.out.println(name + ", " + k + ", " + e + ", " + c);
				
		
	}
}














