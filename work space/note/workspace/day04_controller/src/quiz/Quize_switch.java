/*
 * ���� �Է��ϸ� �ش� ���� ������ ��¥�� �˷��ִ� ���α׷�. 
 * ��, 2���� �������� Ȯ���ϱ� ���� ������ �Է� �޾ƾ� ��. (���� : 29��, ��� : 28��)
*/

package quiz;

import java.util.Scanner;

public class Quize_switch {
	public static void main(String[] args) {

		System.out.println("input month : ");
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		boolean flag = false;
		String str = null;

		switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				System.out.println(month + "���� ������ ���� 31�� �Դϴ�.");
				break;
	
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println(month + "���� ������ ���� 30�� �Դϴ�.");
				break;
			case 2:
				System.out.println("������ �Է����ּ���.");
				int year = sc.nextInt();
				if (year % 4 == 0) {
					if ((year % 100 != 0) || (year % 400 == 0)) {
						flag = true;
					} // if in end
				} // if out end
				str = (flag == true) ? year + "�⵵ " + month + "���� ������ ���� 29�� �Դϴ�."
						: year + "�⵵ " + month + "���� ������ ���� 28�� �Դϴ�.";
				System.out.println(str);
				break;
				
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. 1~12 ������ ���ڸ� �Է����ּ���.");
				break;
		}
		sc.close();
	}

}
