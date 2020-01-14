#include<cstdio>
#include<math.h>

int max(int x, int y) {


	return x > y ? x : y;
}

int main() {



	// 동적할당  1 -1 0          1 0 2      2 3 4    3 4 5   4 5 6   5 6 7   6 7 8  7 8 9
                                          //-1 DP DP+1
	//도착직전 이라면 max<=2 1 2 3
	int n;
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
		int x, y;
		long long temp = 1;
		scanf("%d %d", &x, &y);
		while (i * i < y - x) {

			i++;
		}
		i--;

		long long  remain = (y - x) -(i*i);
		remain = ceil(remain / i );

		printf("%lld", 2 * i - 1 + remain);



	}



}