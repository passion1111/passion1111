#include<cstdio>


int main() {
	int x, y, z;
	do {

	scanf("%d %d %d", &x, &y, &z);
	}while(1<=x&&1<=y&&z<=1 &&x<=100 &&y<=100 && z<=100);


		if ( (x < y ||z<y  ) && ( y < z  ||y<x) ) {
			printf("%d", y);
		}
		else if ((y < x || z < x) && (x < z || x < y)) {
			printf("%d", x);
		}
		else if ((y < z || x< z) && (z < x || z < y)) {
			printf("%d", z);
		}
		else {
			x > y ?   (y > z ? printf("%d", y) : printf("%d", z)) :  (x > z ? printf("%d", x) : printf("%d", z) );
				
		}


			return 0;
}