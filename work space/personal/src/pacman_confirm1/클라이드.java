package pacman_confirm1;

import java.util.Random;

public class Ŭ���̵� extends �� {
	// �׳� �ٺ�
	public void ���() {
		System.out.print("C");
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
		this.�̵�(����, this.�ĺ���ġ[seed]);
	}
}
