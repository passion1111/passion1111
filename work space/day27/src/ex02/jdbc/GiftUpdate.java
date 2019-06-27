package ex02.jdbc;

import java.util.Scanner;
import java.sql.*;

public class GiftUpdate {
	public static void main(String[] args)  throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver"); // exception
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE" ;
		String uid = "kimkim";
		String pwd = "oracle";
		Connection conn = DriverManager.getConnection(url, uid, pwd); // exception
	
		//3. ���( DML - select )
		Statement stmt = conn.createStatement();
		PreparedStatement pstmt = null;  ///////////////////////////
		ResultSet rs = stmt.executeQuery(" select * from gift ");	
		
		System.out.println("��ǰ��ȣ\t��ǰ��\t������\t�ְ�"  ); 
		while( rs.next() ) {
			int gno = rs.getInt("gno");
			String gname = rs.getString("gname");
			int g_s = rs.getInt("g_start");
			int g_e = rs.getInt("g_end");
			
			System.out.println(gno + "\t" + gname + "\t" + g_s + "\t" + g_e ); 
		}// while end
		
		//////////////// ���ڵ� Update ////////////////////////////
		System.out.println("\n��Ͽ��� Update �� ��ȣ ? ");
		int num = new Scanner(System.in).nextInt();
		
		System.out.println("gno �� �ٲٽðڽ��ϱ�? �������....? ");
		int gno = new Scanner(System.in).nextInt();
		pstmt = conn.prepareStatement("update gift set gno = ? where gno = " + num);
		pstmt.setInt(1, gno);
		pstmt.executeUpdate();  // ��ȯ���� ���� ��� - insert, update, delete
		System.out.println(gno +  " ���� �Ϸ��!!! ");
		///------------------------------------------------------------------------//
		System.out.println("gname�� �ٲٽðڽ��ϱ�? ��ǰ�� ��ɷ�....? ");
		String gname = new Scanner(System.in).next();
		pstmt =  conn.prepareStatement("update gift set gname = ?  where gno = " + gno) ;
		pstmt.setString(1, gname);
		pstmt.executeUpdate();
		System.out.println(gname + " ���� �Ϸ��!! ");
		///------------------------------------------------------------------------//
		System.out.println("���������� �ٲٽðڽ��ϱ�? ��....? ");
		String g_start = new Scanner(System.in).next();
		pstmt =  conn.prepareStatement("update gift set g_start = ? , g_end=?, gname =?  where gno = " + gno) ;
		pstmt.setString(1, g_start);
		pstmt.setInt(2, 20);
		pstmt.setString(3, "kingsmile");
		pstmt.executeUpdate();
		System.out.println(g_start + " ���� �Ϸ��!! ");
		///------------------------------------------------------------------------//
		rs = stmt.executeQuery("select * from gift");
		System.out.println("��ǰ��ȣ\t��ǰ��\t������\t�ְ�"  ); 
		while( rs.next() ) {
		    gno = rs.getInt("gno");
		    gname = rs.getString("gname");
			int g_s = rs.getInt("g_start");
			int g_e = rs.getInt("g_end");
			
			System.out.println(gno + "\t" + gname + "\t" + g_s + "\t" + g_e ); 
		}// while end
	}
}
