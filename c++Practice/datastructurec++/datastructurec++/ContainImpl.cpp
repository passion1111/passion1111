#include<cstdio>



int strlen(char* str) {
	int result = 0;
	for (int i = 0; str[i]!=NULL; i++)
	{
		result++;
	}



	return result;
}
int contain(char* str, char* comparestr) {
	int result = 0;
	int lengthbig = strlen(str);
	int lengthsmall = strlen(comparestr);
	for (int i = 0; i <= lengthbig - lengthsmall; i++) {

		int temp = 0;
		for (int j = 0; j < lengthsmall; j++) {

			if (str[i + temp] != comparestr[j]) {
				break;
			}
			else {
				temp++;
				if (temp == lengthsmall) {
					return 1;
				}
				}
		}
	}
	return -1;
}


int main() {

	char a[] = "gkskgksk";
	char b[] = "gksk";
	printf("%d", strlen(a));
	printf("%d", strlen(b));
	printf("%d", contain(a, b));


}