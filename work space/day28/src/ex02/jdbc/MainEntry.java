package ex02.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		ConnectionUtil jdbc=new ConnectionUtil();
	
		
		jdbc.connect();
		System.out.println("���Ἲ��");
		
		while(true) {
			jdbc.menu();
			int choice=sc.nextInt();
			
			
			switch (choice) {
			case 1:
				jdbc.insert();
				break;
			case 2:
				jdbc.update();
				break;
			case 3:
				jdbc.selectAll();
				break;
			case 4:
				jdbc.delete();
				break;
			case 5:
				System.out.println("�˻��ϰ� ���� �μ���ȣ�� �Է����ּ���");
				int select=sc.nextInt();
				jdbc.select(select);
				
				break;
				
			
			
			case 6:
				jdbc.close();
				System.exit(0);
				break;
				
			default:
				System.out.println("==========menu�� �ִ� ���� �Է����ּ���==============");
				break;
			}
			
		}
	}
}
