package pacman_confirm1;

public class �� extends ���� {
	int[] ���x = new int[3];
	int[] ���y = new int[3];
	��[] �ĺ���ġ = new ��[4];
	int index = 0;
	int count = 0;
	public int �̵��ӵ� = 600;

	public ��() {
		���x[0] = ���x[1] = ���x[2] = -1;
		���y[0] = ���y[1] = ���y[2] = -1;
	}

	public void ����(�� ��ġ) {
		���x[index] = ��ġ.��ǥx;
		���y[index] = ��ġ.��ǥy;
		index++;
		index = index % 3;
		��ġ.�� = this;
		this.������ġ = ��ġ;
		// ��ġ.��������Ʈ.add(this);
	}

	public void �ʾƿ�(�� ��ġ) {
		// ��ġ.��������Ʈ.remove(this);
		
		��ġ.�� = null;
	}

	public void �̵�(�� ������ġ, �� ������ġ) {
		����(������ġ);
		�ʾƿ�(������ġ);
	}

	public void ���() {

	}
	public void ����(ĳ���� ĳ����) {
		if(!ĳ����.����) {
			ĳ����.����();
		} else {
			ĳ����.�ݰ�(this);
		}
	}
	public void ����() {
		this.�̵�(������ġ, �ý���.������ġ_��);
	}
}
