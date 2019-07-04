package Kiosk_InputChecker;

import java.util.Scanner;

public class Select {
	Scanner sc = new Scanner(System.in);
	int Select;

	public int Number() {

		System.out.println("숫자를 입력해주세요");
		while (!sc.hasNextInt()) {
			System.out.println("숫자를 입력해주세요");
			sc.next();
		}
		Select = sc.nextInt();

		return Select;

	}

	public int Number(String msg) {

		System.out.println(msg);
		while (!sc.hasNextInt()) {

			System.out.println(msg + "\n숫자를 입력해주세요");
			sc.next();
		}
		Select = sc.nextInt();

		return Select;
	}

	public int Number(int min, int max) {

		do {
			System.out.println(min + "~" + max + "사이의 숫자를 입력해주세요");
			while (!sc.hasNextInt()) {

				System.out.println(min + "~" + max + "사이의 숫자를 입력해주세요");
				sc.next();
			}
			Select = sc.nextInt();

		} while (Select < min || Select > max);

		return Select;
	}

	public int Number(String msg, int min, int max) {

		do {
			System.out.println(msg);
			System.out.println(min + "~" + max + "사이의 숫자를 입력해주세요");
			while (!sc.hasNextInt()) {
				System.out.println(msg);
				System.out.println(min + "~" + max + "사이의 숫자를 입력해주세요");

				sc.next();
			}
			Select = sc.nextInt();

		} while (Select < min || Select > max);
		return Select;
	}

}