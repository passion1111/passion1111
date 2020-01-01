#include<cstdio>

int main() {
	int star;

	scanf("%d", &star);
	int totlaline = star * 2 - 1;


	for (int i = 0; i < totlaline/2 + 1; i++) {
		for (int j = 0; j <=i;j++) {
			printf("*");
		}
		for (int k = 2*i+1; k <= totlaline -1 ; k++) {
			printf(" ");
		}
		for (int l = 0; l <=i; l++) {
			printf("*");
		}
		printf("\n");
	
	}


	for (int i = 1; i <= totlaline / 2 ; i++) {
		for (int j = i; j <= totlaline / 2; j++) {
			printf("*");
		}
		for (int k =0; k < 2 * i ; k++) {
			printf(" ");
		}
		for (int l = i; l <= totlaline / 2; l++) {
			printf("*");
		}
		printf("\n");

	}



	return 0;
}