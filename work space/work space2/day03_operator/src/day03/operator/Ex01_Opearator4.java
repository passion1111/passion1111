
package day03.operator;

import java.util.Scanner;

public class Ex01_Opearator4 {
	public static void main(String[] args) {
		   					//�� ������:&  &&(and), |  || (or) , ^(xor)
	
	      Scanner scan=new Scanner(System.in);
	      
	      int su=scan.nextInt();
	      String str= (su%2==0)? "¦��":"Ȧ��";
	      System.out.println(str);
	      			String str2=		(su%2!=0)? "Ȧ��":"¦��";
	      					System.out.println(su+"==>"+str);
	      					
	      					int x=3,y=5,result;
	      					result=(x>y)? x:y;
	      					
	      					System.out.println(result);
	      					
	      					int x1=3, y1=5, z=7;
	      					int max;
	      					max=(x1>y1)?x1:(y1>20)?y1:z;     //x>y�ƴϸ� y>20�� �ٽ� ���װ��
	      																//20�̻��̳� �����̱⋚���� z�����γ־.
	      													//���׿����� 2���ߺ����� �̷������ִ°���.
	      					
	      					System.out.println(max);
				
		
	
	


	}//end main

}//end class





