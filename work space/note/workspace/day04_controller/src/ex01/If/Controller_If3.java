package ex01.If;

import java.util.Scanner;

public class Controller_If3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("integer su1, su2 data input : ");
//		int su1 = new Scanner(System.in).nextInt();
//		int su2 = new Scanner(System.in).nextInt();
		int su1 = sc.nextInt();		int su2 = sc.nextInt();
		int avg = (su1 + su2) / 2 ;  //�������
		String msg = null;
		
		// ���հ� - 40, 1ȸ ��ȸ ���� - 75, 2ȸ ��ȸ ���� - 60
		if( avg <= 40 ) msg = "���հ�";
		
		else if( avg > 75 ) msg = "�հ�";
		
		else if( (avg > 40) && (avg <= 60) ) {
			msg = "1ȸ ��ȸ ����";
		}
				
		else if( avg > 60 ) msg = "2ȸ ��ȸ ����";
		
		System.out.println("\n\n" + avg + " ===> " + msg);
	}
}













