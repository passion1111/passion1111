package homework;

import java.util.Scanner;

public class Change {
	public static void main(String[] args) {
		
		int num1, num2, num3, max = 0, mid = 0, min = 0;
		Scanner s = new Scanner(System.in);
		char con;

		try {
			while (true) {
				System.out.print("ù ��° ���� �Է��ϼ��� : ");
				num1 = s.nextInt();

				System.out.print("�� ��° ���� �Է��ϼ��� : ");
				num2 = s.nextInt();

				System.out.print("�� ��° ���� �Է��ϼ��� : ");
				num3 = s.nextInt();

				if (num1 > num2) {
					if (num1 > num3) {
						max = num1;
						if (num2 > num3) {
							mid = num2;
							min = num3;
						} else {
							mid = num3;
							min = num2;
						}
					}

				} else if (num2 > num3) {
					max = num2;
					if (num1 > num3) {
						mid = num1;
						min = num3;
					} else {
						mid = num3;
						min = num1;
					}
				} else {
					max = num3;
					mid = num2;
					min = num1;
				}

				System.out.println("max = " + max);
				System.out.println("mid = " + mid);
				System.out.println("min = " + min);
				System.out.print("continue?(y,n) ");
				con = s.next().charAt(0);
				if (con == 'y' || con == 'Y')
					continue;
				else
					break;
			}
		} catch (Exception e) {
			System.out.println("���� �Դϴ� ������ �Է��� �ּ���");

		}

	}
}
