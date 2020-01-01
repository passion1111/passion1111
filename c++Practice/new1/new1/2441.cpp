#include<cstdio>


int main() {

	int star;

	scanf("%d", &star);

	for (int i = 0; i < star; i++) {

		for (int j = 0; j < i; j++) {
			printf(" ");
		}

		for (int k = star; k > i; k--) {
			printf("*");
		}
		printf("\n");

	}


	return 0;
}