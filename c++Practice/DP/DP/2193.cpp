#include<cstdio>

int main() {
	int n;
	scanf("%d", &n);

	long long DP[91][2] = { 0, };
	DP[1][0] = 0;
	DP[1][1] = 1;
	for (int i = 2; i <= n; i++) {

		 DP[i][0] = DP[i - 1][0] + DP[i - 1][1];
		 DP[i][1] = DP[i - 1][0];
	}
	
	printf("%lld", DP[n][0] + DP[n][1]);
 

	return 0;
}