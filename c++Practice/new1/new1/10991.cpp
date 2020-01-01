#include<cstdio>


int main() {

	int star;
	scanf("%d", &star);



	//자기기준 높이-1 만큼 띄어쓰기 
	// 별찍는순간부터 홀수개의 별을 찍는데 짝수 칸일떄 공백 
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