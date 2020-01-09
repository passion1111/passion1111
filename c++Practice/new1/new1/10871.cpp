#include<iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int x, y;
	cin >> x >> y;
	for (int i = 0; i < x; i++)
	{
		int a;
		cin >> a;
		if (a < y) cout << a << " ";
	}
	

	return 0;
}