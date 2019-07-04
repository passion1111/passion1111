package Kiosk_main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Kiosk_InputChecker.Select;

public class General {


	public General() throws SQLException  {

		mainmenu(new Menupan(), new Menuchoose());
	}

	void mainmenu(Menupan menupan, Menuchoose menuchoose) throws SQLException { //메인메뉴를 보여주고 주문할것을 받는 메소드.

		menupan.showmenupan();// 메뉴를 보여주는 메서드

		int key = new Select().Number("주문번호를 입력해주세요", 1, menupan.size());

		choosefood(menupan.choosemenupan(key - 1), menuchoose);

	}

	private void choosefood(Menu menu, Menuchoose menuchoose) throws SQLException { //주문번호 입력완료시 수량입력받는 메서드

		int amount = new Select().Number("수량를 입력해주세요");
		menuchoose.addorder(menu.getName(), menu.getPrice(), amount);

		ordermorefood(menuchoose);

	}

	private void ordermorefood(Menuchoose menuchoose) throws SQLException { //추가주문메서드
		Scanner scan = new Scanner(System.in);
		boolean check = true;
		while (check) {
			menuchoose.showcurrentorder();

			System.out.println("추가 주문하시겠습니까?");
			System.out.println("추가주문시 y");
			System.out.println("주문완료시 n");
			System.out.println("주문취소시 c");

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

	private void cancelmenu(Menuchoose menuchoose) throws SQLException {//메뉴 수량만큼 입력받아서 취소하는 메서드
		ArrayList<CancelMenu> arr = menuchoose.showcurrentorder();// 현재 주문된 메뉴를 한번 보여준다.
		if(arr.size()==0) {
			System.out.println("추가주문으로 돌아갑니다.");
		}else {

		int cancelnum = new Select().Number("취소할 메뉴를 입력하세요");
		String key="";
		for (int i = 0; i < arr.size(); i++) {
			if(cancelnum==arr.get(i).getOrdernum()) {
				key=arr.get(i).getMenuname();
			}
		}

		menuchoose.cancel(key);
		}
		ordermorefood(menuchoose); // 취소메서드가 끝나면 주문,완료,취소 화면으로 돌아간다.
	}

}
