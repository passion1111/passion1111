package quiz;

import java.util.Scanner;

public class Quiz_���¾� {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("name = ");
		String name = sc.next();
		int sum = 0;
		double avg = 0;
		String hak;

		int Score[][] = new int[2][3];
		try {
			for (int i = 0; i < Score.length; i++) {
				for (int j = 0; j < Score[i].length; j++) {
					if ((i + 1) != Score.length) {
						System.out.print("���� ���� ���� ������ �Է��ϼ��� : ");
						Score[i][j] = sc.nextInt();
					} else {
						sum += Score[0][j];
						avg = sum / 3.0;
					}
				}
				System.out.println();
			}

			if (avg >= 90) {
				hak = "A";
			} else if (avg >= 80) {
				hak = "B";
			} else if (avg >= 70) {
				hak = "C";
			} else if (avg >= 50) {
				hak = "D";
			} else
				hak = "F";

			System.out.printf("\n===== %s���� ����ǥ =====\n", name);
			System.out.printf("���� : %d ���� : %d ���� : %d\n", Score[0][0], Score[0][1], Score[0][2]);
			System.out.printf("���� : %s ��� : %.2f ���� : %s", sum, avg, hak);
		} catch (Exception e) {
			System.out.println("���ڸ� �Է�");
		} // try end
	} // main end
}
