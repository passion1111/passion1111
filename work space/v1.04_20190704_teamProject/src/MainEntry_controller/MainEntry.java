package MainEntry_controller;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.soap.Text;

import Inventory_inven.Inventory_JM;
import Kiosk_InputChecker.Select;
import Kiosk_main.EnterDesign;
import Kiosk_main.General;
import MenuManager_dao.Menumngmain;

public class MainEntry {

	public static void main(String[] args) {

		while (true) {

			Scanner scan = new Scanner(System.in);

			String str = "1)Ű����ũ �ֹ�";
			str += "\n2)�޴� ����";
			str += "\n3)��� ����";

			try {
				while (true) {
					int key = new Select().Number(str, 1, 3);
					switch (key) {
					case 1:
						EnterDesign enterdesign=new 
						welcome(text());
						new General();
						break;
					case 2:
						try {
							new Menumngmain();
						} catch (SQLException | InterruptedException e) {
							System.out.println("new Menumngmain() ����");
							e.printStackTrace();
						}
						break;
					case 3:
						try {
							new Inventory_JM();

						} catch (ClassNotFoundException | InterruptedException | SQLException e) {
							System.out.println("new Inventory_JM() ����");
							e.printStackTrace();
						}
						break;
					default:
						break;
					} // end switch-case
					break;
				} // end while
			} catch (InputMismatchException e) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.\n");
			}
		}//while end
	}
}
