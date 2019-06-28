//
//package ex01.jdbc;
//
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//
//public class MainEntry {
//
//		
//	static {
//	try {
//		Class.forName("oracle.jdbc.OracleDriver");
//	} catch (ClassNotFoundException e) {
//		e.printStackTrace();
//	}
//} // static end
//			public static void main(String[] args) {
//				String url, uid, pwd;		url = uid = pwd = null;
//				Connection conn = null;
//				Statement stmt = null;
//				
//				try {
//					url= "jdbc:oracle:thin:@127.0.0.1:1521:xe";
//					uid ="kim";
//					pwd="oracle";
//					
//					conn = DriverManager.getConnection(url, uid, pwd);
//					stmt = conn.createStatement();
//					
//					String sql ="CREATE TABLE KOSTATABLE(NAME VARCHAR2(20), AGE NUMBER)";
//					//System.out.println(sql.toString());
//					stmt.executeUpdate(sql);
//					sql = "SELECT * FROM KOSTATABLE";
//					ResultSet rs = stmt.executeQuery(sql);
//					
//					while( rs.next() ) {
//						System.out.println("name : " + rs.getString(1));
//						System.out.println("age : " + rs.getInt(2));
//					} //while end
//					
//					////////////////////////////////
//					sql = "drop table kostaTable";
//					stmt.executeUpdate(sql);
//					int result = stmt.executeUpdate(sql);
//					System.out.println("drop table : " + result);
//					////////////////////////////////
////					
//			} catch (Exception e) {
//				// TODO: handle exception
//			}finally {
//				
//				} // try end
//			
//			}
//		
//}



package ex01.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainEntry {
	
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	} // static end
	
	public static void main(String[] args) {
		String url, uid, pwd;		url = uid = pwd = null;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			url= "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			uid ="kim";
			pwd="oracle";
			
			conn = DriverManager.getConnection(url, uid, pwd);
			stmt = conn.createStatement();
			
			String sql ="CREATE TABLE KOSTATABLE(NAME VARCHAR2(20), AGE NUMBER)";
			//System.out.println(sql.toString());
			stmt.executeUpdate(sql);
			
			sql = "SELECT * FROM KOSTATABLE";
			ResultSet rs = stmt.executeQuery(sql);
			
			while( rs.next() ) {
				System.out.println("name : " + rs.getString(1));
				System.out.println("age : " + rs.getInt(2));
			} //while end
			
			////////////////////////////////
			sql = "drop table kostaTable";
			int result = stmt.executeUpdate(sql);
			System.out.println("drop table : " + result);
			////////////////////////////////
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		} // try end
	}
}