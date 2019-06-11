package personal2;

import java.util.Scanner;

public class Switch {
	
	public static String nameView(String x,int y) {
		String x1=x;
		for(int i=1;i<y;i++) {
			x1+=x;
		}
		
		return x1;
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int y;
		String xx;
		y=sc.nextInt();
		
	
		xx=sc.next();
		System.out.println(nameView(xx,y));
		
	}

}
