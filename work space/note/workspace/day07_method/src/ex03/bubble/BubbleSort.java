package ex03.bubble;

public class BubbleSort {
	public static void main(String[] args) {
		int[] a = { 7, 1, 3, 5, 2 };
		int temp;

		System.out.println("sort �� : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		} // for end

		// sort
		for (int i = 0; i < a.length; i++) { // 4����
			for (int j = 0; j < a.length - i - 1; j++) { // j�� 4-i-1���� // j�� ����

				if (a[j] < a[j + 1]) { // �������� //if (a[j] > a[j + 1]) { // ��������
					temp = a[j]; // temp������ �̿��� ������ ��change
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}

			} // j end
		} // i end
		System.out.println("\nsort �� : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		} // for end
	}
}
