
package day03.operator;

import java.util.Scanner;

public class Ex01_Opearator4 {
	public static void main(String[] args) {
		   					//논리 연산자:&  &&(and), |  || (or) , ^(xor)
	
	      Scanner scan=new Scanner(System.in);
	      
	      int su=scan.nextInt();
	      String str= (su%2==0)? "짝수":"홀수";
	      System.out.println(str);
	      			String str2=		(su%2!=0)? "홀수":"짝수";
	      					System.out.println(su+"==>"+str);
	      					
	      					int x=3,y=5,result;
	      					result=(x>y)? x:y;
	      					
	      					System.out.println(result);
	      					
	      					int x1=3, y1=5, z=7;
	      					int max;
	      					max=(x1>y1)?x1:(y1>20)?y1:z;     //x>y아니면 y>20에 다시 삼항계산
	      																//20이상이냐 거짓이기떄문에 z값으로넣어감.
	      													//삼항연산이 2번중복으로 이뤄지고있는것임.
	      					
	      					System.out.println(max);
				
		
	
	


	}//end main

}//end class





