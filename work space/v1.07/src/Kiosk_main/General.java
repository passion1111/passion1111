package Kiosk_main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Kiosk_InputChecker.Select;

public class General {


	public General() throws SQLException  {

		mainmenu(new Menupan(), new Menuchoose());
	}

	void mainmenu(Menupan menupan, Menuchoose menuchoose) throws SQLException { //���θ޴��� �����ְ� �ֹ��Ұ��� �޴� �޼ҵ�.

		menupan.showmenupan();// �޴��� �����ִ� �޼���

		int key = new Select().Number("�ֹ���ȣ�� �Է����ּ���", 1, menupan.size());

		choosefood(menupan.choosemenupan(key - 1), menuchoose);

	}

	private void choosefood(Menu menu, Menuchoose menuchoose) throws SQLException { //�ֹ���ȣ �Է¿Ϸ�� �����Է¹޴� �޼���

		int amount = new Select().Number("������ �Է����ּ���");
		menuchoose.addorder(menu.getName(), menu.getPrice(), amount);

		ordermorefood(menuchoose);

	}

	private void ordermorefood(Menuchoose menuchoose) throws SQLException { //�߰��ֹ��޼���
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


		}

	}

	private void cancelmenu(Menuchoose menuchoose) throws SQLException {//�޴� ������ŭ �Է¹޾Ƽ� ����ϴ� �޼���
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
