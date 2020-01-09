#include<iostream>
using namespace std;
int main() {
	
	int x;
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	cin >> x;
	for (int i = 1; i <= x; i++) {
		int a, b;
		cin >> a >> b;
		cout << a + b << "\n";


	}


	return 0;
}