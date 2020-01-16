#include<stdio.h>
 
int main() {
	int number = 9;
	int heap[9] = { 5,4,1,6,8,2,3,9,7 };
	//전체 노드를 최대 힙 구조로 만든다
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

	//크기 줄여가며 반복적으로 힙 구성
	for (int i = number - 1; i >= 0; i--) {
		int temp = heap[0];
		heap[0] = heap[i];
		heap[i] = temp;
		int c = 1;
		int root = 0;
		do {
			c = root * 2 + 1;
			//자식 중 더 큰 값 찾기     c가 범위보다 더 커지지않게 
			if (heap[c] < heap[c + 1] && c < i - 1) {
				c++;
			}
			//루트보다 자식이 더 크다면 교환
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