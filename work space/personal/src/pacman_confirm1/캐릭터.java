package pacman_confirm1;

public class 캐릭터 extends 유닛 {
	public int 목숨 = 2;
	public int 점수 = 0;
	맵 후보위치;
	public int 이동속도 = 400;

	public void 이동(char 방향, 맵 현재, 맵 상, 맵 하, 맵 좌, 맵 우) {
		// System.out.println("캐릭터 행동함수 -----");
		if (방향 == 'w' || 방향 == 'W' || 방향 == 'ㅈ') {
			if (상.상태 != 맵구성요소.벽) {
				후보위치 = 상;
				this.이동(현재, 후보위치);
			}

		} else if (방향 == 's' || 방향 == 'S' || 방향 == 'ㄴ') {
			if (하.상태 != 맵구성요소.벽) {
				후보위치 = 하;
				this.이동(현재, 후보위치);
			}
		} else if (방향 == 'a' || 방향 == 'A' || 방향 == 'ㅁ') {
			if (좌.상태 != 맵구성요소.벽) {
				후보위치 = 좌;
				this.이동(현재, 후보위치);
			}
		} else if (방향 == 'd' || 방향 == 'D' || 방향 == 'ㅇ') {
			if (우.상태 != 맵구성요소.벽) {
				후보위치 = 우;
				this.이동(현재, 후보위치);
			}
		}
		// System.out.println("나감-------");
	}

	public void 행동() {

	}

	public void Eat() {
		if (this.현재위치.상태 == 맵구성요소.점수) {
			this.점수 += 10;
			this.현재위치.상태 = 맵구성요소.길;
		}
		if (this.현재위치.상태 == 맵구성요소.아이템) {
			this.점수 += 200;
			this.현재위치.상태 = 맵구성요소.길;
		}
	}

	public void 맵인(맵 위치) {
		위치.캐릭터 = this;
		this.현재위치 = 위치;
		this.Eat();
		// 위치.캐릭터리스트.add(this);
	}

	public void 맵아웃(맵 위치) {
		// 위치.캐릭터리스트.remove(this);

		위치.캐릭터 = null;
	}

	public void 이동(맵 이전위치, 맵 이후위치) {
		맵인(이후위치);
		맵아웃(이전위치);
	}

	public void 출력() {
		System.out.print('X');
	}

	public void 반격(적 적) {
		this.점수 += 500;
		적.죽음();
	}

	public void 죽음() {
		목숨--;

		시스템.ClearScreen();

		if (목숨 < 0) {
			시스템.게임오버();
		} else {
			시스템.ClearScreen();
			this.무적 = true;
			System.out.println("죽었습니다 ㅠㅠ");
			System.out.println("3초 후 다시 시작합니다!");
			for (int i = 0; i < 3; i++) {
				System.out.println((3 - i));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.이동(현재위치, 시스템.시작위치);

			this.무적 = false;
		}
	}

}
