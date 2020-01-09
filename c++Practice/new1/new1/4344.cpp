#include<cstdio>


int main() {
	int n;
	scanf("%d", &n);

	for (int i = 0; i < n; i++)
	{
		int n2;
		scanf("%d", &n2);
		double arr[1000] = { 0, };
		double result = 0;
		for (int j = 0; j < n2; j++) {
			scanf("%lf", &arr[j]);
			result += arr[j];
		}
		result /= n2;
		double temp=0.0;
		for (int j = 0; j < n2; j++) {
			if (arr[j] > result) {
				temp++;
			}


		}


		double result2=temp/n2 *100;

		printf("%.3lf%%\n", result2);



	}



}