#include<cstdio>


int main() {
	int arr[101]{ 0, };
	
	int n;
	int question;
	scanf("%d %d", &n, &question);



	for (int i = 0; i < n; i++)
	{
		scanf("%d", &arr[i]);
	}

	//Q초떄의 악보를 출력하는것 

	for (int i = 0; i < question; i++)
	{
		int temp=0;
		int temp2=arr[0];
		scanf("%d", &temp);
		 //1초  3초 0~2          temp-1  
		for (int j = 0; j < 100; j++)
		{
			if (temp <= temp2 - 1) {
				printf("%d\n", j + 1);
				break;
			}
			temp2 += arr[j + 1];
			}




	}


		//10초떄 뭐 연주하고있음?  

	return 0;

}