package pacman_confirm1;

public class �ý��� {

	public static �� ������ġ = null;
	public static �� ������ġ_�� = null;

	public static void ���ӿ���() {
		ClearScreen();
		System.out
				.println("GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("    GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("    GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("    GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("    GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("    GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("    GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("    GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("    GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("    GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("    GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("    GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("    GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("    GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("    GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("    GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("    GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("    GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("    GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("    GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("    GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");
		System.out
				.println("    GAME OVER   GAME OVER   GAME OVER   GAME OVER   GAME OVER   ");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void ClearScreen() {
		for (int i = 0; i < 50; i++)
			System.out.println();
	}

	public static void ���ӽ���() {
		System.out.println("�����մϴ�!");
		for (int i = 0; i < 3; i++) {
			System.out.println((3 - i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void Ŭ����() {
		ClearScreen();
		System.out.println("�����������������������������������");
		System.out.println("�����������������������������������");
		System.out.println("���ᦣ������  ��     ��������   ����   ������ ����");
		System.out.println("���ᦢ     ��     ��     ��  ��  ��  ������");
		System.out.println("���ᦢ     ��     ��������  ��������  ������������");
		System.out.println("���ᦢ     ��     ��     ��  ��  �� \\ ����");
		System.out.println("���ᦦ������  ��������  ��������  ��  ��  ��  \\����");
		System.out.println("�����������������������������������");
		System.out.println("�����������������������������������");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
