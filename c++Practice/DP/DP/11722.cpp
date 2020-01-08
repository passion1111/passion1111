#include <stdio.h>

int main(void) {
    int N;
    int Dp[1010] = {};
    int A[1010] = {};
    int max = 0;
    scanf("%d", &N);

    for (int i = 1; i <= N; i++)
        scanf("%d", &A[i]);

    for (int i = 1; i <= N; i++)
    {
        int minDp = 0;
        for (int j = 0; j < i; j++) {
   
 //    A[3]=3,1,2;
//    minDP는 매번0으로 초기화 
     //i=0일떄      j=0   min값 변화X           DP[i]=0+1;
    //i=1일떄        1    3      minDP  0    DP[j] =1     해당 
            //     minDP=1 그후 DP[1]=2;
    //             minDP=2
    //           2      3        
            if (A[i] < A[j]) {     






                if (minDp < Dp[j])
                    minDp = Dp[j];
            }
        }
        Dp[i] = minDp + 1;
        if (max < Dp[i])
            max = Dp[i];
    }

    printf("%d\n", max);

}
