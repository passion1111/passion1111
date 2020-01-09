#include<cstdio>

int main() {
	int temp;
	scanf("%d", &temp);
	int last=0,count=0;
	int temp2=temp;


	do {
		count++;
	
	int first = temp2 % 10;
	int second = temp2/ 10;
	int total = first + second;
	temp2 = first * 10 + total%10;

	
	} while (temp != temp2);
		
	

	printf("%d", count);


	return 0;
}