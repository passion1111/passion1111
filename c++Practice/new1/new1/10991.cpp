#include<cstdio>


int main() {

	int star;
	scanf("%d", &star);



	//�ڱ���� ����-1 ��ŭ ���� 
	// ����¼������� Ȧ������ ���� ��µ� ¦�� ĭ�ϋ� ���� 
	for (int i = 1; i <= star; i++) {

		for (int j = i; j <= star - 1; j++) {
			printf(" ");
		}
		for (int k = 2 * i - 1; k >= 0; k--) {
			if (k % 2 == 0) {
				printf(" ");
			}
			else {
				printf("*");
			}

		}
		printf("\n");




	}



	return 0;
}