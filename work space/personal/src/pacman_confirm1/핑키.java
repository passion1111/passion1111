package pacman_confirm1;

import java.util.Random;

public class ��Ű extends �� {
	// �������ų� ���ư��� Ÿ�� -> ������ ����
	public void ���() {
		System.out.print("P");
	}

	public void �ڵ��̵�(�� ����, �� ��, �� ��, �� ��, �� ��) {
		Random rand = new Random();
		int seed;
		count = 0;
		if (��.���� != �ʱ������.�� && ��.�� == null) {
			this.�ĺ���ġ[count] = ��;
			count++;
		}
		if (��.���� != �ʱ������.�� && ��.�� == null) {
			this.�ĺ���ġ[count] = ��;
			count++;
		}
		if (��.���� != �ʱ������.�� && ��.�� == null) {
			this.�ĺ���ġ[count] = ��;
			count++;
		}
		if (��.���� != �ʱ������.�� && ��.�� == null) {
			this.�ĺ���ġ[count] = ��;
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
		if (this.�ĺ���ġ[seed].��ǥx == ���x[t] && this.�ĺ���ġ[seed].��ǥy == ���y[t])
			seed = (int) rand.nextInt(count);
		if (this.�ĺ���ġ[seed].��ǥx == ���x[t] && this.�ĺ���ġ[seed].��ǥy == ���y[t])
			seed = (int) rand.nextInt(count);
		if (this.�ĺ���ġ[seed].��ǥx == ���x[t] && this.�ĺ���ġ[seed].��ǥy == ���y[t])
			seed = (int) rand.nextInt(count);
		if (this.�ĺ���ġ[seed].��ǥx == ���x[t] && this.�ĺ���ġ[seed].��ǥy == ���y[t])
			seed = (int) rand.nextInt(count);
		this.�̵�(����, this.�ĺ���ġ[seed]);
	}
}
