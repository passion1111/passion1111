package array;

import java.util.Scanner;

public class MainEntry3 {
	public static void main(String[] args) {
		int[] a=new int[5];
		Scanner sc=new Scanner(System.in);
		System.out.println("정수데이터");
		int x=sc.nextInt();
		
		
		for(int i=0;i<a.length;i++) {
			 System.out.println((i+1)+"번쨰 데이터는 = ");
			a[i]=sc.nextInt();
		}
//		 a[0]=sc.nextInt();
//		 a[1]=sc.nextInt();
//		 a[2]=sc.nextInt();
//		 a[3]=sc.nextInt();
//		 a[4]=sc.nextInt();
		 System.out.println("x="+x);
		 System.out.println("\n=============");
		 
		 for(int i=0;i<a.length;i++) {
			
			 System.out.println("a["+i+"]= "+a[i]);
		 }
		 
 System.out.println("\n=============");
		 
		 for(int i=0;i<a.length;i++) {
			 System.out.println((i+1)+"번쨰 데이터는 = "+a[i]);
		 }
		 
		 
		
	
	
	}
}
