

package ex01_Switch;

import java.util.Scanner;

public class Controller_Switch2 {
	public static void main(String[] args) {
		
		System.out.println("���ø� �����ϼ��� (s,d,b,j): ");
		String city=new Scanner(System.in).next();  //�̰��� ���ڿ��Է¹޴°�.
		
//		char ch=city.charAt(0); //charAt(0)�� ����� ���ڿ� �Լ� �߿��� ���ڿ� �ε�����ȣ 0������ ������.
		//	Scanner sc=new Scanner(System.in);	
		//  char ch=��ĵ�Լ�.next().charAt(0); �ѹ��� ��  ���� �ذ���
		
		
		switch (city) { // ����-������,������(long������) ,�Ǽ��� �ȵ�.
							// ���ڿ��������� case�� " " ���ڴ� ' ' jdk6.0�̻���� ���ڿ�����
		case "s":
			System.out.print("����");
			break;        //break�Ȱɸ� �ؿ����� �� �����.
		case "d":
			System.out.print("�뱸");
			break;		
		case "b":
			System.out.print("�λ�");
		case "j":
		 	System.out.print("���ֵ�.");
		 	break;
		
		default:
			System.out.println("�ٽ��Է����ּ���");
			System.exit(0);      //���α׷� �������� �������� 0 �������� -1���������� ����� �������.
			

		}// switch end
			System.out.println("��(��) �����ϼ̽��ϴ�.");
	}
}

