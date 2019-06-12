package Quiz_if;

import java.util.Scanner;

public class Quiz_Homework {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("3개의 정수를 입력하세요.");
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			String soo = null;
			// 3개 한번에 식을 만들어 간단히 비교해도 되는데 if문 연습하고 싶어서 복잡하게 하나씩 비교 해보았습니다.
			// ex) if (number1 >= number2 && number1 >= number3)
			if (x > y) {
				if (x == z) {
					soo = ("결과 : " + x + " = " + z + " > " + y);
				}
				if (x > z) {
					if (z > y) {
						soo = ("결과 : " + x + " > " + z + " > " + y);
					} else if (y > z) {
						soo = ("결과 : " + x + " > " + y + " > " + z);
					} else if (y == z) {
						soo = ("결과 : " + x + " > " + z + " = " + y);
					}
				}
				if (x < z) {
					soo = ("결과 : " + z + " > " + x + " > " + y);
				} else if (x == y) {
					soo = ("결과 : " + z + " > " + x + " = " + y);
				}
			} else if (y > z) {
				if ((z > x) || (x == y)) {
					soo = ("결과 : " + y + " = " + x + " > " + z);
				} else if (x > z) {
					soo = ("결과 : " + y + " > " + x + " > " + z);
				} else if (z > x) {
					soo = ("결과 : " + y + " > " + z + " > " + x);
				} else if (z == x) {
					soo = ("결과 : " + y + " > " + x + " = " + z);
				}

			} else if (z > x) {
				if (x == y) {
					soo = ("결과 : " + z + " > " + y + " = " + x);
				} else if (y > z) {
					soo = ("결과 : " + y + " > " + z + " > " + x);
				} else if (z > y) {
					soo = ("결과 : " + z + " > " + y + " > " + x);
				} else if (y == z) {
					soo = ("결과 : " + z + " = " + y + " > " + x);
				}

			} else if ((x == y) && (y == z)) {
				soo = ("같은 수 입니다.");
			}
			System.out.println(soo);
			sc.close();
		} catch (Exception e) {
			System.out.println("정수만 입력하세요.");
			e.printStackTrace();
		}

	} // end main
} // end class
