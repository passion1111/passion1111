package ex01_If;

import java.util.Scanner;

public class Controller_if2 {
	public static void main(String[] args) {

		System.out.print("integer data input : ");
		int su = new Scanner(System.in).nextInt();
		if (su % 2 == 0) {
			System.out.println("짝수입니다");
		            if(su>0) 
			                  System.out.println("양수");
		            else if(su<0)
			                     System.out.println("음수");
		            else
		                    	 System.out.println("0이군여");         //짝수 홀수가 양수이냐 음수이냐로 할려면 if문안에 if가 중복코드로 있기떄문에
		            															//중복코드를 줄이기위해서는 메소드를 하나 만들어줄 필요가 있다.
	}
		else {
			System.out.println("홀수입니다");
			        if(su>0) 
                 System.out.println("양수");
			       	else if(su<0)
                    System.out.println("음수");
			       	else
               	 System.out.println("0이군여");  
							
						}
}
}
