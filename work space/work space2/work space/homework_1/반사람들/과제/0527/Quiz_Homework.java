package Quiz_if;

import java.util.Scanner;

public class Quiz_Homework {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("3���� ������ �Է��ϼ���.");
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			String soo = null;
			// 3�� �ѹ��� ���� ����� ������ ���ص� �Ǵµ� if�� �����ϰ� �; �����ϰ� �ϳ��� �� �غ��ҽ��ϴ�.
			// ex) if (number1 >= number2 && number1 >= number3)
			if (x > y) {
				if (x == z) {
					soo = ("��� : " + x + " = " + z + " > " + y);
				}
				if (x > z) {
					if (z > y) {
						soo = ("��� : " + x + " > " + z + " > " + y);
					} else if (y > z) {
						soo = ("��� : " + x + " > " + y + " > " + z);
					} else if (y == z) {
						soo = ("��� : " + x + " > " + z + " = " + y);
					}
				}
				if (x < z) {
					soo = ("��� : " + z + " > " + x + " > " + y);
				} else if (x == y) {
					soo = ("��� : " + z + " > " + x + " = " + y);
				}
			} else if (y > z) {
				if ((z > x) || (x == y)) {
					soo = ("��� : " + y + " = " + x + " > " + z);
				} else if (x > z) {
					soo = ("��� : " + y + " > " + x + " > " + z);
				} else if (z > x) {
					soo = ("��� : " + y + " > " + z + " > " + x);
				} else if (z == x) {
					soo = ("��� : " + y + " > " + x + " = " + z);
				}

			} else if (z > x) {
				if (x == y) {
					soo = ("��� : " + z + " > " + y + " = " + x);
				} else if (y > z) {
					soo = ("��� : " + y + " > " + z + " > " + x);
				} else if (z > y) {
					soo = ("��� : " + z + " > " + y + " > " + x);
				} else if (y == z) {
					soo = ("��� : " + z + " = " + y + " > " + x);
				}

			} else if ((x == y) && (y == z)) {
				soo = ("���� �� �Դϴ�.");
			}
			System.out.println(soo);
			sc.close();
		} catch (Exception e) {
			System.out.println("������ �Է��ϼ���.");
			e.printStackTrace();
		}

	} // end main
} // end class
