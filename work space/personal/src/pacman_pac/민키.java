package pacman_pac;

import java.util.Random;

public class ��Ű extends �� {
	// �������̷� ������ ����
	int pattern_threshold = 20;
	int pattern_count = 0;
	int pattern_type = 0;
	Random rand = new Random();
	int seed;

	public void ���() {
		//��
		System.out.print("M");
	}

	public void �ڵ��̵�(�� ����, �� ��, �� ��, �� ��, �� ��) {
		pattern_count++;
		if (pattern_count >= pattern_threshold) {
			seed = (int) rand.nextInt(3);
			pattern_count = 0;
		}
		if (seed == 0) {
			�ڵ��̵�_Ŭ���̵�(����, ��, ��, ��, ��);
		} else if (seed == 1) {
			�ڵ��̵�_��Ű(����, ��, ��, ��, ��);
		} else if (seed == 2) {
			�ڵ��̵�_���Ű(����, ��, ��, ��, ��);
		}
	}

	public void �ڵ��̵�_Ŭ���̵�(�� ����, �� ��, �� ��, �� ��, �� ��) {
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
		this.�̵�(����, this.�ĺ���ġ[seed]);
	}
	public void �ڵ��̵�_���Ű(�� ����, �� ��, �� ��, �� ��, �� ��) {
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
		if (this.�ĺ���ġ[seed].��ǥx == ���x[t] && this.�ĺ���ġ[seed].��ǥy == ���y[t])
			seed = (int) rand.nextInt(count);
		if (this.�ĺ���ġ[seed].��ǥx == ���x[t] && this.�ĺ���ġ[seed].��ǥy == ���y[t])
			seed = (int) rand.nextInt(count);
		this.�̵�(����, this.�ĺ���ġ[seed]);
	}
	public void �ڵ��̵�_��Ű(�� ����, �� ��, �� ��, �� ��, �� ��) {
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
