package Kiosk_main;

import java.sql.SQLException;
import java.util.Scanner;

import Kiosk_InputChecker.Select;

public class Sale {

	public Sale() {
//		coupon();
	}

	public Sale(Menuchoose menuchoose) throws SQLException {
		coupon(menuchoose);
	}

	private void coupon(Menuchoose menuchoose) throws SQLException {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("��������Ͻðڽ��ϱ�?");
			System.out.println("�� y");
			System.out.println("�ƴϿ� n");

			String order = scan.next();
			if (order.equals("y")) {
				coupondiscount(menuchoose);
				break;
			} else if (order.equals("n")) {
				new Payment(menuchoose);
				break;
			} else {
				continue;
			}
		}

	}

	private void coupondiscount(Menuchoose menuchoose) throws SQLException {//���� �̿ϼ�.
		Scanner scan = new Scanner(System.in);
		
		int couponnum =new Select().Number("������ȣ�� �Է����ּ���", 0, 1000);
		
		new Payment(menuchoose);

	}

}
