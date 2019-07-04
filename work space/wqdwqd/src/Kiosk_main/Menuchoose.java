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
			System.out.println("�����Ͻ� �ֹ��̾����ϴ�");
		} else {
			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				Menu m = (Menu) e.getValue();

				orderlist.add(new CancelMenu((String) e.getKey(), i,m.getMenuamount()));

				System.out.println(i + ")" + e.getKey() + "  �ֹ����� : " + m.getMenuamount());
				i++;
				totalprice += m.getMenuamount() * m.getPrice();
			}
			System.out.println("�� �����ݾ��� : " + totalprice);
		}

		System.out.println("\n\n\n\n");
		return orderlist;

	}

	void addorder(String menuname, int menuprice, int menuamount) {

		if (menutree.containsKey(menuname)) {// ������ ���� �������
			Menu menu = (Menu) menutree.get(menuname);

			int menuamountold = menu.getMenuamount();

			Menu menutmp = new Menu(menu.getName(), menu.getPrice(), menuamountold + menuamount);

			menutree.replace(menuname, menutmp);
		} else {// ������ ���� �������
			menutree.put(menuname, new Menu(menuname, menuprice, menuamount));
		}

	}

	public void cancel(String menuname) {
		if (menutree.containsKey(menuname)) {// ������ ���� �������
			Menu menu = (Menu) menutree.get(menuname);

			int menuamountold = menu.getMenuamount();

			int menuamount = new Select().Number(menu.getName() + "�� ������ ������ �����ϼ���", 1, menuamountold);

			if (menuamountold - menuamount == 0) {
				menutree.remove(menu.getName());
				return;
			}
			Menu menutmp = new Menu(menu.getName(), menu.getPrice(), menuamountold - menuamount);

			menutree.replace(menuname, menutmp);
		} else {// ������ ���� �������

			System.out.println("���� �޴��Դϴ�.");
			return;

		}

	}

}
