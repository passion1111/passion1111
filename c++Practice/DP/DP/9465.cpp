#include <stdio.h>
#include <stdlib.h>
#include <algorithm>

using namespace std;
int arr[100000][2];
int dp[100000][3];

char in[1 << 25];
const char* o;

void getIn() {
	o = in;
	in[fread(in, 1, sizeof(in) - 4, stdin)] = '\n';
}

int nextInt() {
	int ret = 0;

	while ((*o < '0' || *o > '9') && *o != '-') ++o;
	while (*o >= '0' && *o <= '9') ret = 10 * ret + *o++ - '0';

	return ret;
}

int main(void)
{
	int c;
	int n;
	getIn();
	c = nextInt();

	while (c--)
	{

		n = nextInt();

		for (int i = 0; i < n; i++)
			arr[i][0] = nextInt();
		for (int i = 0; i < n; i++)
			arr[i][1] = nextInt();

		//	memset(dp, 0, sizeof(dp));

		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = 0;

		for (int i = 1; i < n; i++)
		{
			dp[i][0] = max(dp[i - 1][2], dp[i - 1][1]) + arr[i][0];
			dp[i][1] = max(dp[i - 1][2], dp[i - 1][0]) + arr[i][1];
			dp[i][2] = max(max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
		}



		printf("%d\n", max(dp[n - 1][0], max(dp[n - 1][1], dp[n - 1][2])));

	}
}



//#include<cstdio>
//
//int max(int x, int y) {
//    return x > y ? x : y;
//}
//int main() {
//
//
//    int DP[2][100001] = { 0, };
//    int sticker[2][100001] = { 0, };
//
//
//    int n;
//    scanf("%d", &n);
//
//    while (n--) {
//        int temp;
//        scanf("%d", &temp);
//        for (int i = 0; i < 2; i++) {
//            for (int j = 2; j <= temp + 1; j++) {
//                scanf("%d", &sticker[i][j]);
//            }
//        }
//
//        for (int j= 2; j <= temp + 1; j++) {
//
//            DP[0][j] = max(max(DP[0][j - 1], DP[1][j - 1] + sticker[0][j]), DP[1][j - 2] + sticker[0][j]);
//            DP[1][j] = max(max(DP[1][j - 1], DP[0][j - 1] + sticker[1][j]), DP[0][j - 2] + sticker[1][j]);
//        }
//
//        if (DP[0][temp+1] > DP[1][temp+1]){
//        printf("%d\n",DP[0][temp + 1]);
//            }
//        else {
//            printf("%d\n", DP[1][temp + 1]);
//        }
//    }
//    return 0;
//}


//#include <stdio.h>
//
//int stiker[2][100010];
//int dp[2][100010];
//
//int max(int a, int b)
//{
//    return a > b ? a : b;
//}
//int main(void) {
//
//    int testcase;
//    scanf("%d", &testcase);
//    while (testcase--) {
//        int n;
//
//        scanf("%d", &n);
//
//        for (int i = 0; i < 2; i++)
//            for (int j = 2; j <= n + 1; j++)
//                scanf("%d", &stiker[i][j]);
//
//
//        for (int i = 2; i <= n + 1; i++) {
//                            //[0][0] 제외? 첫번쨰 , 두번째줄(스티커값)중 큰값 ,-> 그 결과와   
//            //     
//            //
//            dp[0][i] = max(max(dp[0][i - 1], dp[1][i - 1] + stiker[0][i])   , dp[1][i - 2] + stiker[0][i]);
//            dp[1][i] = max(max(dp[1][i - 1], dp[0][i - 1] + stiker[1][i])   , dp[0][i - 2] + stiker[1][i]);
//                               
//        }
//
//
//        if (dp[0][n + 1] > dp[1][n + 1])
//            printf("%d\n", dp[0][n + 1]);
//        else
//            printf("%d\n", dp[1][n + 1]);
//    }
//
//    return 0;
//}