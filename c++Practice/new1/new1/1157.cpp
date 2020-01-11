#include<cstdio>
#include <ctype.h>


int main() {
	
	char str[1000001] = { NULL };
	int alpha[26] = { 0, };
	scanf("%s", str);
	
	
	for (int i = 0; str[i]!=NULL ; i++)
	{
		alpha[tolower(str[i]) -97]++;


	}

	int max = -1;  //최대 alpha[i]의 값
	int index = -1; //index위치 
	bool flag=false;
	for (int i = 0; i < 26; i++)
	{     


		//대문자 2개이상 겹치는가?  

		if (max < alpha[i]  &&alpha[i]!=0) {
			max = alpha[i];
			index = i;
			flag = false;
		}
		else if (max == alpha[i] &&max!=0) {
			flag = true;
			
		}
	}

	if (flag || max==-1) {
		printf("?");
	}
	else {
		printf("%c", index+65);
	}



	return 0;
}