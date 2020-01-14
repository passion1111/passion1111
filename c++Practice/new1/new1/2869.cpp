#include<cstdio>
#include <math.h>

int main() {
	int	x=0, y=0, z=0;
	int result = 0;
	scanf("%d %d %d", &x,&y,&z);
	int su = x - y;


	result=(z-x)% su == 0 ? (z-x) / su+1 : (z-x) / su + 2;
	printf("%d", result);
	


}