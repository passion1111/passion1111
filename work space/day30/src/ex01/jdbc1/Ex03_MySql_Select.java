package ex01.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Ex03_MySql_Select {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
				//1. ����̹� ���
			   Class.forName("com.mysql.jdbc.Driver"); //����̹� Ŭ���� �̸� ��� 
			   System.out.println("My SQL ����̹� �ε� �Ϸ�");
			   
			   //2. �������(ConnectionString)
			   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampleUser","1004");
			   
			   //3.��ɻ��� (CRUD)
			   stmt = conn.createStatement();
			   String sql = "select empno, ename , job  from emp where empno=1004";
			   
			   //4.��ɽ���(mysql ���� ��� ���� ����)
			    rs = stmt.executeQuery(sql);
			   
			   //5.���ó��
			   // ��ȯ�� row �� 1�� �̻��� ���
			   // if(rs.next()){ do{}while(rs.next())}
			   //while(rs.next()){  
			   //   System.out.printf("[%d][%s][%s]\n", 
			   //			                 rs.getInt(1) , rs.getString(2) , rs.getString(3) );
			   //}
			   //***************��ȯ�� row �� 1���� ��� ó��*****************************************
			    if(rs.next()){
			    	 System.out.printf("[%d][%s][%s]\n", 
			  			  			                 rs.getInt(1) , rs.getString(2) , rs.getString(3) );
			    }else{
			    	 System.out.println("��ȯ�� ���� �����ϴ�");
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