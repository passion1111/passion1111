package backjoon;

import java.util.Scanner;


public class Back5623 {
	public static void solve() {
		Scanner sc=new Scanner(System.in);
	    int n = sc.nextInt();
	    int[][] array = new int[n + 1][n + 1]; // 4입력될경우 5 5 
	    int[] a = new int[n + 1];             // a=[5]
	    StringBuilder sb = new StringBuilder();
	 
	    for (int i = 1; i <= n; i++) {
	        for (int j = 1; j <= n; j++) {
	            array[i][j] = sc.nextInt();
	        }
	        System.out.println(array[0][0]);
	    }
	 
	    if (n == 2) {
	        System.out.println("1 1");
	    } else {
	        a[1] = ((array[1][2] + array[2][3] + array[1][3]) / 2) - array[2][3];
	        sb.append(a[1] + " ");
	        for (int i = 2; i <= n; i ++) {
	            a[i] = array[i - 1][i] - a[i - 1];
	            sb.append(a[i] + " ");
	        }
	        System.out.println(sb.toString());
	    }
	}
	public static void main(String[] args) {
		//solve();
		// 반복횟수 구하기 
		// l  -  a    = 3200  
		//만약 100씩 더할경우 총 32번을 더하지만  전체 수열의 수는 32+1 왜냐하면 첫쨰항일떄는 값의 증감이 없기떄문에  0,1 일경우 값의 증감은 1번있지만 전체항은 2개 
		//그래서 (a+l)n/2 
		//    (1000+4200)*33  
		int i=((1000+4200)*33)/2;
		System.out.println(i);
         int total=0; 		
		for (int j = 1000; j <= 4200; j+=100) {
			total+=j;
		}
		System.out.println(total);
		int n=(int)Math.pow(2, 3);
//		   a(r^n-1)
//		   r-1
		long total2=  2*((long)Math.pow(2, 62)-1)/(2-1)    ;
		
		System.out.println(n);
		System.out.println("등비수열의합" +total2);
		System.out.println(Math.pow(2, 9));
	}
}
