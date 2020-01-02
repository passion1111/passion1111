//// CPP program to check if a string is 
//// substring of other. 
//#include <cstdio> 
//#include <string>
//#include <iostream>
//using namespace std;
//
//// Returns true if s1 is substring of s2 
//int isSubstring(string s1, string s2)
//{
//	int M = s1.length();
//	int N = s2.length();
//
//	/* A loop to slide pat[] one by one */
//	for (int i = 0; i <= N - M; i++) {
//		int j;
//
//		/* For current index i, check for pattern match */
//		for (j = 0; j < M; j++)
//			if (s2[i + j] != s1[j])
//				break;
//
//		if (j == M)
//			return i;
//	}
//
//	return -1;
//}
//
///* Driver program to test above function */
//int main()
//{
//	string s1 = "for";
//	string s2 = "geeksforgeeks";
//	int res = isSubstring(s1, s2);
//	if (res == -1)
//		cout << "Not present";
//	else
//		cout << "Present at index " << res;
//	return 0;
//}


#include <cstdio> 
#include <string>
#include <iostream>
using namespace std;
int isSubstring(string s1, string s2) {
	int M = s1.length();
	int N = s2.length();
	
	for (int i = 0; i <= N - M; i++)
	{
		int j;
		for (j = 0; j < M; j++)
		
			if (s2[i + j] != s1[j])
				break;
		if (j == M)
			return i;
		
	}
	return -1;
}
	int main() {

		string s1 = "for";
	
		string s2 = "geeksforgeeeks";
		int res =  isSubstring (s1, s2) ;
		if (res == -1)
			cout << "찾지못함";
		else
			cout << "인덱스위치는 " << res;



		return 0;
	}
