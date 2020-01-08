#include<cstdio>


int main() {
	int x, y;
	scanf("%d %d", &x, &y);


	if (y < 45) {
		if (x == 0) {
			x = 23;

		}
		else {

		x -= 1;
		}
		y= 60-(45-y);


	}
	else {
		y -= 45;
	}
	printf("%d %d", x, y);
	 


	return 0;
}