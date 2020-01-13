#include<cstdio>

int main() {

	int n;
	int result = 0;
	scanf("%d", &n);

	while (1)
	{
		if (n % 5 == 0) {
			result += n / 5;
			printf("%d", result);
			break;


		}
		n -=	3;
		result++;
		if (n < 0) {

			printf("-1");
			break;
		}



	}



}