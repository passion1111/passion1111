package ex02.Switch;

import java.util.Scanner;

public class Controller_Switch {
	public static void main(String[] args) {
		System.out.print("point = ? ");
		int point = new Scanner(System.in).nextInt();

		switch (point) { // ���� - ������,������(long������), �Ǽ��� �ȵ�
			case 1:
				System.out.print("����Ʈ ���� 1���Դϴ�.");
				break;
	
			case 2:
				System.out.print("����Ʈ ���� 2���Դϴ�.");
				break;
	
			case 3:
				System.out.print("����Ʈ ���� 3���Դϴ�.");
				break;
				
			default:
				System.out.println("���� ���� �Դϴ�.1~3������ �Է� ���");
		} // switch end
	}
}
