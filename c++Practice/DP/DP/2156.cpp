#include <stdio.h>
 
int max(int a, int b){
    return a > b ? a : b;
}
int main() {

    int n;
    int podo[10010] = {};
    int DP[10010] = {};
    scanf("%d", &n);

    for (int i = 1; i <= n; i++)
        scanf("%d", &podo[i]);


    for (int i = 1; i < 3 && i <= n; i++) {
        if (i == 1)
            DP[i] = podo[i];
        else
            DP[i] = podo[i] + podo[i - 1];
    }

    for (int i = 3; i <= n; i++) {
  
       int result = 0;
      result = max(podo[i] + DP[i - 2]   , podo[i] + podo[i - 1] + DP[i - 3]);
      
      result = max(result , DP[i - 1]);
      DP[i] = result;
    }
   
    printf("%d\n", DP[n]);


    return 0;
}