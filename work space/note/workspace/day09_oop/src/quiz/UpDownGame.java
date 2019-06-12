package quiz;

import java.util.Random;
import java.util.Scanner;

public class UpDownGame {
	public static int num() {
		Random rr = new Random();
		int num = rr.nextInt(100) + 1;
		return num;
	}

	public static void Updown() {
		Scanner sc = new Scanner(System.in);
		int num = num();
		for (int i = 0; i < 5; i++) {
			System.out.print("\n" + (i + 1) + "번째 답을 입력하세요 : ");
			int x = sc.nextInt();
			if ((i == 4) && (x != num)) {
				System.out.println("\n정답을 맞추지 못했습니다. 정답은 : " + num + " 입니다");
			} else if (x == num) {
				System.out.println("\n" + num + "정답입니다");
				System.exit(0);
			} else if (x < num) {
				System.out.println("up입니다.");
			} else if (x > num) {
				System.out.println("down입니다.");
			}
		}
	}

	public static void main(String[] args) {
		Updown();
	}
}