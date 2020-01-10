#include<cstdio>


int main() {
	int x;
	scanf("%d", &x);
	int result=99;
	
	if (x < 100) {
		result = x;
	}


	for (int i = 100; i <=x; i++)
	{
		int hun = i / 100;
		int ten = i % 100 / 10;
		int one = i % 10;
		if ((hun - ten) == (ten - one)) result++;


	}
	printf("%d", result);

	
}