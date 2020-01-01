#include<cstdio>

int main() {
	int star;

	scanf("%d", &star);

	for (int i = 0; i < star; i++) {

		for (int j = i; j < star - 1; j++) {
			printf(" ");

		}
		for (int k = 0; k <= i; k++) {
			printf("*");
		}

		printf("\n");
	}

	for (int i = 0; i < star - 1; i++) {

		for (int j = 0; j <= i; j++) {
			printf(" ");

		}
		for (int k = 0; k+i < star-1; k++) {
			printf("*");
		}

		printf("\n");
	}



	return 0;
}