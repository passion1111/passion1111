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
			
			System.out.println(msg+"\n숫자를 입력해주세요");
//			System.out.println("번호를 입력해주세요.");
			sc.next();
		}
		Select = sc.nextInt();

		return Select;
	}

	public int Number(int min, int max) {

		do {
			System.out.println(min+"~"+max+"사이의 숫자를 입력해주세요");
			while (!sc.hasNextInt()) {
				
				System.out.println(min+"~"+max+"사이의 숫자를 입력해주세요");
				sc.next();
			}
			Select = sc.nextInt();

		} while (Select < min || Select > max);

		return Select;
	}

	public int Number(String msg, int min, int max) {

		do {
			System.out.println(msg);
			System.out.println(min+"~"+max+"사이의 숫자를 입력해주세요");
			while (!sc.hasNextInt()) {
				System.out.println(msg );
				System.out.println(min+"~"+max+"사이의 숫자를 입력해주세요");
				
				sc.next();
			}
			Select = sc.nextInt();

//		} while (Select >= min && Select <= max);
	} while (Select < min || Select > max);
		

		return Select;
	}

}