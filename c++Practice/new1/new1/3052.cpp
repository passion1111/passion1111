#include<cstdio>

int main() {

	int arr[10] = { 0, };
	for (int i = 0; i < 10; i++)
	{
		scanf("%d", &arr[i]);
	}
	int temp[42] = { 0, };
	int index = 0;

	for (int i = 0; i < 10; i++)
	{
		int nomaltemp = arr[i]%42;


		temp[nomaltemp] +=1;


		if (temp[nomaltemp] ==1) {
			index++;
		}
	}

	printf("%d", index);


}