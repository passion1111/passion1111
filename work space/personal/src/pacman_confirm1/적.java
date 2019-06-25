package pacman_confirm1;

public class 적 extends 유닛 {
	int[] 기록x = new int[3];
	int[] 기록y = new int[3];
	맵[] 후보위치 = new 맵[4];
	int index = 0;
	int count = 0;
	public int 이동속도 = 600;

	public 적() {
		기록x[0] = 기록x[1] = 기록x[2] = -1;
		기록y[0] = 기록y[1] = 기록y[2] = -1;
	}

	public void 맵인(맵 위치) {
		기록x[index] = 위치.좌표x;
		기록y[index] = 위치.좌표y;
		index++;
		index = index % 3;
		위치.적 = this;
		this.현재위치 = 위치;
		// 위치.적군리스트.add(this);
	}

	public void 맵아웃(맵 위치) {
		// 위치.적군리스트.remove(this);
		
		위치.적 = null;
	}

	public void 이동(맵 이전위치, 맵 이후위치) {
		맵인(이후위치);
		맵아웃(이전위치);
	}

	public void 출력() {

	}
	public void 포식(캐릭터 캐릭터) {
		if(!캐릭터.무적) {
			캐릭터.죽음();
		} else {
			캐릭터.반격(this);
		}
	}
	public void 죽음() {
		this.이동(현재위치, 시스템.시작위치_적);
	}
}
