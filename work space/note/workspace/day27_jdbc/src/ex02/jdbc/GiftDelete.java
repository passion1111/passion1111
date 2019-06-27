package ex02.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class GiftDelete {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String uid = "kingsmile";
			String pwd = "oracle";
			
			String sql = "select * from gift";
			
			Connection conn = DriverManager.getConnection(url, uid, pwd);
			Statement stmt = conn.createStatement();	
			ResultSet rs=stmt.executeQuery(sql);
			
			conn.setAutoCommit(false);	  //////
			
			//3. ���(DML - select  )
			System.out.println("��ǰ��ȣ\t��ǰ��\t������\t�ְ�"  ); 
			while( rs.next() ) {
				int gno = rs.getInt("gno");
				String gname = rs.getString("gname");
				int g_s = rs.getInt("g_start");
				int g_e = rs.getInt("g_end");
				
				System.out.println(gno + "\t" + gname + "\t" + g_s + "\t" + g_e ); 
			}// while end
			
			// DML - delete
			System.out.println("\n��Ͽ��� ������ ��ȣ ? ");
			int num = new Scanner(System.in).nextInt();
			sql = "delete gift where gno = " + num ;
			
			int result = stmt.executeUpdate(sql);
			System.out.println(result + " ������ ���� ����\n");
			conn.commit();
			
			//////// select /////////////////////////////
			rs = stmt.executeQuery("select * from gift") ; 
			System.out.println("��ǰ��ȣ\t��ǰ��\t������\t�ְ�"  ); 
			while( rs.next() ) {
				int gno = rs.getInt("gno");
				String gname = rs.getString("gname");
				int g_s = rs.getInt("g_start");
				int g_e = rs.getInt("g_end");
				
				System.out.println(gno + "\t" + gname + "\t" + g_s + "\t" + g_e ); 
			}// while end
			
			rs.close();			stmt.close();			conn.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
