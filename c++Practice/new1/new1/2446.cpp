#include<cstdio>


int main() {

	int star;
	scanf("%d", &star);


	for (int i = 0; i < star; i++) {
		for (int j = 0; j < i; j++) {
			printf(" ");
		}
		for (int k = 2*star-1; k > 2*i; k--) {
			printf("*");
		}
		
		printf("\n");

	}



	for (int i = 1; i <= star-1; i++) {
		for (int j = i; j <= star-2; j++) {
			printf(" ");
		}
		
			for (int k = 1; k <= 2*i+1; k++) {
			printf("*");
		}
		
		printf("\n");
	}



	return 0;
}