#include<cstdio>

int DP[41] = { 1,1, };
int fibonacci(int n) {
	if (n <= 1) {
		return DP[n];
	}	
	else {
		if (DP[n] > 0) {
			return DP[n];
		}
	}
	return DP[n]=fibonacci(n - 1) + fibonacci(n - 2);


}


int main() {

	int testcase;
	scanf("%d", &testcase);
	for (int i = 0; i < testcase; i++)
	{
		int temp;
		scanf("%d", &temp);

		if (temp == 0) {
			printf("1 0\n");
		}
		else if (temp == 1) {
			printf("0 1\n");
		}
		else {
			fibonacci(temp);
			printf("%d %d\n", DP[temp - 2], DP[temp - 1]);
		}
			

	}

}