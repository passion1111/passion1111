#include<iostream>
using namespace std;
int binarysearch(int arr[], int l, int r, int x) {

	if (r >= 1) {
		int mid = 1 + (r - 1) / 2;

		if (arr[mid] == x) {
			return mid;
		}
		if (arr[mid] > x)
			return binarysearch(arr, 1, mid - 1, x);



		return binarysearch(arr, mid + 1, r, x);
	}
	return -1;



}


int main() {

	int arr[] = { 2,3,4,5,6,7 };
	int x = 3;
	int n = sizeof(arr) / sizeof(arr[0]);
	cout << sizeof(arr[0]);
	int result = (binarysearch(arr, 0, n - 1, x));
	(result == -1) ? cout << "요소가 없습니다"
		: cout << "인덱스는" << result;


}