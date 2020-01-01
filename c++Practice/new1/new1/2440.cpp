#include<cstdio>

int main() {
	int star;


	scanf("%d", &star);

	for (int i = 0; i < star; i++) {

		for (int j = star; j > i; j--) {
			printf("*");
		}
		for (int k = 0; k < i; k++) {
			printf(" ");
		}
		printf("\n");


	}


	return 0;
}