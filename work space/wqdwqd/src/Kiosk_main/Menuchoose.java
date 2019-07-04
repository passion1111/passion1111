package Kiosk_main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import Kiosk_InputChecker.Select;

class Menuchoose {
	
	int jumunnum=0;

	HashMap menutree = new HashMap();

	public Menuchoose() {

	}

	ArrayList showcurrentorder() {
		Set set = menutree.entrySet();
		Iterator it = set.iterator();

		int totalprice = 0;

		ArrayList<CancelMenu> orderlist = new ArrayList<CancelMenu>();
		
		int i = 1;
		if (menutree.size() == 0) {
			System.out.println("선택하신 주문이없습니다");
		} else {
			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				Menu m = (Menu) e.getValue();

				orderlist.add(new CancelMenu((String) e.getKey(), i,m.getMenuamount()));

				System.out.println(i + ")" + e.getKey() + "  주문수량 : " + m.getMenuamount());
				i++;
				totalprice += m.getMenuamount() * m.getPrice();
			}
			System.out.println("총 결제금액은 : " + totalprice);
		}

		System.out.println("\n\n\n\n");
		return orderlist;

	}

	void addorder(String menuname, int menuprice, int menuamount) {

		if (menutree.containsKey(menuname)) {// 기존의 값이 있을경우
			Menu menu = (Menu) menutree.get(menuname);

			int menuamountold = menu.getMenuamount();

			Menu menutmp = new Menu(menu.getName(), menu.getPrice(), menuamountold + menuamount);

			menutree.replace(menuname, menutmp);
		} else {// 기존의 값이 없을경우
			menutree.put(menuname, new Menu(menuname, menuprice, menuamount));
		}

	}

	public void cancel(String menuname) {
		if (menutree.containsKey(menuname)) {// 기존의 값이 있을경우
			Menu menu = (Menu) menutree.get(menuname);

			int menuamountold = menu.getMenuamount();

			int menuamount = new Select().Number(menu.getName() + "의 삭제할 수량을 선택하세요", 1, menuamountold);

			if (menuamountold - menuamount == 0) {
				menutree.remove(menu.getName());
				return;
			}
			Menu menutmp = new Menu(menu.getName(), menu.getPrice(), menuamountold - menuamount);

			menutree.replace(menuname, menutmp);
		} else {// 기존의 값이 없을경우

			System.out.println("없는 메뉴입니다.");
			return;

		}

	}

}
