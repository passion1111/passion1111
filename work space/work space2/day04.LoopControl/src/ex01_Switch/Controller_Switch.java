

package ex01_Switch;

public class Controller_Switch {
	public static void main(String[] args) {
		int point = 4;
			switch (point) { // 조건-문자형,정수형(long형제외) ,실수형 안됨.
								// 문자열넣을려면 case에 " " 문자는 ' ' jdk6.0이상부터 문자열가능
			case 1:
				System.out.println("점수가 1점입니다.");
				break;
	
			case 2:
				System.out.println("점수가 2점입니다.");
				break;
	
			case 3:
				System.out.println("점수가 3점입니다.");
				break;
			default:
				System.out.println("1~3까지만 입력해주세요");

		}// switch end

	}
}

