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
			int no = m1.getjumunnum();

			System.out.println("접속성공! no = " + no);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
