package Kiosk_main;

import java.util.ArrayList;
import java.util.Scanner;

import Kiosk_InputChecker.Select;

public class General {

//	Menuchoose menuchoose = new Menuchoose();

	public General() {

//		mainmenu(new Menupan(), menuchoose); //
		mainmenu(new Menupan(), new Menuchoose());
	}

	void mainmenu(Menupan menupan, Menuchoose menuchoose) { //���θ޴��� �����ְ� �ֹ���ȣ�� �޴� �޼���

		menupan.showmenupan();// �޴��� �����ִ� �޼���

		int key = new Select().Number("�ֹ���ȣ�� �Է����ּ���", 1, menupan.size());

		choosefood(menupan.choosemenupan(key - 1), menuchoose);

	}

	private void choosefood(Menu menu, Menuchoose menuchoose) { //�ֹ���ȣ �Է¿Ϸ�� �����Է¹޴� �޼���

		int amount = new Select().Number("������ �Է����ּ���");
		menuchoose.addorder(menu.getName(), menu.getPrice(), amount);

		ordermorefood(menuchoose);

	}

	private void ordermorefood(Menuchoose menuchoose) { //�߰��ֹ��޼���
		Scanner scan = new Scanner(System.in);
		boolean check = true;
		while (check) {
			menuchoose.showcurrentorder();

			System.out.println("�߰� �ֹ��Ͻðڽ��ϱ�?");
			System.out.println("�߰��ֹ��� y");
			System.out.println("�ֹ��Ϸ�� n");
			System.out.println("�ֹ���ҽ� c");

			String order = scan.next();
			Loop1: switch (order) {
			case "y":
				mainmenu(new Menupan(), menuchoose);
				check=false;
				break;
			case "n":
				new Sale(menuchoose);
				check=false;
				break;
			case "c":
				cancelmenu(menuchoose);
				check=false;
				break;

			default:
				break Loop1;
			}
//			if (order.equals("y")) {
//				mainmenu(new Menupan(),menuchoose);
//				break;
//			} else if (order.equals("n")) {
//				new Sale(menuchoose);
//				break;
//			} else {
//				continue;
//			}
		}

	}

	private void cancelmenu(Menuchoose menuchoose) {//�޴� ������ŭ �Է¹޾Ƽ� ����ϴ� �޼���
		ArrayList<CancelMenu> arr = menuchoose.showcurrentorder();// ���� �ֹ��� �޴��� �ѹ� �����ش�.
		if(arr.size()==0) {
			System.out.println("�߰��ֹ����� ���ư��ϴ�.");
		}else {

		int cancelnum = new Select().Number("����� �޴��� �Է��ϼ���");
		String key="";
		for (int i = 0; i < arr.size(); i++) {
			if(cancelnum==arr.get(i).getOrdernum()) {
				key=arr.get(i).getMenuname();
			}
		}

		menuchoose.cancel(key);
		}
		ordermorefood(menuchoose); // ��Ҹ޼��尡 ������ �ֹ�,�Ϸ�,��� ȭ������ ���ư���.
	}

}
