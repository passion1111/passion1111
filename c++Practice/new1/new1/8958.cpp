#include<cstdio>


int main() {
	int n;
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
	int result=0;
		char str[80];
		int com=0;
		int index = 0;
		scanf("%s", &str);

		

		while (str[index]) {
			if (str[index] == 'O') {
				result += com + 1;
				com += 1;
			}
			else {
				com = 0;
			}


			index++;
		}

		printf("%d\n", result);
		

		

	}

	
}