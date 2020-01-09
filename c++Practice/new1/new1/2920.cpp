#include<cstdio>

int main() {
	int arr[8];


	for (int i = 0; i < 8; i++)
	{
		scanf("%d", &arr[i]);
	}

	int result = 0;
	// Å«>ÀÛ 
	int  temp = 0;
	for (int i = 1; i < 8; i++)
	{
	 
		if (arr[i] - arr[i - 1] == 1) {
			result = 1;
		}
		else if(arr[i]-arr[i-1] ==-1) {
			result = -1;
		}
		else {
			result = 0;
			break;
		}
		
	

	}
	if (result == 1) {
		printf("ascending");
	}
	else if(result==-1) {
		printf("descending");
	}
	else {
		printf("mixed");

	}


}