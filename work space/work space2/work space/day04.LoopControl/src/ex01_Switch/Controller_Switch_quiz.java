package ex01_Switch;

import java.util.Scanner;

//����4 ¦,Ȧ�� ���� switch~case�� �����
public class Controller_Switch_quiz {
	public static void main(String[] args) {
		
		int point=new Scanner(System.in).nextInt();
		
			switch (point%2) { // ����-������,������(long������) ,�Ǽ��� �ȵ�.
								// ���ڿ��������� case�� " " ���ڴ� ' ' jdk6.0�̻���� ���ڿ�����
			case (0):
				System.out.println("¦���Դϴ�.");
				break;
	
			case 1:
				System.out.println("Ȧ���Դϴ�.");
				break;
	
			
			default:
				System.out.println("�ٽ��Է����ּ���");
				
				
		}// switch end
			
	}
}