#include <iostream>
using namespace std;

int main() {
	int a = 0, b = 0;
	int* f;
	void (*(*f[])())();
	int a= (*(*f(int)))(void);
	cin >> a >> b;
	cout << a + b << endl;


	return 0;
}