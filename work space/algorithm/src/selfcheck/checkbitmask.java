package selfcheck;

import java.util.Scanner;

public class checkbitmask {


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
 
        int[] arr = new int[N];
        for (int i = 0; i < 1 << N; i++) {
            int[] abc = new int[N];
            int bit = i;
            for (int j = 0; bit != 0; j++, bit >>= 1) {
            	System.out.println("j번쨰" +j);
                if ((1 & bit) == 0) {
                    continue;
                }
                abc[j] = 1;
 
            }
            for (int k = N - 1; k >= 0; k--) {
                System.out.print(abc[k] + " ");
            }
            System.out.println();
        }
    }
}
