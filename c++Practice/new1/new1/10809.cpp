#include<cstdio>

int main() {

      char str[100];

	int cnt[26];

	scanf("%s", str);


	for (int i = 0; i < 26; i++)  //cnt 배열 -1로 초기화
		cnt[i] = -1;

	for (int i = 'a'; i <= 'z'; i++) {
		for (int j = 0; j < 100; j++)
		{

			if (str[j] == i) {
				cnt[i - 97] = j;
				break;

			}
		}
	}


	for (int i = 0; i < 26; i++) {
		printf("%d ", cnt[i]);
	}
	


	return 0;

	//char str[100];
	//int  arr[26] = { 0, };
	//for (int i = 0; i < 26; i++)
	//{
	//	arr[i] = -1;
	//}
	//scanf("%s", str);
	//for (int i = 'a'; i <= 'z'; i++) {
	//	for (int j = 0; j < 100; j++) {            
	//		if (str[j] == i) {
	//			arr[i - 97] = j;
	//			break;
	//		}
	//	}
	//}
	//	for (int i = 0; i <26; i++) {
	//		printf("%d ",arr[i]);
	//	}
	//	return 0;
}