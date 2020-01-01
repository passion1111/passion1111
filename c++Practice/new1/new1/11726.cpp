#include<cstdio>



int main() {
	int DP[1001] = { 0, };
	int n;
	scanf("%d", &n);
	DP[1] = 1;

	for (int i = 2; i <= n; i++) {
		if (i == 2) {
			DP[i] = 2;
			continue;
		}
		DP[i] = (DP[i - 1] + DP[i - 2])%10007;


	}
	printf("%d", DP[n] % 10007);
	
	return 0;
}