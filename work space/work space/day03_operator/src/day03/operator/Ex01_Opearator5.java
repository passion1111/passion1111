
package day03.operator;
	
public class Ex01_Opearator5 {
	public static void main(String[] args) {
		   					//���� ������:&  &&(and), |  || (or) , ^(xor)
	
	      
		int x=10,y=20,z=30;  //&&,|| ������ �ƿ����� �����̸� �ڿ����� �������.2�������� 10��
									//true,false  �տ����� �����̰ų� ���ΰ��� �տ������� ���ָ� ������󰡴�.
		boolean flag;         //booealn�� ������� true false�� ������ �Ұ�.
		flag=(x<y)&&(y<z);
		System.out.println(flag);
		
		flag=(x<y)||(z<y);           //||�� �տ����� ���̸� �ڿ��� ������� �ǹ̾����Ƿ�.
		System.out.println(flag);
				
		
	
	}//end main

}//end class




/*
int a=4;
int b=7;
int c=3;


  System.out.println(a&b);   //2������
  System.out.println(a|b);
  System.out.println(b^a);
  */



/*  &&�ΰ������� �߰��� �ȸ����� �ٷ� ��������.  ����Ÿ��.
int x=10,y=20,z=30;
boolean flag;

flag=(x>y)&&(y>z);
System.out.println(flag);

*/