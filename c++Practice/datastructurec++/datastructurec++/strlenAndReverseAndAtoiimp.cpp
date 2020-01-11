#include<cstdio>

int strlen(char* str) {
	int length=0;
	

	for (int i = 0; str[i]!=NULL; i++)
	{
		length++;
	}

	return length;
}

char* reverse(char* str) {
	size_t size = strlen(str);
	char temp;

	for (size_t i = 0; i < size /2; i++)
	{
		temp = str[i];
		str[i] = str[size - i - 1];
		str[size - i - 1] = temp;
	}






	return str;
}

int atoi(char* str) {
	int result = 0;
	if (!str) return 0;
	
	while (*str) {
	
		if (*str >= '0' && *str <= '9') {
			result = result * 10 + *str - '0';


		}
		*str++;


	}

	return result;

	
}


char* itoa(int n,char* temp) {
	
	int len = 0;
	while (n) {

		temp[len++] = n % 10 + '0';


		n /= 10;
	}
	temp[len] = '\0';
	reverse(temp);

	return temp;
}



	int main() {
		char hhh[] = "1541";
		char check[10];
		int h2 = 543333333;
		printf("%s",itoa(h2, check));


		return 0;
 }