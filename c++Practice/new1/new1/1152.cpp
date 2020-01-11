#include<cstdio>


int main() {
	char str[1000001] = { NULL, };
	scanf("%[^\n]", str);
	int tempwordlength = 0;
	int word=0;
	for (int i = 0; str[i]!=NULL; i++)
	{
		 //띄어쓰기 어떤문자 띄어쓰기 
		//띄어쓰면 단어로 인식X  !=\0 \0만났는데 index값이 0보다 크면 단어 ++
		
		
		if (str[i] == 32 && tempwordlength != 0) {
			word++;
			tempwordlength = 0;
		}
		else if(str[i]!=32) {
			tempwordlength++;
		}

	}
	if (tempwordlength != 0)word++;
	printf("%d", word);
	

}