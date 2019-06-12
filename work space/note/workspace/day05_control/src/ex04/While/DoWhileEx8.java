package ex04.While;

import java.util.Scanner;

public class DoWhileEx8 {
	public static void main(String[] args) {
		
		int su;
		char grade =' ';
		
		
		do {
			System.out.print("당신의 점수 입력 요망 : ");
			su = new Scanner(System.in).nextInt();
			
		} while(su < 0 || su > 101);
		
		switch (su / 10) {
			case 10:
			case 9 : grade='A';	break;
			case 8 : grade='B';	break;
			case 7 : grade='C';	break;
			case 6 : grade='D';	break;
			default: grade='F';
		} // end switch
		
		System.out.println("\n당신의 점수 " +su 
							+ " ==> " + grade + "학점");
	}
}




