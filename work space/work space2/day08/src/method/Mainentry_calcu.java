package method;

import java.util.Scanner;

//quiz2 max(){�ΰ� ���� �Է¹޾Ƽ� ū�� �����ϴ� �Լ�}
public class Mainentry_calcu{
	public static void add() {//+
		int x, y;
		 System.out.println("���ϰ� ���� �μ��� �Է��ϼ���");
		 x=new Scanner(System.in).nextInt();
		 y=new Scanner(System.in).nextInt();
		 System.out.println(x+y);
		 

		
	}
	public static void sub() {//-
		int x, y;
		System.out.println("������� �μ��� ������� �Է��ϼ���");
		x=new Scanner(System.in).nextInt();
		y=new Scanner(System.in).nextInt();
		System.out.println(x-y);
		
	}
	public static int mul() {//���ϱ�
		int x, y;
		int mul;
		
		System.out.println("���ϰ���� �� ���� �Է��ϼ���");
		x=new Scanner(System.in).nextInt();
		y=new Scanner(System.in).nextInt();
		mul=x*y;
		
		return mul;
		
		
	}
	public static double div() {//������  try catch�����.
		int x, y;
		double div=0;
		System.out.println("������ ���� �� ���� �Է��ϼ���");
		x=new Scanner(System.in).nextInt();
		y=new Scanner(System.in).nextInt();
		div=(double)x/y;
		return div;
		
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		//����ġ�� �Է°�����  �Լ�ȣ���ϰ� ����.
		add();
		sub();
		
	double div11=	div();
	System.out.println(div11);
	
	int mul11=mul();
	System.out.println(mul11);
		
	
	}
}
