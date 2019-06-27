package pacman_pac;

public class 팩맨 extends 캐릭터 {
	// 기본적인 모양의 팩맨. 별을 20개 먹으면 일정시간동안 강화해서 유령 잡아먹을 수 있다.
	int star_count = 0; // 별을 먹는 횟수
	char 모습 = '♣';
	boolean 변신상태 = false;
	int 변신시간 = 0;
	int 지속시간 = 5000;

	public void 출력() {
		if (변신상태) {
			변신시간 += 200;
			모습 = '♥';
			if (변신시간 >= 지속시간) {
				변신상태 = false;
				무적 = false;
				변신시간 = 0;
				모습 = '♣';
			}

		} else {
			변신시간 = 0;
			모습 = '♣';
		}
		System.out.print(모습);
	}

	public void Eat() {
		if (this.현재위치.상태 == 맵구성요소.점수) {
			this.점수 += 10;
			this.star_count++;
			if (star_count == 20) {
				this.star_count = 0;
				this.변신();
			}
			this.현재위치.상태 = 맵구성요소.길;
		}
		if (this.현재위치.상태 == 맵구성요소.아이템) {
			this.점수 += 200;
			this.현재위치.상태 = 맵구성요소.길;
			this.변신();
		}
	}

	public void 변신() {
		변신상태 = true;
		무적 = true;
		변신시간 = 0;
	}

	
}
