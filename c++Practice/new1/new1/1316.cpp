#include<cstdio>


int main() {

	//üĿ���� aaabbccaa       aaa�̾����°ͱ����� ok �׷��� �ڿ� �ٽ� a�� �����Ƿ� X
	//ó�� i�� ����  alpha[i-97]++�Ŀ� 
	// for(int j=i+1;str[j]==str[i];j++)  i++���� �ε������� �Ѱ��� 
	// for���� �������� i=0;i<26;i++ �ϸ鼭 alpha���� 1����ũ�� 2���̻��ߺ��ƴٴ��ǹ��̴� break;
	// �װ� ������������ if(i==25) result++; 
	//�׷��Ƿ� ���ĺ��� ���Ë�  alpha[i]== alpha[i+1] �̸� �Ѱ����� �ܾ�� �����ϰԸ���   
	int n;
	char str[101];
	int result = 0;
	scanf("%d", &n);

	for (int i = 0; i < n; i++)
	{
	int alpha[26] = { 0, };
		scanf("%s", str);

		for (int j = 0; str[j]!=NULL;j++)
		{
			int temp = j;
			alpha[str[j] - 97]++;
			for (int k = temp+1;str[k]==str[temp] ; k++)
			{
				j++;
			}


		}
		for (int j = 0; j < 26; j++) {
			if (alpha[j] > 1) {
				break;
			  }
			else if (j == 25) {
				result++;
			}
		}



	}
	printf("%d", result);

}