#include<cstdio>
#include<stdlib.h>
int strlen(char* str) {
	int result = 0;
	for (int i = 0; str[i] != NULL; i++)
		result++;
	return result;
}

char* concat(char* s1, char* s2) {
	char *newstr = (char*)malloc(strlen(s1) + strlen(s2)+1);
	printf("%d", _msize(newstr));
	

	int cnt=0, cnt2=0;
	for (int i = 0; s1[i]!= NULL ; i++)
	{
		newstr[cnt] = s1[i];
		cnt++;
	}
	for (int i = 0; s2[i]!=NULL; i++)
	{
		newstr[cnt] = s2[i];
		cnt++;
	}
	printf("%d", _msize(newstr));

	newstr[cnt] = '\0';
	printf("%d", _msize(newstr));

	return newstr;

}

int main() {
	char hw[] = "dasd";
	char hw2[] = "wda";
	char *he=concat(hw, hw2);
	
	printf("%düũ", _msize(he));

	free(he);

}