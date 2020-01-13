#include<cstdio>


int main() {

	//체커게임 aaabbccaa       aaa이어지는것까지는 ok 그런데 뒤에 다시 a가 나오므로 X
	//처음 i의 값을  alpha[i-97]++후에 
	// for(int j=i+1;str[j]==str[i];j++)  i++으로 인덱스값을 넘겨줌 
	// for문이 끝났을떄 i=0;i<26;i++ 하면서 alpha값이 1보다크면 2번이상중복됐다는의미이니 break;
	// 그게 문제가없으면 if(i==25) result++; 
	//그러므로 알파벳이 나올뗴  alpha[i]== alpha[i+1] 이면 한가지의 단어로 생각하게만듦   
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