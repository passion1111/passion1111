#include<iostream>
using namespace std;

int main() {
	cin.tie(0);

	int n;
	int temp;
	int min= +1000000;
	int max = -1000000;
	cin >> n;
	

	for (int i = 0; i < n; i++) {
		cin >> temp;
		max = temp > max ? temp : max;
		min = temp < min ? temp : min;



	}
	cout << min << " " << max << endl;

	return 0;
}