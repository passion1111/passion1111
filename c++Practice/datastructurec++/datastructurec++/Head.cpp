#include<stdio.h>
 
int main() {
	int number = 9;
	int heap[9] = { 5,4,1,6,8,2,3,9,7 };
	//��ü ��带 �ִ� �� ������ �����
	for (int i = 0; i < number; i++)
	{

		int c =i;
		do {
			int root = (c - 1) / 2; 
			if (heap[root] < heap[c]) {
				int temp = heap[root];
				heap[root] = heap[c];
				heap[c] = temp;
			}
		c = root;
		} while (c != 0);
	}

	//ũ�� �ٿ����� �ݺ������� �� ����
	for (int i = number - 1; i >= 0; i--) {
		int temp = heap[0];
		heap[0] = heap[i];
		heap[i] = temp;
		int c = 1;
		int root = 0;
		do {
			c = root * 2 + 1;
			//�ڽ� �� �� ū �� ã��     c�� �������� �� Ŀ�����ʰ� 
			if (heap[c] < heap[c + 1] && c < i - 1) {
				c++;
			}
			//��Ʈ���� �ڽ��� �� ũ�ٸ� ��ȯ
			if (heap[root] < heap[c] && c < i ) {
				int temp = heap[root];
				heap[root] = heap[c];
				heap[c] = temp;
			}
			root = c;
		} while (c < i);
	}

	for (int i = 0; i < number - 1; i++) {
		printf("%d", heap[i]);
	}


}