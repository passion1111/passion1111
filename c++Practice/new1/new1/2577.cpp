//#include<cstdio>
//
//
//int main() {
//	int x, y, z;
//	scanf("%d %d %d", &x, &y, &z);
//
//	int result = x * y * z;
//	int arr[10] = { 0, };
//
//	while (result > 0) {
//		arr[result % 10] +=1;
//		result /= 10;
//
//
//
//	}
//
//
//	for (int  i = 0; i < 10; i++)
//	{
//		printf("%d\n", arr[i]);
//	}
//	
//}
#include<cstdio>


int main() {

	int x, y, z;
	scanf("%d %d %d", &x, &y, &z);
	int result = x * y * z;
	
	int arr[10] = { 0, };

	while (result > 0) {
		arr[result % 10]++;
		result /= 10;
	}
	for (int i = 0; i < 10; i++)
	{

	printf("%d\n", arr[i]);
	}




}