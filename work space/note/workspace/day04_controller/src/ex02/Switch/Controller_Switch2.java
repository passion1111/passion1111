//*
package ex02.Switch;

import java.util.Scanner;

public class Controller_Switch2 {
	public static void main(String[] args) {
		System.out.print("���ø� �����ϼ���(s,d,b,j) = ");
		Scanner sc = new Scanner(System.in);
//		String str = sc.next(); //���ڿ� �Է� �ޱ� 
//		char ch = str.charAt(0);  //���ڿ� �Լ� �߿� ���ڿ����� charAt(index) �ε�����ȣ ���� �������� �Լ� 

		char ch = sc.next().charAt(0);
		
		switch (ch) { 
			case 's': System.out.print("����"); break;
			case 'd': System.out.print("�뱸"); break;
			case 'b': System.out.print("�λ�"); break;
			case 'j': System.out.print("����"); break;
			
			default : 
				System.out.print("�߸� �������ϴ�. s,d,b,j�߿����� �����ϼ���....");
				System.exit(0);  // ���α׷� ���� ����
		} //switch end
		
		System.out.println("��(��) �����ϼ̽��ϴ�. ");
	}
}

//*/


/*
package ex02.Switch;

import java.util.Scanner;

public class Controller_Switch2 {
	public static void main(String[] args) {
		System.out.print("���ø� �����ϼ���(s,d,b,j) = ");
		Scanner sc = new Scanner(System.in);
		String ch = sc.next(); //���ڿ� �Է� �ޱ� 
		
		switch (ch) { 
			case "s": System.out.print("����"); break;
			case "d": System.out.print("�뱸"); break;
			case "b": System.out.print("�λ�"); break;
			case "j": System.out.print("����"); break;
			
			default : 
				System.out.print("�߸� �������ϴ�. s,d,b,j�߿����� �����ϼ���....");
				System.exit(0);  // ���α׷� ���� ����
		} //switch end
		
		System.out.println("��(��) �����ϼ̽��ϴ�. ");
	}
}

//*/





