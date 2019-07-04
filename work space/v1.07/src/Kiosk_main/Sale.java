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
			System.out.println("쿠폰사용하시겠습니까?");
			System.out.println("예 y");
			System.out.println("아니오 n");

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

	private void coupondiscount(Menuchoose menuchoose) throws SQLException {//쿠폰 미완성.
		Scanner scan = new Scanner(System.in);
		
		int couponnum =new Select().Number("쿠폰번호를 입력해주세요", 0, 1000);
		
		new Payment(menuchoose);

	}

}
