package codingdojang;

import java.util.Scanner;

//�Է� : �ѰǼ�(m), ���������� ������ �Խù���(n) (�� n�� 1���� ũ�ų� ����. n >= 1)
//��� : ����������
public class Personal_codingdojang3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n,m;
		
		do {
			n=sc.nextInt();
			
		}while(n<1);
			m=sc.nextInt();
		 
			if(n%m!=0) System.out.println(m/n+1);
			else System.out.println(m/n);
	}
}