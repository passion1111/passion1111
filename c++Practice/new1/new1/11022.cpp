#include<cstdio>


int main() {
	int a, b,n=1;
	int t ;

	
	scanf("%d", &t);

	while (t--) {

	scanf("%d %d", &a, &b);
	printf("Case #%d: %d + %d = %d\n", n,a,b,a+b);
	n++;
	}

	return 0;
}