package pacman_confirm1;

public class ĳ���� extends ���� {
	public int ��� = 2;
	public int ���� = 0;
	�� �ĺ���ġ;
	public int �̵��ӵ� = 400;

	public void �̵�(char ����, �� ����, �� ��, �� ��, �� ��, �� ��) {
		// System.out.println("ĳ���� �ൿ�Լ� -----");
		if (���� == 'w' || ���� == 'W' || ���� == '��') {
			if (��.���� != �ʱ������.��) {
				�ĺ���ġ = ��;
				this.�̵�(����, �ĺ���ġ);
			}

		} else if (���� == 's' || ���� == 'S' || ���� == '��') {
			if (��.���� != �ʱ������.��) {
				�ĺ���ġ = ��;
				this.�̵�(����, �ĺ���ġ);
			}
		} else if (���� == 'a' || ���� == 'A' || ���� == '��') {
			if (��.���� != �ʱ������.��) {
				�ĺ���ġ = ��;
				this.�̵�(����, �ĺ���ġ);
			}
		} else if (���� == 'd' || ���� == 'D' || ���� == '��') {
			if (��.���� != �ʱ������.��) {
				�ĺ���ġ = ��;
				this.�̵�(����, �ĺ���ġ);
			}
		}
		// System.out.println("����-------");
	}

	public void �ൿ() {

	}

	public void Eat() {
		if (this.������ġ.���� == �ʱ������.����) {
			this.���� += 10;
			this.������ġ.���� = �ʱ������.��;
		}
		if (this.������ġ.���� == �ʱ������.������) {
			this.���� += 200;
			this.������ġ.���� = �ʱ������.��;
		}
	}

	public void ����(�� ��ġ) {
		��ġ.ĳ���� = this;
		this.������ġ = ��ġ;
		this.Eat();
		// ��ġ.ĳ���͸���Ʈ.add(this);
	}

	public void �ʾƿ�(�� ��ġ) {
		// ��ġ.ĳ���͸���Ʈ.remove(this);

		��ġ.ĳ���� = null;
	}

	public void �̵�(�� ������ġ, �� ������ġ) {
		����(������ġ);
		�ʾƿ�(������ġ);
	}

	public void ���() {
		System.out.print('X');
	}

	public void �ݰ�(�� ��) {
		this.���� += 500;
		��.����();
	}

	public void ����() {
		���--;

		�ý���.ClearScreen();

		if (��� < 0) {
			�ý���.���ӿ���();
		} else {
			�ý���.ClearScreen();
			this.���� = true;
			System.out.println("�׾����ϴ� �Ф�");
			System.out.println("3�� �� �ٽ� �����մϴ�!");
			for (int i = 0; i < 3; i++) {
				System.out.println((3 - i));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.�̵�(������ġ, �ý���.������ġ);

			this.���� = false;
		}
	}

}
