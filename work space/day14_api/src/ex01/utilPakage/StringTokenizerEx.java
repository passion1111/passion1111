
package ex01.utilPakage;

import java.util.StringTokenizer;

//����� 
public class StringTokenizerEx {
		public static void main(String[] args) {
			StringTokenizer token=new StringTokenizer("���=10|���ڷ�=3|������=1","=|",true); // 
			
			while(token.hasMoreTokens()) {//hash������� ���µ��� ������Ұ� �ִ���
//				System.out.println(token.nextToken());//������ū ����ִ°�.
				
				String str=token.nextToken();
				if(str.equals("="))System.out.println("\t");
				else if(str.equals("|"))System.out.println("\n");
				else System.out.println(str);
			}
		}
}









/*
package ex01.utilPakage;

import java.util.StringTokenizer;

//����� 
public class StringTokenizerEx {
		public static void main(String[] args) {
			StringTokenizer token=new StringTokenizer("�����1/�����2/�����3/�����4","/"); // , " " ���� ������ �����������
//			StringTokenizer token=new StringTokenizer("�����1 �����2 �����3 �����4");
			
			while(token.hasMoreTokens()) {//hash������� ���µ���
				System.out.println(token.nextToken());//������ū ����ִ°�.
			}
		}
}
*/