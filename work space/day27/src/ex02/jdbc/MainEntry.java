package ex02.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import ex03.jdbc12.GiftDelete;
import ex03.jdbc12.GiftInsert;
import ex03.jdbc12.GiftSelect;
import ex03.jdbc12.GiftUpdate;

public class MainEntry {
	
	public   Connection Connection  ()  throws ClassNotFoundException, SQLException{
		// 1.Driver load,... exception
				Class.forName("oracle.jdbc.OracleDriver");
				// 2. Connection & Open
				// driver:@IP:portNumber:SID(or ���������ͺ��̽���)
				String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
				String uid = "kimkim";
				String pwd = "oracle";
				Connection conn = DriverManager.getConnection(url, uid, pwd);
				return conn;
	}
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
		if(select==1) {	GiftUpdate1 gu=new GiftUpdate1();}
		else if(select==2) {GiftInsert1 gi=new GiftInsert1(args);} //args 1���� 2.string 3 int   4 int�� �Է�
		else if(select==3){GiftSelect1 gs=new GiftSelect1();}
		else if(select==4) {GiftDelete gd=new GiftDelete();}
		}
		//commit���� ������ ���ϸ� ��.  �׸��� insert��  gno�ߺ��˻縦 ���ؼ� not exist����
		 
		
	
		}

}
