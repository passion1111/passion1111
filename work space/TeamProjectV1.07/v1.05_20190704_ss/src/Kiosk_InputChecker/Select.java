package Kiosk_InputChecker;

import java.util.Scanner;

public class Select {
	Scanner sc = new Scanner(System.in);
	int Select;

	public int Number() {

		System.out.println("���ڸ� �Է����ּ���");
		while (!sc.hasNextInt()) {
			System.out.println("���ڸ� �Է����ּ���");
			sc.next();
		}
		Select = sc.nextInt();

		return Select;
		// Select<1 Select>4
		// 0 TRUE FALSE
		// 1 FALSE FALSE
		// 2 FALSE FALSE
		// 3 FALSE FALSE
		// 4 FALSE FALSE
		// 5 FALSE TRUE

	}

	public int Number(String msg) {

		System.out.println(msg );
		while (!sc.hasNextInt()) {
			
			System.out.println(msg+"\n���ڸ� �Է����ּ���");
//			System.out.println("��ȣ�� �Է����ּ���.");
			sc.next();
		}
		Select = sc.nextInt();

		return Select;
	}

	public int Number(int min, int max) {

		do {
			System.out.println(min+"~"+max+"������ ���ڸ� �Է����ּ���");
			while (!sc.hasNextInt()) {
				
				System.out.println(min+"~"+max+"������ ���ڸ� �Է����ּ���");
				sc.next();
			}
			Select = sc.nextInt();

		} while (Select < min || Select > max);

		return Select;
	}

	public int Number(String msg, int min, int max) {

		do {
			System.out.println(msg);
			System.out.println(min+"~"+max+"������ ���ڸ� �Է����ּ���");
			while (!sc.hasNextInt()) {
				System.out.println(msg );
				System.out.println(min+"~"+max+"������ ���ڸ� �Է����ּ���");
				
				sc.next();
			}
			Select = sc.nextInt();

//		} while (Select >= min && Select <= max);
	} while (Select < min || Select > max);
		

		return Select;
	}

}