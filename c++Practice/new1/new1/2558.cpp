#include<iostream>
using namespace std;

int main() {
	int a =0, b =0;

	while (a >= 10 || a<=0 || b <= 0 || b >= 10) {
		cin >> a;
		cin >> b;

	}
	cout << a + b << endl;

	return 0;
}