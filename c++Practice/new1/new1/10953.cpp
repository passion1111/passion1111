//#include<iostream>
//using namespace std;
//int main() {
//	int a, b, t;
//	char c;
//	cin >> t;
//	while (t--) {
//		cin >> a >> c >> b;
//		cout << a + b << endl;
//
//	}
//
//
//
//	return 0;
//
//}
//
#include <iostream>
#include <string>
using namespace std;

int main()
{
	int n;
	int a, b;
	string s;

	cin >> n;

	for (int i = 0; i < n; ++i) {
		cin >> s;

		a = s[0] -'0' ;
		b = s[2] -'0' ;

		cout << a  << endl;
	}

	return 0;
}