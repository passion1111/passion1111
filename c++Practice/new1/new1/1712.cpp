#include<cstdio>
#include <math.h>


int main() {
	int a;
	int b;
	int c;
	int result = 0;
	scanf("%d %d %d", &a, &b, &c);


	//A �������
	//B ������
	//C �Ǹź�� 
	// A+ bx<C(cx)
	//x(b-c)>=   A
	//         (C-B)
	//           -1000
	//         -100
	// -100  1000 
	//            b-c
	//        b/c
	// BX�̿��µ� B�� �ѱ��Ǵϱ� 

	if ( c - b <= 0) {
		printf("-1");
	}
	else {
		//     
		result = a / (c - b) + 1;
		printf("%d", result);
	}
	
	


}