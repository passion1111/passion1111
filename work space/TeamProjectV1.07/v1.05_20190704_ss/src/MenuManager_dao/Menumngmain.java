package MenuManager_dao;

import java.sql.SQLException;
import java.util.Scanner;

public class Menumngmain {
	
	public Menumngmain() throws SQLException, InterruptedException {
		makeedit();
	}

	private void makeedit()throws SQLException, InterruptedException  {
		MenuManager mgr = new MenuManager();
		Scanner sc = new Scanner(System.in);
		mgr.getConnection();// Ŀ�ؼ��� ���ο��� �� �� ����
		boolean memumng=true;
		while (memumng) {
			int num;
			System.out.println("\n*** ������ ��� �Դϴ�. ���ϴ� �޴��� �����ϼ���. ***\n<1> ��ü���� <2> �޴��߰�  <3> �޴�����  <4> �޴�����  <0> ����");
			do {
				while (!sc.hasNextInt()) {
					System.out.println("�޴��� �ִ� ���ڸ� �Է��� �� �ֽ��ϴ�. �ٽ� �Է����ּ���.");
					Thread.sleep(2000);
					System.out.println("<1> ��ü���� <2> �޴��߰�  <3> �޴�����  <4> �޴�����  <0> ����");
					sc.next();
				}
				num = sc.nextInt();
				if(num <0 || num >4) {
					System.out.println("�޴��� �ִ� ���ڸ� �Է��� �� �ֽ��ϴ�. �ٽ� �Է����ּ���.");
					Thread.sleep(2000);
					System.out.println("<1> ��ü���� <2> �޴��߰�  <3> �޴�����  <4> �޴�����  <0> ����");
				}
			} while (num < 0 || num > 4);
			
			if (num == 1) {
				mgr.list();
			} else if (num == 2) {
				mgr.addMenu();
			} else if (num == 3) {
				mgr.modifyMenu();
			} else if (num == 4) {
				mgr.deleteMenu();
			} else if (num == 0) {
				mgr.close();
				memumng=false;
				System.out.println("�޴� ������ �����մϴ�.");
				
			} 
		}//end while
	}// end main
		
	

	@SuppressWarnings({ "resource", "static-access" })
	public static void main(String[] args) throws SQLException, InterruptedException {
		MenuManager mgr = new MenuManager();
		Scanner sc = new Scanner(System.in);
		mgr.getConnection();// Ŀ�ؼ��� ���ο��� �� �� ����
		while (true) {
			int num;
			System.out.println("\n*** ������ ��� �Դϴ�. ���ϴ� �޴��� �����ϼ���. ***\n<1> ��ü���� <2> �޴��߰�  <3> �޴�����  <4> �޴�����  <0> ����");
			do {
				while (!sc.hasNextInt()) {
					System.out.println("�޴��� �ִ� ���ڸ� �Է��� �� �ֽ��ϴ�. �ٽ� �Է����ּ���.");
					Thread.sleep(2000);
					System.out.println("<1> ��ü���� <2> �޴��߰�  <3> �޴�����  <4> �޴�����  <0> ����");
					sc.next();
				}
				num = sc.nextInt();
				if(num <0 || num >4) {
					System.out.println("�޴��� �ִ� ���ڸ� �Է��� �� �ֽ��ϴ�. �ٽ� �Է����ּ���.");
					Thread.sleep(2000);
					System.out.println("<1> ��ü���� <2> �޴��߰�  <3> �޴�����  <4> �޴�����  <0> ����");
				}
			} while (num < 0 || num > 4);
			
			if (num == 1) {
				mgr.list();
			} else if (num == 2) {
				mgr.addMenu();
			} else if (num == 3) {
				mgr.modifyMenu();
			} else if (num == 4) {
				mgr.deleteMenu();
			} else if (num == 0) {
				mgr.close();
				System.out.println("�ý����� �����մϴ�.");
				System.exit(0);
			} 
		}//end while
	}// end main
}// end class MainEntry
//
