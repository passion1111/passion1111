package pacman_confirm1;

public class 시스템 {

	public static 맵 시작위치 = null;
	public static 맵 시작위치_적 = null;

	public static void 게임오버() {
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

	public static void 게임시작() {
		System.out.println("시작합니다!");
		for (int i = 0; i < 3; i++) {
			System.out.println((3 - i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void 클리어() {
		ClearScreen();
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■■┌──┐  │     ┌───   ──   ┌── ■■■");
		System.out.println("■■■│     │     │     │  │  │  │■■■");
		System.out.println("■■■│     │     ├───  ├──┤  ├──┘■■■");
		System.out.println("■■■│     │     │     │  │  │ \\ ■■■");
		System.out.println("■■■└──┘  └───  └───  │  │  │  \\■■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
