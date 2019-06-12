package homework.ex2;

import java.util.*;

public class MainEntry {  // view
	static String name;
	static String add;
	static String tel;

	public static void main(String[] args) {
		CustomerManager cus = new CustomerManager();

		Scanner sc = new Scanner(System.in);
		try {
			while (true) {
				System.out.println("\n\n*-*-*-*-* �޴� *-*-*-*-*");
				System.out.println("1. �� ���� �Է�");
				System.out.println("2. �� ���� ����");
				System.out.println("3. �� ���� ����");
				System.out.println("4. ��� �� ����");
				System.out.println("5. ����");
				System.out.println("----------------------");
				System.out.print(" >> ");
				int inNum = sc.nextInt();

				try {
					switch (inNum) {
					case 1:
						System.out.println("\n*-*-*-* 1. �� ���� �Է� *-*-*-*");
						inCustomer();
						cus.CustomerAdd(name, add, tel);
						System.out.println("* �Է¿Ϸ�");
						break;
					case 2:
						System.out.println("\n*-*-*-* 2. �� ���� ���� *-*-*-*");
						cus.display();
						System.out.println("---------------------------");
						System.out.print("������ ���� ��ȣ�� �Է��ϼ��� >> ");
						inNum = sc.nextInt();
						cus.CustomerRmv(inNum);
						break;
					case 3:
						System.out.println("\n*-*-*-* 3. �� ���� ���� *-*-*-*");
						cus.display();
						System.out.println("---------------------------");
						System.out.print("������ ���� ��ȣ�� �Է��ϼ��� >> ");
						inNum = sc.nextInt();
						System.out.println("������ ���� ������ �Է��ϼ���.");
						inCustomer();
						cus.CustomerCh(inNum, name, add, tel);
						break;
					case 4:
						System.out.println("\n*-*-*-* 4. ��� �� ���� *-*-*-*");
						cus.display();
						break;
					case 5:
						System.out.println("\n* ���α׷��� �����մϴ�.");
						System.exit(0);
						break;
					default:
						System.out.println("\nerr)�߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
					} // switch
				} catch (Exception e) {
					System.out.println("err) ���� ���Դϴ�. �ٽ� �Է����ּ���.");
				} // try catch
			} // while
		} catch (Exception e) {
			System.out.println("err) �߸� �Է��ϼ̽��ϴ�. ���α׷��� �����մϴ�.");
		}// try catch

	}// main

	public static void inCustomer() {
		Scanner sc = new Scanner(System.in);

		System.out.print("�̸� >> ");
		name = sc.next();
		System.out.print("�ּ� >> ");
		add = sc.next();
		System.out.print("����ó  >> ");
		tel = sc.next();
	}
}// class
