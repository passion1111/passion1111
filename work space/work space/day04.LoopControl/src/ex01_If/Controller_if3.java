package ex01_If;
//���� �̸�,����3��(����,����,����)
//����,���,����(����)���ϴ� ���α׷� �ۼ�.
import java.util.Scanner;

public class Controller_if3 {
	public static void main(String[] args) {
			Scanner scan=new Scanner(System.in);
		System.out.print("integer su1,su2 data input : ");
		
		    int su1=scan.nextInt();
		    int su2=scan.nextInt();
		    //�ջ� ����� ���հ�-x<40, 1ȸ ��ȸ ���� 75<x,2ȸ ��ȸ ����<60 75�̻� �հ�
		          double avg=(su1+su2)/2.;
		             String msg=null;
		             if(avg<=40) msg="���հ�";
		             else if((60<=avg)&&(avg<75))  msg="2ȸ ��ȸ ����";		            	  
		             else if((40<=avg)&&(avg<=60))msg="1ȸ ��ȸ ����" ;
		             else msg="�հ�";
		             System.out.println("\n\n ���"+avg+"\n����� : "+msg);
		             
		            	 
		            	 
		            	   
		          
		    
						}

}
