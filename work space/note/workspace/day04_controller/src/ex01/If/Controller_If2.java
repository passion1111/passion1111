package ex01.If;

import java.util.Scanner;

public class Controller_If2 {
	public static void main(String[] args) {
		
		System.out.print("integer data input : ");
		int su = new Scanner(System.in).nextInt();
		
				
		if(su % 2 == 0) {
			System.out.println("¦��");
			
			if( su > 0 ) {
				System.out.println("���");
			} else if( su < 0 ) {
				System.out.println("����");
			} else {
				System.out.println("0�̱���");
			}
		}
		else {
			
			System.out.println("Ȧ��");
			
			if( su > 0 ) {
				System.out.println("���");
			} else if( su < 0 ) {
				System.out.println("����");
			} else {
				System.out.println("0�̱���");
			}
		}// if end
	}
}




