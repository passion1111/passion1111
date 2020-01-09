#include<cstdio>
#include <climits>

int main() {

	int temp = INT_MIN;
	int index = 0;
	

	for (int i = 0; i < 9; i++)
	{
		int input;
		scanf("%d", &input);
		if (input > temp) {
			temp = input;
			index = i+1;
		}
	}
	printf("%d\n", temp);
	printf("%d", index);
	

	return 0;
}