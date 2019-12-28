#include<iostream>
#include<cstdio>
using namespace std;

int main() {
	int a, b, t,n=1;

	cin >> t;
	while (t--) {

		cin >> a >> b;
		cout << "Case #" << n << ": " << a + b << endl;
		n++;

	}
	
	scanf_s("%d %d", &a, &b);
	
	printf("%d", a + b);



	return 0;
}