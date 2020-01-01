#include<cstdio>
#include<string>
#include<iostream>
using namespace std;

int main() {
	int a, b;
	int month[12] = { 3,0,3,2,3,2,3,3,2,3,2,3 };
	string dayOfWeek[] = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	int sum = 0;
	int result = 0;
	scanf("%d %d", &a, &b);
	

	for (int i = 0; i < a-1; i++) {
		sum += month[i];
	}
	result = (sum + b) % 7 ;
	
	cout << dayOfWeek[result] << endl;

	





	return 0;
}
