#include<iostream>
using namespace std;

void swap(int* a, int* b) {
	int temp = *a;
	*a = *b;
	*b = temp;
}

int partition(int arr[], int l, int h) {
	int x = arr[h];
	int i = (l - 1);
	for (int j = l; j <= h-1; j++) {
		if (arr[j] <= x) {
			i++;
			swap(&arr[i], &arr[j]);
		}
	}
	swap(&arr[i + 1], &arr[h]);
	return (i + 1);
}

void quicksort(int A[], int l, int h) {
	if (l < h) {
		int p = partition(A, l, h);
		quicksort(A, l, p - 1);
		quicksort(A, p + 1, h);
	}
}

	int main(){

		int n = 5;
		int arr[5] = { 4,2,6,9,2 };
		quicksort(arr, 0, n - 1);
		for (int i = 0; i < n; i++) {
			cout << arr[i] << ' ';
			
		}
		return 0;
	
}