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

	int max = -1;  //�ִ� alpha[i]�� ��
	int index = -1; //index��ġ 
	bool flag=false;
	for (int i = 0; i < 26; i++)
	{     


		//�빮�� 2���̻� ��ġ�°�?  

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