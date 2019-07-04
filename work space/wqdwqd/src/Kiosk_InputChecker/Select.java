package Kiosk_InputChecker;

import java.util.Scanner;

public class Select {
	Scanner sc = new Scanner(System.in);
	int Select;

	public int Number() { //숫자만 들어올수있게

		System.out.println("숫자를 입력해주세요");
		while (!sc.hasNextInt()) {
			System.out.println("숫자를 입력해주세요");
			sc.next();
		}
		Select = sc.nextInt();

		return Select;
	

	}

	public int Number(String msg) {  //메뉴에 해당하는 숫자.

		System.out.println(msg );
		while (!sc.hasNextInt()) {
			
			System.out.println(msg+"\n숫자를 입력해주세요");
			sc.next();
		}
		Select = sc.nextInt();

		return Select;
	}

	public int Number(int min, int max) { //메뉴사이에 있는 번호만 입력할수있게만드는 생성자함수.

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

	} while (Select < min || Select > max);
		

		return Select;
	}

}