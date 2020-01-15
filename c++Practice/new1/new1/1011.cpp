#include<cstdio>
#include<math.h>



int main() {
	int n;
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
		int x, y;
		long long temp = 1;
		scanf("%d %d", &x, &y);
		while (temp * temp <= (y - x)) {

			temp++;
		}
		temp--;
		//최대거리는 n^2수대로  워프회수가 달라지고 나머지거리에서 이 최대거리를넘길수가 없어서 나눠서 떨어지면 그만큼 가고 딱 나눠서 떨어지지않으면 
		//거리가 남았다는뜻이니 그만큼 +1더 움직이면  될것이다. 
		long long  remain = (y - x) -(temp * temp);
		remain = (long long)ceil((double)remain / (double)temp);
		printf("%lld\n", 2 * temp - 1 + remain);
	}
}