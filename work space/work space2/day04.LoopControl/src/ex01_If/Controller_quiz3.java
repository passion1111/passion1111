package ex01_If;
//����3
//����,����,���� ���� �Է¹޾Ƽ� ��� 60���̻��̰�, �� ���� ������ 40������
//
// 
// 
import java.util.Scanner;

public class Controller_quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("�̸��� �Է��ϼ���: ");
		String name = sc.nextLine();
		// System.out.println(name);

		System.out.println("���� ������ �Է��ϼ���: ");
		int a = sc.nextInt();
		// System.out.println(a);
		System.out.println("���� ������ �Է��ϼ���: ");
		int b = sc.nextInt();
		// System.out.println(b);
		System.out.println("���� ������ �Է��ϼ���: ");
		int c = sc.nextInt();
		// System.out.println(c); �� Ȯ��
	
		int sum = a + b + c;
		float ave = (float) sum / 3;
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
		  
		  if(60<=ave) {
			  if((40<a)&&(40<b)&&(40<c))
			  			  ave1="�հ��Դϴ�";
			  else if(a<=40)
				  ave1="������� ���հ��ϼ̽��ϴ�.";
			  else if(b<=40)
				  ave1="������� ���հ��ϼ̽��ϴ�.";
			  else if(c<=40)
				  ave1="���ꋚ���� ���հ��ϼ̽��ϴ�.";
		  }
		     
		   else 
			   		   ave1="���հ��Դϴ�.";

		  
		   System.out.println("****"+name+"���� ����ǥ�Դϴ�.****");
			System.out.println("�̸�:" + name);
			System.out.println("���� :" + a + "\t����: " + b + "\t����: " + c);
			System.out.println(name+"���� �հݿ��δ� ");
			System.out.println("���� :" + a1 + "\t����: " + b1 + "\t����: " + c1);
			System.out.println("����� ��� ������ : "+ave);
			System.out.printf("�����"+ave1);
			
			
		sc.close();
		  
		  
		
		  

		  
		

	}

}