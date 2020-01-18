#include<cstdio>


int main() {
	int x;
	int Arr[1000] = { 0, };
	scanf("%d", &x);

	int count = 0;
	for (int i = 0; i <x; i++)
	{
		scanf("%d", &Arr[i]);

		for (int j = 2; j <= Arr[i]; j++) {
		if (Arr[i]%j==0 ) {
			if (Arr[i] != j) {
				break;
			}
			count++;
			
		}

		}
	}
	printf("%d", count);


}