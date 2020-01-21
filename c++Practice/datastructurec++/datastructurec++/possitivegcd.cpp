#include <iostream> 
using namespace std;

// Function to return the count of  
// the required integers 
int __gcd(int a, int b) {
    if (b == 0) return a;
    a %= b;
   return __gcd(b, a);


}

int getCount(int a[], int n)
{

    // To store the gcd of the array elements 
    int gcd = 0;
    for (int i = 0; i < n; i++)
        gcd = __gcd(gcd, a[i]);

    // To store the count of factors 
    // of the found gcd 
    int cnt = 0;

    for (int i = 1; i * i <= gcd; i++) {
        if (gcd % i == 0) {

            // If g is a perfect square 
            if (i * i == gcd)
                cnt++;

            // Factors appear in pairs 
            else
                cnt += 2;
        }
    }

    return cnt;
}

// Driver code 
int main()
{
    int a[] = { 4, 16, 1024, 48 };
    int n = sizeof(a) / sizeof(a[0]);

    cout << getCount(a, n);

    return 0;
}