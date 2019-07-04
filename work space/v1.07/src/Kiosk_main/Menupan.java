package Kiosk_main;

import java.sql.SQLException;
import java.util.ArrayList;

import Kiosk_DB.KioskDBManager;

public class Menupan {

	static ArrayList<Menu> menupan = new ArrayList<Menu>();

	public Menupan() {
		if (menupan.size() == 0) {
			addmenupan();
		}

	}

	Menu choosemenupan(int index) {

		return menupan.get(index);

	}

	void addmenupan() {
		KioskDBManager m1 = new KioskDBManager();
		m1.getConnection();
		try {
			menupan = m1.addlist();
		} catch (SQLException e) {
			System.out.println("메뉴판 추가중 에러발생");
			e.printStackTrace();
		}

	}

	void showmenupan() {
		for (int i = 0; i < this.size(); i++) {
			Menu menu = menupan.get(i);
			System.out.println((i + 1) + "번) " + menu.getName() + "\t\t" + menu.getPrice() + "won");
		}

	}

	public int size() {
		return this.menupan.size();
	}

}
