package pacman_confirm1;

import java.util.ArrayList;

enum �ʱ������ {
	��, ��, ������, ����, ����, ��ź;
	
} // �� = '��' �� = ' ' ������ = '��' ���� = '*' ���� = '��'


public class �� {
	public int ��ǥx;
	public int ��ǥy;
	�ʱ������ ����;
	�ʱ������ ��������;
	// ArrayList<����> ���ָ���Ʈ = new ArrayList<����>();
	// ArrayList<ĳ����> ĳ���͸���Ʈ = new ArrayList<ĳ����>();
	// ArrayList<����> ��������Ʈ = new ArrayList<����>();
	�� �� = null;
	ĳ���� ĳ���� = null;
	�� ��;
	�� �Ʒ�;
	�� ������;
	�� ����;
	��() {
		���� = �ʱ������.����;
	}

	public ��(int x, int y) {
		��ǥx = x;
		��ǥy = y;
		���� = �ʱ������.����;
	}

	public void �ʺ���(String ����) {
		if (����.equals("��")) {
			this.���� = �ʱ������.��;
		} else if (����.equals("��")) {
			this.���� = �ʱ������.��;
		} else if (����.equals("������")) {
			this.���� = �ʱ������.������;
		} else if (����.equals("����")) {
			this.���� = �ʱ������.����;
		} else if (����.equals("����")) {
			this.���� = �ʱ������.����;
		} else if (����.equals("��ź")) {
			this.���� = �ʱ������.��ź;
		} else {
			System.out.println("����! ���´� ��, ��, ������, ����, ����, ��ź���� �����ϴ�.");
		}
	}

	public void ���() {
		boolean flag = true;
		if (�� != null && ĳ���� != null) {
			��.����(ĳ����);
		}

		if (ĳ���� != null) {
			// System.out.println("ĳ���� ��� ����");
			if(���� == �ʱ������.����) {

				System.out.print('#');
				ĳ����.����(); return;
			}
			ĳ����.���();
			flag = false;
		}
		
		if (�� != null) {
			if(���� == �ʱ������.����) {
				System.out.print('#');
				��.�̵�(��.������ġ, �ý���.������ġ_��);
				return;
			}
			��.���();
			flag = false;
		}
		
		if (flag) {
			if (���� == �ʱ������.��)
				System.out.print('��');
			else if (���� == �ʱ������.��)
				System.out.print(' ');
			else if (���� == �ʱ������.������)
				System.out.print('��');
			else if (���� == �ʱ������.����)
				System.out.print('\'');
			else if (���� == �ʱ������.����)
				System.out.print('#');
			else if (���� == �ʱ������.��ź)
				System.out.print('@');
		}
		return;
	}
	

}
