#include<cstdio>


int main() {
	int x;
	scanf("%d", &x);
	//시험 점수를 입력받아 90 ~100점은 A, 80 ~89점은 B, 70 ~79점은 C, 60 ~69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.
	if ( 90 <= x && x<= 100) {
		printf("A");
	}
	else if(80 <=x && x< 90){
		printf("B");
	}
	else if (70 <= x &&x< 80) {
		printf("C");
	}
	else if (60 <= x &&x< 70) {
		printf("D");
	}
	else {
		printf("F");
	}

}