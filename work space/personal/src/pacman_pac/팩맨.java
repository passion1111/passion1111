package pacman_pac;

public class �Ѹ� extends ĳ���� {
	// �⺻���� ����� �Ѹ�. ���� 20�� ������ �����ð����� ��ȭ�ؼ� ���� ��Ƹ��� �� �ִ�.
	int star_count = 0; // ���� �Դ� Ƚ��
	char ��� = '��';
	boolean ���Ż��� = false;
	int ���Žð� = 0;
	int ���ӽð� = 5000;

	public void ���() {
		if (���Ż���) {
			���Žð� += 200;
			��� = '��';
			if (���Žð� >= ���ӽð�) {
				���Ż��� = false;
				���� = false;
				���Žð� = 0;
				��� = '��';
			}

		} else {
			���Žð� = 0;
			��� = '��';
		}
		System.out.print(���);
	}

	public void Eat() {
		if (this.������ġ.���� == �ʱ������.����) {
			this.���� += 10;
			this.star_count++;
			if (star_count == 20) {
				this.star_count = 0;
				this.����();
			}
			this.������ġ.���� = �ʱ������.��;
		}
		if (this.������ġ.���� == �ʱ������.������) {
			this.���� += 200;
			this.������ġ.���� = �ʱ������.��;
			this.����();
		}
	}

	public void ����() {
		���Ż��� = true;
		���� = true;
		���Žð� = 0;
	}

	
}
