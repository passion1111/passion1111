package codingdojang;

import java.util.Scanner;

//입력 : 총건수(m), 한페이지에 보여줄 게시물수(n) (단 n은 1보다 크거나 같다. n >= 1)
//출력 : 총페이지수
public class Personal_codingdojang3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n,m;
		
		do {
			n=sc.nextInt();
			
		}while(n<1);
			m=sc.nextInt();
		 
			if(n%m!=0) System.out.println(m/n+1);
			else System.out.println(m/n);
	}
}