#include<cstdio>


int main() {
	int star;
	scanf("%d", &star);


	for (int i = 1; i <= star; i++) {
		for (int j = i; j <= star - 1; j++) {
			printf(" ");
		}
		for (int k = 0; k < 2*i-1; k++) {
			printf("*");
			
		}
		printf("\n");
		



	}


	return 0;
}