#include<cstdio>


int main() {

	int num1 = 0;
	int num2 = 0;
	char s1[21] = { NULL };
	scanf("%d", &num1);


	for (int i = 0; i < num1; i++) {
		scanf("%d %s", &num2, s1);
		for (int k = 0; s1[k] != NULL; k++) {
			for(int j=0;j<num2<j++){
		
				printf("%c", s1[k]);
			}
		}
		printf("\n");
	}
	return 0;
}