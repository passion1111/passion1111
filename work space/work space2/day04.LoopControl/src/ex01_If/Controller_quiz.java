package ex01_If;

// �̸�, ����3���Է¹ް� ,���� ��� ���� ���ϱ�.
import java.util.Scanner;

public class Controller_quiz {
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
		  

		
		  if(a<=59) a1="F";
		  else if((60<=a)&&(a<69)) a1="D";
		  else if((70<=a)&&(a<79)) a1="C";
		  else if((80<=a)&&(a<89)) a1="B";
		  else if(90<a) a1="A";
		  
		  if(b<=59) b1="F";
		  else if((60<=b)&&(a<69)) b1="D";
		  else if((70<=b)&&(a<79)) b1="C";
		  else if((80<=b)&&(a<89)) b1="B";
		  else if(90<a) b1="A";
		  
		  if(c<=59) c1="F";
		  else if((60<=c)&&(a<69)) c1="D";
		  else if((70<=c)&&(a<79)) c1="C";
		  else if((80<=c)&&(a<89)) c1="B";
		  else if(90<a) c1="A";
		  
		  
		  if(ave<=59) ave1="F";
		  else if((60<=ave)&&(ave<69)) ave1="D";
		  else if((70<=ave)&&(ave<79)) ave1="C";
		  else if((80<=ave)&&(ave<89)) ave1="B";
		  else if(90<ave) ave1="A";
		
		  
		   System.out.println("****"+name+"���� ����ǥ�Դϴ�.****");
			System.out.println("�̸�:" + name);
			System.out.println("���� :" + a + "\t����: " + b + "\t����: " + c);
			System.out.println(name+"���� ������ ");
			System.out.println("���� :" + a1 + "\t����: " + b1 + "\t����: " + c1);
			System.out.printf("����: " + sum + "\t���: %.2f ", ave ,"\t ������� : "+ave1 );
			System.out.println("�������:"+ave1);
			
		  
		

	}

}