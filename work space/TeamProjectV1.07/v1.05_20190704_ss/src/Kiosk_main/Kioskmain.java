package Kiosk_main;

import java.sql.SQLException;
import java.util.Scanner;

import Kiosk_DB.KioskDBManager;

public class Kioskmain {
	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);

		KioskDBManager m1 = new KioskDBManager();
		try {
			m1.getConnection();
			int no= m1.getjumunnum();
//			m1.insertjumunnum(no);
			
			System.out.println("���Ӽ���! no = "+no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		//		while (true) {
//			System.out.println("�ֹ��� �޽��ϴ�.");
//
//			General g1 = new General();
//
//		}

	}

}
