#include<cstdio>
#include <math.h>


int main() {
	int a;
	int b;
	int c;
	int result = 0;
	scanf("%d %d %d", &a, &b, &c);


	//A 고정비용
	//B 생산비용
	//C 판매비용 
	// A+ bx<C(cx)
	//x(b-c)>=   A
	//         (C-B)
	//           -1000
	//         -100
	// -100  1000 
	//            b-c
	//        b/c
	// BX이였는데 B만 넘기면되니까 

	if ( c - b <= 0) {
		printf("-1");
	}
	else {
		//     
		result = a / (c - b) + 1;
		printf("%d", result);
	}
	
	


}