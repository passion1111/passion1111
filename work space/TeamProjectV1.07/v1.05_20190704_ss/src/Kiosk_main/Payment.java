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

		int paymethod = new Select().Number("ī������� 1,���ݰ����� 2�� �Է����ּ���", 1, 2);
		if (paymethod == 1) {
			inputcard(menuchoose);
		} else if (paymethod == 2) {
			payiscash(menuchoose);
		}

	}

	private void payiscash(Menuchoose menuchoose) {
		ArrayList arr =menuchoose.showcurrentorder();
		
		senddb(arr);
		KioskSender.KioskSender();
		System.out.println("������ �������ּ���");
		System.out.println("end");
	}

	private void inputcard(Menuchoose menuchoose) {
		ArrayList arr =menuchoose.showcurrentorder();
		
		
		senddb(arr);
		KioskSender.KioskSender();
		
		System.out.println("ī�带 �������ּ���");
		System.out.println("end");

	}

	private void senddb(ArrayList arr) {
		
		KioskDBManager m1 = new KioskDBManager();
		try {
			m1.getConnection();
			int no= m1.getjumunnum();//�ֹ���ȣ ����� �޼���
			m1.breakdown(arr,no);//�ֹ������� db�� �����ִ� �޼���
//			commit
//			��Ʈ��ũ������
//			m1.insertjumunnum(no);
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}