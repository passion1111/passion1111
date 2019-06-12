/*
 * 월을 입력하면 해당 월의 마지막 날짜를 알려주는 프로그램. 
 * 단, 2월은 윤년인지 확인하기 위해 연도도 입력 받아야 함. (윤년 : 29일, 평년 : 28일)
*/

package quiz;

import java.util.Scanner;

public class Quize_switch {
	public static void main(String[] args) {

		System.out.println("input month : ");
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		boolean flag = false;
		String str = null;

		switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				System.out.println(month + "월의 마지막 날은 31일 입니다.");
				break;
	
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println(month + "월의 마지막 날은 30일 입니다.");
				break;
			case 2:
				System.out.println("연도를 입력해주세요.");
				int year = sc.nextInt();
				if (year % 4 == 0) {
					if ((year % 100 != 0) || (year % 400 == 0)) {
						flag = true;
					} // if in end
				} // if out end
				str = (flag == true) ? year + "년도 " + month + "월의 마지막 날은 29일 입니다."
						: year + "년도 " + month + "월의 마지막 날은 28일 입니다.";
				System.out.println(str);
				break;
				
			default:
				System.out.println("잘못 입력하셨습니다. 1~12 사이의 숫자를 입력해주세요.");
				break;
		}
		sc.close();
	}

}
