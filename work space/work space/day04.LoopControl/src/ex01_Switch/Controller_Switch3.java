

package ex01_Switch;

import java.util.Scanner;

public class Controller_Switch3 {
	public static void main(String[] args) {
		
		System.out.println("����� ����Ʈ: ");
		int point=new Scanner(System.in).nextInt();
		
		switch (point) { // ����-������,������(long������) ,�Ǽ��� �ȵ�.
							// ���ڿ��������� case�� " " ���ڴ� ' ' jdk6.0�̻���� ���ڿ�����
		case 1:
			System.out.print("�� ");
		//	break;        //break�Ȱɸ� �ؿ����� �� �����.
		case 2:
			System.out.print("�ǾƳ� ");
		//	break;		
		case 3:
			System.out.print("��� ");
			break;          //�����ؾ��ϴ� ��Ȳ���� break�Ȱɸ�ȴ�.
		default:
			System.out.println("�ٽ��Է����ּ���");
			System.exit(0);      //���α׷� �������� �������� 0 �������� -1���������� ����� �������.
			

		}// switch end
			System.out.println("��ǰ�� ��÷ �Ǽ̽��ϴ�.");
	}
}
