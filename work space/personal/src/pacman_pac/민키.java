package pacman_pac;

import java.util.Random;

public class 민키 extends 적 {
	// 변덕쟁이로 패턴이 랜덤
	int pattern_threshold = 20;
	int pattern_count = 0;
	int pattern_type = 0;
	Random rand = new Random();
	int seed;

	public void 출력() {
		//▨
		System.out.print("M");
	}

	public void 자동이동(맵 현재, 맵 상, 맵 하, 맵 좌, 맵 우) {
		pattern_count++;
		if (pattern_count >= pattern_threshold) {
			seed = (int) rand.nextInt(3);
			pattern_count = 0;
		}
		if (seed == 0) {
			자동이동_클라이드(현재, 상, 하, 좌, 우);
		} else if (seed == 1) {
			자동이동_핑키(현재, 상, 하, 좌, 우);
		} else if (seed == 2) {
			자동이동_블랑키(현재, 상, 하, 좌, 우);
		}
	}

	public void 자동이동_클라이드(맵 현재, 맵 상, 맵 하, 맵 좌, 맵 우) {
		Random rand = new Random();
		int seed;
		count = 0;
		if (상.상태 != 맵구성요소.벽 && 상.적 == null) {
			this.후보위치[count] = 상;
			count++;
		}
		if (하.상태 != 맵구성요소.벽 && 하.적 == null) {
			this.후보위치[count] = 하;
			count++;
		}
		if (좌.상태 != 맵구성요소.벽 && 좌.적 == null) {
			this.후보위치[count] = 좌;
			count++;
		}
		if (우.상태 != 맵구성요소.벽 && 우.적 == null) {
			this.후보위치[count] = 우;
			count++;
		}
		if (count == 0)
			return;
		seed = (int) rand.nextInt(count);
		this.이동(현재, this.후보위치[seed]);
	}
	public void 자동이동_블랑키(맵 현재, 맵 상, 맵 하, 맵 좌, 맵 우) {
		Random rand = new Random();
		int seed;
		count = 0;
		if (상.상태 != 맵구성요소.벽 && 상.적 == null) {
			this.후보위치[count] = 상;
			count++;
		}
		if (하.상태 != 맵구성요소.벽 && 하.적 == null) {
			this.후보위치[count] = 하;
			count++;
		}
		if (좌.상태 != 맵구성요소.벽 && 좌.적 == null) {
			this.후보위치[count] = 좌;
			count++;
		}
		if (우.상태 != 맵구성요소.벽 && 우.적 == null) {
			this.후보위치[count] = 우;
			count++;
		}
		if (count == 0)
			return;
		seed = (int) rand.nextInt(count);

		int t;
		if (index == 1)
			t = 2;
		else if (index == 0)
			t = 1;
		else
			t = 0;
		if (this.후보위치[seed].좌표x == 기록x[t] && this.후보위치[seed].좌표y == 기록y[t])
			seed = (int) rand.nextInt(count);
		if (this.후보위치[seed].좌표x == 기록x[t] && this.후보위치[seed].좌표y == 기록y[t])
			seed = (int) rand.nextInt(count);
		if (this.후보위치[seed].좌표x == 기록x[t] && this.후보위치[seed].좌표y == 기록y[t])
			seed = (int) rand.nextInt(count);
		if (this.후보위치[seed].좌표x == 기록x[t] && this.후보위치[seed].좌표y == 기록y[t])
			seed = (int) rand.nextInt(count);
		if (this.후보위치[seed].좌표x == 기록x[t] && this.후보위치[seed].좌표y == 기록y[t])
			seed = (int) rand.nextInt(count);
		if (this.후보위치[seed].좌표x == 기록x[t] && this.후보위치[seed].좌표y == 기록y[t])
			seed = (int) rand.nextInt(count);
		this.이동(현재, this.후보위치[seed]);
	}
	public void 자동이동_핑키(맵 현재, 맵 상, 맵 하, 맵 좌, 맵 우) {
		Random rand = new Random();
		int seed;
		count = 0;
		if (상.상태 != 맵구성요소.벽 && 상.적 == null) {
			this.후보위치[count] = 상;
			count++;
		}
		if (하.상태 != 맵구성요소.벽 && 하.적 == null) {
			this.후보위치[count] = 하;
			count++;
		}
		if (좌.상태 != 맵구성요소.벽 && 좌.적 == null) {
			this.후보위치[count] = 좌;
			count++;
		}
		if (우.상태 != 맵구성요소.벽 && 우.적 == null) {
			this.후보위치[count] = 우;
			count++;
		}
		if (count == 0)
			return;
		seed = (int) rand.nextInt(count);

		int t;
		if (index == 1)
			t = 2;
		else if (index == 0)
			t = 1;
		else
			t = 0;
		if (this.후보위치[seed].좌표x == 기록x[t] && this.후보위치[seed].좌표y == 기록y[t])
			seed = (int) rand.nextInt(count);
		if (this.후보위치[seed].좌표x == 기록x[t] && this.후보위치[seed].좌표y == 기록y[t])
			seed = (int) rand.nextInt(count);
		if (this.후보위치[seed].좌표x == 기록x[t] && this.후보위치[seed].좌표y == 기록y[t])
			seed = (int) rand.nextInt(count);
		if (this.후보위치[seed].좌표x == 기록x[t] && this.후보위치[seed].좌표y == 기록y[t])
			seed = (int) rand.nextInt(count);
		this.이동(현재, this.후보위치[seed]);
	}
}
