package ex01_If;
//����3
//����,����,���� ���� �Է¹޾Ƽ� ��� 60���̻��̰�, �� ���� ������ 40������
//
// 
// 
import java.util.Scanner;

public class Controller_quiz3_teacher {
	public static void main(String[] args) {

       
		

		System.out.println("���� ������ �Է��ϼ���: ");
		int a=new Scanner(System.in).nextInt();
		// System.out.println(a);
		System.out.println("���� ������ �Է��ϼ���: ");
		int b=new Scanner(System.in).nextInt();
		// System.out.println(b);
		System.out.println("���� ������ �Է��ϼ���: ");
		int c=new Scanner(System.in).nextInt();
		// System.out.println(c); �� Ȯ��
	
		int sum = a + b + c;
		double ave=(a+b+c)/3.0; 
		String a1=null;
		String b1=null;
		String c1=null;
		String ave1=null;
		  

		
		  if(a<=40) a1="����";
		  else if((60<=a)&&(a<=100)) a1="�հ������Դϴ�.";
		  	  
		  if(b<=40) b1="����";
		  else if((60<=b)&&(a<=100)) b1="�հ������Դϴ�.";
		  
		  if(c<=40) c1="����";
		  else if((60<=c)&&(a<=100)) c1="�հ������Դϴ�.";
		  
		  if(60<=ave) {      //3���� ��� 60�� �̻��̾����
               if(40<=a&&40<=b&&40<=c) {
			  System.out.printf("�������� 40�� �̻��̸� "+
					  				"����� %.2f�� [�հ�]�Դϴ�\n",ave);
               } 
               else {
            	            System.out.printf("����� %.2f������ ,",ave);
            	             if(a<40) System.out.print("����"+a+" ��");
            	             else if(b<40) System.out.print("����"+a+" ��");
            	             else if(c<40) System.out.print("����"+a+" ��");
            	             System.out.println("���� [���� Ż��]�Դϴ�.");
               }
		  }
		   else 
			   System.out.printf("����� %.2f�� [��� �̴޷� ���հ���]�ϴ�\n",ave);

		  
		  
			
		
		  
		  
		
		  

		  
		

	
}
}

//���� ��ġ��