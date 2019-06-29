package pacman_pac;

//이 팩맨의 문제점은 콘솔창의 폰트가 코딩한사람이 설정한 폰트와 다르면 
//벽이 찌그러져보이고 캐릭터의 움직임이 이상해보인다.
//ui로 보면 강제로 폰트를 지정할수있는데 콘솔모드에서도 폰트를 강제할수있는지 알아야할것같다.


import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.Random;
import java.util.Scanner;

 class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int 행크기 = 23;
		final int 열크기 = 28;
		// 맵만들기

		class SharedArea {
			char 조작 = 'T';
			char 방향 = 'B';
			int 최고점수 = 1000;
			int 난이도 = 0;
			boolean 종료합니까 = false;
		}
		final SharedArea 공유영역 = new SharedArea();
		String selection;
		final Scanner scan = new Scanner(System.in);

		final 캐릭터 플레이어;
		final int 화면속도 = 200;

		시스템.ClearScreen();
		System.out
				.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out
				.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out
				.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out
				.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out
				.println("■┌──   ──  ┌──┐ ┌──  ┌─── ┌──  │     │  ──  │   │■");
		System.out
				.println("■│  │ │  │ │    │  │ │    │  │ │\\   /│ │  │ │\\  │■");
		System.out
				.println("■├──  ├──┤ │    ├──  ├─── ├──┘ │ \\ / │ ├──┤ │ \\ │■");
		System.out
				.println("■│    │  │ │    │  │ │    │ \\  │  │  │ │  │ │  \\│■");
		System.out
				.println("■│    │  │ └──┘ └──  └─── │  \\ │  │  │ │  │ │   │■");
		System.out
				.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out
				.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out
				.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out
				.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("		   1. 플레이");
		System.out.println("		   2. 종료");
		System.out
				.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out
				.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out
				.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out
				.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		selection = scan.nextLine();
		while (!selection.equals("1") && !selection.equals("2")) {
			System.out.println("잘못된 값을 입력하였습니다. 똑바로 쓰세요!");
			selection = scan.nextLine();
		}
		if (selection.equals("1")) {
			시스템.ClearScreen();
			System.out.println("캐릭터를 골라주세요!");
			System.out
					.println("1.팩맨 ♣	|별을 20개 먹으면 팩의 일족의 힘이 발휘되어 \n\t|변신(♥)하며 적을 물리칠 수 있습니다.");
			System.out
					.println("2.봄버맨♠	|폭탄(@)을 설치하여 적을 물리칠 수 있습니다.\n\t|폭탄은 3초 후 터집니다. 단 폭탄에 자신이 죽을 수도 있습니다.");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n");

		} else {
			시스템.ClearScreen();
			System.out.println("종료합니다.");
			scan.close();
			return;
		}
		selection = scan.nextLine();
		while (!selection.equals("1") && !selection.equals("2")) {
			System.out.println("잘못된 값을 입력하였습니다. 똑바로 쓰세요!");
			selection = scan.nextLine();
		}
		if (selection.equals("1")) {
			시스템.ClearScreen();
			System.out.println("팩맨을 선택하셨습니다.");
			플레이어 = new 팩맨();
		} else {
			시스템.ClearScreen();
			System.out.println("봄버맨을 선택하셨습니다.");
			플레이어 = new 봄버맨();
		}

		final 맵[][] 스테이지 = new 맵[행크기][열크기];
		for (int i = 0; i < 행크기; i++) {
			for (int j = 0; j < 열크기; j++) {
				스테이지[i][j] = new 맵(i, j);
			}
		}
		for (int i = 0; i < 행크기; i++) {
			for (int j = 0; j < 열크기; j++) {
				스테이지[i][j].위 = 스테이지[(스테이지[i][j].좌표x + 행크기 - 1) % 행크기][스테이지[i][j].좌표y];
				스테이지[i][j].아래 = 스테이지[(스테이지[i][j].좌표x + 1) % 행크기][스테이지[i][j].좌표y];
				스테이지[i][j].왼쪽 = 스테이지[스테이지[i][j].좌표x][(스테이지[i][j].좌표y + 열크기 - 1)
						% 열크기];
				스테이지[i][j].오른쪽 = 스테이지[스테이지[i][j].좌표x][(스테이지[i][j].좌표y + 1)
						% 열크기];
			}
		}

		for (int i = 0; i < 행크기; i++) {
			for (int j = 0; j < 열크기; j++) {
				스테이지[i][j].맵변형("벽");
			}
		}
		// 벽만들기

		for (int i = 1; i < 행크기 - 1; i++) {
			스테이지[i][6].맵변형("점수");
			스테이지[i][21].맵변형("점수");
		}
		for (int i = 1; i < 열크기 - 1; i++) {
			스테이지[1][i].맵변형("점수");
			스테이지[4][i].맵변형("점수");
			스테이지[6][i].맵변형("점수");
			스테이지[13][i].맵변형("점수");
			스테이지[15][i].맵변형("점수");
			스테이지[17][i].맵변형("점수");
			스테이지[19][i].맵변형("점수");
			스테이지[21][i].맵변형("점수");
		}
		for (int i = 0; i < 2; i++) {
			스테이지[1][13 + i].맵변형("벽");
			스테이지[6][7 + i].맵변형("벽");
			스테이지[6][13 + i].맵변형("벽");
			스테이지[6][19 + i].맵변형("벽");
			스테이지[15][13 + i].맵변형("벽");
			스테이지[19][13 + i].맵변형("벽");
			스테이지[10][7 + i].맵변형("길");
			스테이지[10][19 + i].맵변형("길");

			스테이지[17][4 + i].맵변형("벽");
			스테이지[17][22 + i].맵변형("벽");
			스테이지[19][7 + i].맵변형("벽");
			스테이지[19][19 + i].맵변형("벽");

		}
		for (int i = 0; i < 3; i++) {
			스테이지[i + 7][12].맵변형("점수");
			스테이지[i + 1][12].맵변형("점수");
			스테이지[i + 7][15].맵변형("점수");
			스테이지[i + 1][15].맵변형("점수");
			스테이지[8][i + 9].맵변형("길");
			스테이지[8][i + 16].맵변형("길");
			스테이지[21 - i][12].맵변형("점수");
			스테이지[21 - i][15].맵변형("점수");
			스테이지[21 - i][1].맵변형("점수");
			스테이지[21 - i][26].맵변형("점수");
			스테이지[9 + i][9].맵변형("길");
			스테이지[9 + i][18].맵변형("길");
			스테이지[11][14+i].맵변형("길");
			스테이지[11][11+i].맵변형("길");

		}
		스테이지[5][9].맵변형("점수");
		스테이지[5][18].맵변형("점수");
		스테이지[20][6].맵변형("벽");
		스테이지[20][21].맵변형("벽");
		스테이지[16][12].맵변형("점수");
		스테이지[16][15].맵변형("점수");
		스테이지[16][1].맵변형("점수");
		스테이지[16][26].맵변형("점수");
		스테이지[18][3].맵변형("점수");
		스테이지[18][24].맵변형("점수");
		스테이지[18][9].맵변형("점수");
		스테이지[18][18].맵변형("점수");
		스테이지[17][13].맵변형("길");
		스테이지[12][9].맵변형("길");
		스테이지[12][18].맵변형("길");
		스테이지[9][12].맵변형("길");
		스테이지[9][15].맵변형("길");
		스테이지[14][1].맵변형("점수");
		스테이지[14][26].맵변형("점수");

		for (int i = 0; i < 6; i++) {
			스테이지[i + 1][1].맵변형("점수");
			스테이지[i + 1][26].맵변형("점수");
			스테이지[8][i + 11].맵변형("길");
			스테이지[10][i].맵변형("길");
			스테이지[10][11 + i].맵변형("길");
			스테이지[10][27 - i].맵변형("길");
		}

		스테이지[15][4].맵변형("아이템");
		스테이지[15][24].맵변형("아이템");
		스테이지[1][9].맵변형("아이템");
		스테이지[4][23].맵변형("아이템");

		/*
		 * 
		 * 
		 * // 내부 벽 만들기 for (int i = 2; i < 행크기 / 2; i++) { for (int j = 2; j <
		 * 열크기 / 2; j++) { 스테이지[i * 2 + 1][2 * j + 1].맵변형("벽"); } } for (int i =
		 * 2; i < 행크기 - 3; i++) { 스테이지[i][3].맵변형("아이템"); }
		 */

		시스템.게임시작();
		시스템.시작위치_적 = 스테이지[10][13];

		Runnable 화면출력 = new Runnable() {

			public void run() {
				int life_count = 1;
				int clear_count = 0;
				int 알림시간 = 0;
				while (true) {
					시스템.ClearScreen();
					clear_count = 0;
					if (플레이어.점수 >= life_count * 2500) {
						life_count++;
						플레이어.목숨++;
						알림시간 = 4000;
					}
					if (알림시간 > 0) {
						System.out.println(((life_count - 1) * 2500)
								+ "점을 넘겨서 LIFE UP!!");
						알림시간 = 알림시간 - 화면속도;
					}

					if (플레이어.점수 >= 공유영역.최고점수)
						공유영역.최고점수 = 플레이어.점수;
					System.out.println("1P\tHIGH SCORE\tLIFE");
					System.out.println("" + 플레이어.점수 + "\t   " + 공유영역.최고점수
							+ "\t\t" + 플레이어.목숨);
					for (int i = 0; i < 행크기; i++) {
						for (int j = 0; j < 열크기; j++) {
							if (스테이지[i][j].상태 == 맵구성요소.점수
									|| 스테이지[i][j].상태 == 맵구성요소.아이템)
								clear_count++;
							스테이지[i][j].출력();
						}
						System.out.println();
					}
					System.out.println("-----------------------------");
					System.out
							.println("도움말\n방향전환:W,A,S,D 입력 후 엔터.\n(봄버맨)폭탄설치: 스페이스바 입력 후 엔터\n★:(팩맨)변신아이템\n♣/♠: 캐릭터\nB,M,C,P:적군   \n클리어 조건: \'와 아이템을 전부 먹기!");
					if (clear_count == 0) {
						공유영역.종료합니까 = true;
						시스템.클리어();
						break;
					}
					try {
						Thread.sleep(화면속도);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread 화면 = new Thread(화면출력);

		final 클라이드 클라 = new 클라이드();
		Runnable 클라이드행동 = new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				int x, y;
				x = 10;
				y = 13;
				클라.맵인(스테이지[x][y]);
				while (true) {
					클라.자동이동(클라.현재위치,
							스테이지[(클라.현재위치.좌표x + 행크기 - 1) % 행크기][클라.현재위치.좌표y],
							스테이지[(클라.현재위치.좌표x + 1) % 행크기][클라.현재위치.좌표y],
							스테이지[클라.현재위치.좌표x][(클라.현재위치.좌표y + 열크기 - 1) % 열크기],
							스테이지[클라.현재위치.좌표x][(클라.현재위치.좌표y + 1) % 열크기]);

					try {
						Thread.sleep(클라.이동속도 * (10 - 공유영역.난이도) / 10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread 클라이동 = new Thread(클라이드행동);

		final 블랑키 블랑 = new 블랑키();
		Runnable 블랑키행동 = new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				int x, y;
				x = 10;
				y = 14;
				블랑.맵인(스테이지[x][y]);
				while (true) {
					블랑.자동이동(블랑.현재위치,
							스테이지[(블랑.현재위치.좌표x + 행크기 - 1) % 행크기][블랑.현재위치.좌표y],
							스테이지[(블랑.현재위치.좌표x + 1) % 행크기][블랑.현재위치.좌표y],
							스테이지[블랑.현재위치.좌표x][(블랑.현재위치.좌표y + 열크기 - 1) % 열크기],
							스테이지[블랑.현재위치.좌표x][(블랑.현재위치.좌표y + 1) % 열크기]);

					try {
						Thread.sleep(블랑.이동속도 * (10 - 공유영역.난이도) / 10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread 블랑키이동 = new Thread(블랑키행동);
		final 핑키 핑 = new 핑키();
		Runnable 핑키행동 = new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				int x, y;
				x = 10;
				y = 16;
				핑.맵인(스테이지[x][y]);
				while (true) {
					핑.자동이동(핑.현재위치,
							스테이지[(핑.현재위치.좌표x + 행크기 - 1) % 행크기][핑.현재위치.좌표y],
							스테이지[(핑.현재위치.좌표x + 1) % 행크기][핑.현재위치.좌표y],
							스테이지[핑.현재위치.좌표x][(핑.현재위치.좌표y + 열크기 - 1) % 열크기],
							스테이지[핑.현재위치.좌표x][(핑.현재위치.좌표y + 1) % 열크기]);

					try {
						Thread.sleep(핑.이동속도 * (10 - 공유영역.난이도) / 10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread 핑키이동 = new Thread(핑키행동);

		final 민키 민 = new 민키();
		Runnable 민키행동 = new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				int x, y;
				x = 10;
				y = 11;
				민.맵인(스테이지[x][y]);
				while (true) {
					민.자동이동(민.현재위치,
							스테이지[(민.현재위치.좌표x + 행크기 - 1) % 행크기][민.현재위치.좌표y],
							스테이지[(민.현재위치.좌표x + 1) % 행크기][민.현재위치.좌표y],
							스테이지[민.현재위치.좌표x][(민.현재위치.좌표y + 열크기 - 1) % 열크기],
							스테이지[민.현재위치.좌표x][(민.현재위치.좌표y + 1) % 열크기]);

					try {
						Thread.sleep(민.이동속도 * (10 - 공유영역.난이도) / 10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread 민키이동 = new Thread(민키행동);

		final Scanner sc = new Scanner(System.in);

		String select = "gg";
		// char 방향 = ' ';

		Runnable 팩맨이동 = new Runnable() {

			SharedArea 공유;

			public void run() {
				// TODO Auto-generated method stub
				int x, y;
				x = 17;
				y = 13;
				플레이어.맵인(스테이지[x][y]);
				시스템.시작위치 = 스테이지[x][y];
				공유 = 공유영역;
				char 방향 = 공유.방향;
				while (true) {
					// System.out.println("팩맨이동 스레드 내부 ---------");
					방향 = 공유.방향;
					// System.out.println("바뀐방향은  "+향);
					// System.out.println("----------");
					플레이어.이동(방향,
							플레이어.현재위치,
							스테이지[(플레이어.현재위치.좌표x + 행크기 - 1) % 행크기][플레이어.현재위치.좌표y],
							스테이지[(플레이어.현재위치.좌표x + 1) % 행크기][플레이어.현재위치.좌표y],
							스테이지[플레이어.현재위치.좌표x][((플레이어.현재위치.좌표y + 열크기 - 1) % 열크기)],
							스테이지[플레이어.현재위치.좌표x][((플레이어.현재위치.좌표y + 1) % 열크기)]);
					if (공유.조작 == ' ') {
						공유.조작 = 'O';
						플레이어.행동();
					}
					try {
						Thread.sleep(플레이어.이동속도);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread 팩맨스레드 = new Thread(팩맨이동);

		화면.start();
		블랑키이동.start();
		민키이동.start();
		핑키이동.start();
		클라이동.start();
		팩맨스레드.start();

		while (((select = sc.nextLine()) != null) && !공유영역.종료합니까) {
			if (!select.equals("")) {
				공유영역.방향 = select.charAt(0);
				if (select.contains(" ")) {
					공유영역.조작 = ' ';
				}
			}
		}
		화면.stop();
		블랑키이동.stop();
		민키이동.stop();
		핑키이동.stop();
		클라이동.stop();
		팩맨스레드.stop();
		sc.close();

		scan.close();
		시스템.ClearScreen();
		System.out.println("종료합니다!");
		return;
	}
}
