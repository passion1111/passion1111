package homework;

import java.util.Scanner;

public class ChangeEx3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tmp;
		
		System.out.print("���� �Է��Ͻÿ� :");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int max, mid, min;
		
		if(a==b || a == c || b ==c){
			System.out.println("�������� �Է��Ҽ� �����ϴ�");
			System.exit(0);
		}
		
		max = ((a>b) && (a>c)? a : ((b>a) && (b>c))? b : ((c>a) && (c>b))? c : a);   	
		min = ((a<b) && (a<c)? a : ((b<a) && (b<c))? b : ((c<a) && (c<b))? c : a); 
		mid = mid = ((max > a) && (min < a))? a : ((max > b) && (min < b))? b : 
			((max > c) && (min < c))? c : a;
		
		System.out.println(max + "," + mid + "," +min);
		
		
	}
}
