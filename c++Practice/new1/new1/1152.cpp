#include<cstdio>


int main() {
	char str[1000001] = { NULL, };
	scanf("%[^\n]", str);
	int tempwordlength = 0;
	int word=0;
	for (int i = 0; str[i]!=NULL; i++)
	{
		 //���� ����� ���� 
		//���� �ܾ�� �ν�X  !=\0 \0�����µ� index���� 0���� ũ�� �ܾ� ++
		
		
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