

package ex01_Switch;

public class Controller_Switch {
	public static void main(String[] args) {
		int point = 4;
			switch (point) { // ����-������,������(long������) ,�Ǽ��� �ȵ�.
								// ���ڿ��������� case�� " " ���ڴ� ' ' jdk6.0�̻���� ���ڿ�����
			case 1:
				System.out.println("������ 1���Դϴ�.");
				break;
	
			case 2:
				System.out.println("������ 2���Դϴ�.");
				break;
	
			case 3:
				System.out.println("������ 3���Դϴ�.");
				break;
			default:
				System.out.println("1~3������ �Է����ּ���");

		}// switch end

	}
}
