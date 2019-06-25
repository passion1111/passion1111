package pacman_confirm1;

import java.util.ArrayList;

enum 맵구성요소 {
	벽, 길, 아이템, 점수, 폭발, 폭탄;
	
} // 맵 = '■' 길 = ' ' 아이템 = '☆' 점수 = '*' 폭발 = '※'


public class 맵 {
	public int 좌표x;
	public int 좌표y;
	맵구성요소 상태;
	맵구성요소 이전상태;
	// ArrayList<유닛> 유닛리스트 = new ArrayList<유닛>();
	// ArrayList<캐릭터> 캐릭터리스트 = new ArrayList<캐릭터>();
	// ArrayList<적군> 적군리스트 = new ArrayList<적군>();
	적 적 = null;
	캐릭터 캐릭터 = null;
	맵 위;
	맵 아래;
	맵 오른쪽;
	맵 왼쪽;
	맵() {
		상태 = 맵구성요소.점수;
	}

	public 맵(int x, int y) {
		좌표x = x;
		좌표y = y;
		상태 = 맵구성요소.점수;
	}

	public void 맵변형(String 상태) {
		if (상태.equals("벽")) {
			this.상태 = 맵구성요소.벽;
		} else if (상태.equals("길")) {
			this.상태 = 맵구성요소.길;
		} else if (상태.equals("아이템")) {
			this.상태 = 맵구성요소.아이템;
		} else if (상태.equals("점수")) {
			this.상태 = 맵구성요소.점수;
		} else if (상태.equals("폭발")) {
			this.상태 = 맵구성요소.폭발;
		} else if (상태.equals("폭탄")) {
			this.상태 = 맵구성요소.폭탄;
		} else {
			System.out.println("주의! 상태는 벽, 길, 아이템, 점수, 폭발, 폭탄만을 가집니다.");
		}
	}

	public void 출력() {
		boolean flag = true;
		if (적 != null && 캐릭터 != null) {
			적.포식(캐릭터);
		}

		if (캐릭터 != null) {
			// System.out.println("캐릭터 출력 실행");
			if(상태 == 맵구성요소.폭발) {

				System.out.print('#');
				캐릭터.죽음(); return;
			}
			캐릭터.출력();
			flag = false;
		}
		
		if (적 != null) {
			if(상태 == 맵구성요소.폭발) {
				System.out.print('#');
				적.이동(적.현재위치, 시스템.시작위치_적);
				return;
			}
			적.출력();
			flag = false;
		}
		
		if (flag) {
			if (상태 == 맵구성요소.벽)
				System.out.print('■');
			else if (상태 == 맵구성요소.길)
				System.out.print(' ');
			else if (상태 == 맵구성요소.아이템)
				System.out.print('★');
			else if (상태 == 맵구성요소.점수)
				System.out.print('\'');
			else if (상태 == 맵구성요소.폭발)
				System.out.print('#');
			else if (상태 == 맵구성요소.폭탄)
				System.out.print('@');
		}
		return;
	}
	

}
