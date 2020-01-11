#include<iostream>
#include<string>
#include <algorithm>
using namespace std;
int main() {
	string a,b;
	cin >> a >> b;
	std::reverse(a.begin(), a.end());
	std::reverse(b.begin(), b.end());
	
	
	int result;
	result=stoi(a) > stoi(b) ? stoi(a) : stoi(b);
	cout << result ;

}