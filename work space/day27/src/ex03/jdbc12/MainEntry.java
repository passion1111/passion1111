package ex03.jdbc12;

import java.sql.SQLException;
import java.util.Scanner;

public class MainEntry {
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		Scanner sc=new Scanner(System.in);
		int select;
		while(true) {
			do {
				System.out.println("1��.������Ʈ 2��.�߰�.3.��Ϻ���4.����");
				
				while(!sc.hasNextInt()){
					System.out.println("���ڸ� �Է����ּ���.");
					sc.next();
				}
			select=sc.nextInt();
			}while(select<1||select>4);
//		Ŭ������ �����µ� �Լ��� ���������� �״�� ���� ����.
		if(select==1) {	GiftUpdate gu=new GiftUpdate();}
		else if(select==2) {GiftInsert gi=new GiftInsert(args);} //args 1���� 2.string 3 int   4 int�� �Է�
		else if(select==3){GiftSelect gs=new GiftSelect();}
		else if(select==4) {GiftDelete gd=new GiftDelete();}
		}
		//commit���� ������ ���ϸ� ��.  �׸��� insert��  gno�ߺ��˻縦 ���ؼ� not exist����
		
		
		
		}
}
