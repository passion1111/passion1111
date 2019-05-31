package ex01_If;

import java.util.*;

public class Controller_if {
			public static void main(String[] args) {
				
				System.out.print("integer data input : ");
				  int su=new Scanner(System.in).nextInt();
				  
				  //짝,홀수판정 if
				  if(su%2==0)
				  System.out.println("짝수입니다");
				  else
					  System.out.println("홀수입니다");
			
			   System.out.println("=======");
			   //양수 음수 판별
			   if(su>0)
				    System.out.println("양수");
			   else if(su<0)
				   System.out.println("음수");
			   else
				   System.out.println("0이군여");
			}
			
			           
						}

			
			

