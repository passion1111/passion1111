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
			System.out.print("\n" + (i + 1) + "��° ���� �Է��ϼ��� : ");
			int x = sc.nextInt();
			if ((i == 4) && (x != num)) {
				System.out.println("\n������ ������ ���߽��ϴ�. ������ : " + num + " �Դϴ�");
			} else if (x == num) {
				System.out.println("\n" + num + "�����Դϴ�");
				System.exit(0);
			} else if (x < num) {
				System.out.println("up�Դϴ�.");
			} else if (x > num) {
				System.out.println("down�Դϴ�.");
			}
		}
	}

	public static void main(String[] args) {
		Updown();
	}
}