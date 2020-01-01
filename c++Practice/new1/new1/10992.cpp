#include<cstdio>


int main() {

	int star;

	scanf("%d", &star);


	//띄어쓰는부분 별찍는부분 띄어쓰는부분 별찍는부분  한칸 넘기는부분 


	for (int i = 1; i <= star; i++)
	{
		for (int j = i; j < star ; j++) {
			printf(" ");
		}
	

		if (i == star) {
			for (int i = 1; i <= star*2-1; i++) {
				printf("*");
			}
		}
		else {
			for (int k = 2 * i - 1; 0 < k; k--) {

				if (k  == (2*i-1) || k==1) {
				printf("*");
				}
				else {

					printf(" ");
				}

			}


		}



		printf("\n");
	}



	return 0;
}