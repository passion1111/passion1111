#include<cstdio>


int main() {
	int n;
	scanf("%d", &n);


	for (int i = 0; i < n; i++) {

		int x, y, z;
		int temp = 0;
		int hosu = 0;
		scanf("%d %d %d", &x, &y, &z);
		if (x == 1) {
			temp = x;
		}
		else {
		temp=z% x == 0 ? x: z % x;

		}
		hosu = z % x == 0 ? z / x:z/x+1;
		if (hosu < 10) {
			printf("%d0%d\n", temp, hosu);
		}
		else {
			printf("%d%d\n", temp, hosu);

		}
	     
	}


}