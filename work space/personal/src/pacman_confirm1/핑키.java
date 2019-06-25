package pacman_confirm1;

import java.util.Random;

public class 핑키 extends 적 {
	// 앞지르거나 돌아가는 타입 -> 후진을 덜함
	public void 출력() {
		System.out.print("P");
	}

	public void 자동이동(맵 현재, 맵 상, 맵 하, 맵 좌, 맵 우) {
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
