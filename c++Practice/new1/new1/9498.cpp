#include<cstdio>


int main() {
	int x;
	scanf("%d", &x);
	//���� ������ �Է¹޾� 90 ~100���� A, 80 ~89���� B, 70 ~79���� C, 60 ~69���� D, ������ ������ F�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	if ( 90 <= x && x<= 100) {
		printf("A");
	}
	else if(80 <=x && x< 90){
		printf("B");
	}
	else if (70 <= x &&x< 80) {
		printf("C");
	}
	else if (60 <= x &&x< 70) {
		printf("D");
	}
	else {
		printf("F");
	}

}