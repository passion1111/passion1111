package homework;

import java.util.Scanner;

public class Homework_01 {

	public static void main(String[] args) {
		try {
		
		
		// 3�� ���� �Է¹޾Ƽ� ū ������� ���
//		3�� / 10����
		/*
		 * result 
			5 > 4> 3 �� ���� ���ڸ� �����ؼ�
			�־�� (�˻�)
		 */
		String str1, str2, str3 = null;
		System.out.println("���� 3���� ������ �Է��Ͻÿ�. ");
		System.out.print("\nA�� : ");
		int a = new Scanner(System.in).nextInt();
		System.out.print("\nB�� : ");
		int b = new Scanner(System.in).nextInt();
		System.out.print("\nC�� : ");
		int c = new Scanner(System.in).nextInt();
//		321
		
		
		if((a>b)&&(a>c)) {
		
			str1 = (a > b && ( b > c )) ? ("A�� : "+a+" > " + "B�� : "+b+" > "+"C�� : " +c) 
				: (a > b && ( c > b )) ? ("A�� : "+a+" > " + "C�� : "+c+" > "+"B�� : " +b) : "�� ����� �ƴմϴ�";
				
				System.out.println(str1);	
		}
		else if ((b>c)&&(b>a)) {
		str2 = (b > a && ( a > c )) ? ("B�� : "+b+" > " + "A�� : "+a+" > "+"C�� : " +c) 
						: (b > c && ( c > a )) ? ("B�� : "+b+" > " + "C�� : "+c+" > "+"A�� : " +a) : "�� ����� �ƴմϴ�";
						
						System.out.println(str2);
		}
		else if ((c>b)&&(c>a)) {
		str3 = (c > a && ( a > b )) ? ("C�� : "+c+" > " + "A�� : "+a+" > "+"B�� : " +b) 
								: (c > b && ( b > a )) ? ("C�� : "+c+" > " + "B�� : "+b+" > "+"A�� : " +a) : "�� ����� �ƴմϴ�";
								
								System.out.println(str3);
		}
		}				
		
		  catch(Exception e) {  System.out.println("�Է��ϽŽ� ���� ���ڰ� �ƴմϴ�.");  
		  e.printStackTrace();}
		  
		
		

		
		
		
		
		
	}

}
