package personal;

import java.util.Scanner;

public class next_nextLine{
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		String a1=scan.next();
		System.out.println(a1);
		scan.nextLine();
		String a2=scan.nextLine();
		System.out.println("2����"+a2);
	
		
		
	}
}