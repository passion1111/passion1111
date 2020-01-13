#include<cstdio>


int main() {
	int n;
	scanf("%d", &n);
	long long temp = 0;
	
	long long count = 1;
	int result = 1;



	while (1)
	{


		        
		if (count >= n) {
			printf("%d", result);
			break;
		

		}

		count+=  6*++temp;
		result++;

	}







}