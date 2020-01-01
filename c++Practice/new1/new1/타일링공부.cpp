#include<stdio.h>

int dp[1001] = { 0, };
int dp2[1001] = { 0, };
int dfs(int n) {
	if (n <= 1) {
		return 1;
	}
	if (dp[n] == 0) {
		int ret=  (dfs(n - 1) + dfs(n - 2) + dfs(n - 2)  ) %10007;
		dp[n] = ret;
		return ret;
	}
	else {
		return dp[n];
	}


}



int main() {
	int n = 0;
	scanf("%d", &n);
	//dfs dp¹æ¹ý1
	dp[1] = 1;
	dp[0] = 1;
	int value = dfs(n);

	printf("%d\n", value%10007);
	dp2[0] = 1;
	dp2[1] = 1;
	for (int i = 2; i <= n; i++)
	{
		dp2[i] = (dp2[i - 1] + dp2[i - 2] + dp2[i - 2]) % 10007;
		
	}
	int value2 = dp2[1000];
	printf("%d", value2);

	return 0;
}