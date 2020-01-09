#include<cstdio>



int main() {
	////과목 n개 주어진후 
 //   //최댓값 찾아서 
	int n;
	scanf("%d", &n);
	double arr[1001] = { 0, };
	int temp=0;
	for (int i = 0; i < n; i++)
	{
		scanf("%lf", &arr[i]);
		if (arr[i] > temp)temp = arr[i];
	}

	double result=0.0;
	for (int i = 0; i < n; i++)
	{
		result +=arr[i] / temp * 100;




	}
	printf("%f", result / n);

	
}