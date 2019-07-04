package Kiosk_main;

import java.sql.SQLException;
import java.util.ArrayList;

import Kiosk_Client.KioskSender;
import Kiosk_DB.KioskDBManager;
import Kiosk_InputChecker.Select;

public class Payment {
	public Payment(Menuchoose menuchoose) {
		howboutpay(menuchoose);
	}

	private void howboutpay(Menuchoose menuchoose) {

		int paymethod = new Select().Number("카드결제면 1,현금결제면 2를 입력해주세요", 1, 2);
		if (paymethod == 1) {
			inputcard(menuchoose);
		} else if (paymethod == 2) {
			payiscash(menuchoose);
		}

	}

	private void payiscash(Menuchoose menuchoose) {
		ArrayList arr =menuchoose.showcurrentorder();
		
		System.out.println("현금을 지급해주세요");
		System.out.println("end");
		senddb(arr);
		KioskSender.KioskSender();
	}

	private void inputcard(Menuchoose menuchoose) {
		ArrayList arr =menuchoose.showcurrentorder();
		
		
		
		System.out.println("카드를 삽입해주세요");
		System.out.println("end");
		senddb(arr);
		KioskSender.KioskSender();

	}

	private void senddb(ArrayList arr) {
		
		KioskDBManager m1 = new KioskDBManager();
		try {
			m1.getConnection();
			int no= m1.getjumunnum();//주문번호 만드는 메서드
			System.out.println("주문번호는"+no+"번입니다. 기다려주세요.");
			m1.breakdown(arr,no);//주문내역을 db로 보내주는 메서드

			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
