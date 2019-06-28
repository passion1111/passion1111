package ex03.jdbc12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GiftDelete {

	public GiftDelete() throws ClassNotFoundException, SQLException{
		 Scanner sc=new Scanner(System.in);
		 int select;
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
		
		int num;
		System.out.println("�����Ͻ� ��ȣ��?");
		num=sc.nextInt();
		String sql = 
				 "delete gift where gno="+num;
				
				int result = stmt.executeUpdate(sql);
				System.out.println(result + " ������ ���� ������");
				
				//4. �ڿ���ȯ(�ݱ�)
				stmt.close();		conn.close();
		
		
	}
}
