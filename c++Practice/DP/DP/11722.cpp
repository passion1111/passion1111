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
//    minDP�� �Ź�0���� �ʱ�ȭ 
     //i=0�ϋ�      j=0   min�� ��ȭX           DP[i]=0+1;
    //i=1�ϋ�        1    3      minDP  0    DP[j] =1     �ش� 
            //     minDP=1 ���� DP[1]=2;
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
