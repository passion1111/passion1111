package ex02.Switch;

import java.util.Scanner;

public class Controller_Switch {
	public static void main(String[] args) {
		System.out.print("point = ? ");
		int point = new Scanner(System.in).nextInt();

		switch (point) { // 조건 - 문자형,정수형(long형제외), 실수형 안됨
			case 1:
				System.out.print("포인트 점수 1점입니다.");
				break;
	
			case 2:
				System.out.print("포인트 점수 2점입니다.");
				break;
	
			case 3:
				System.out.print("포인트 점수 3점입니다.");
				break;
				
			default:
				System.out.println("없는 점수 입니다.1~3까지만 입력 요망");
		} // switch end
	}
}
