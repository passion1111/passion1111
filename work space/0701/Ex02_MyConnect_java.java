package ex01.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Ex02_MyConnect_java {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
				//1. ����̹� ���
			   Class.forName("com.mysql.jdbc.Driver"); //����̹� Ŭ���� �̸� ��� 
			   System.out.println("My SQL ����̹� �ε� �Ϸ�");
			   
			   //2. �������(ConnectionString)
			   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","kingsmile","mysql");
			   
			   //3.��ɻ��� (CRUD)
			   stmt = conn.createStatement();
			   String sql = "select *  from gift";
			   
			   //4.��ɽ���(mysql ���� ��� ���� ����)
			    rs = stmt.executeQuery(sql);
			   
			   //5.���ó��
			   while(rs.next()){
				   System.out.printf("[%d][%s][%d][%d]\n", 
						                 rs.getInt("gno") , rs.getString("gname") , rs.getInt("g_start"),rs.getInt("g_end") );
			   }
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}finally{
			//6.�ڿ�����
			//DB���� ����
			if(rs != null){try{rs.close();}catch(Exception e){}}
			if(stmt != null){try{stmt.close();}catch(Exception e){}}
			if(conn != null){try{conn.close();}catch(Exception e){}}
		}
		
	}

}
