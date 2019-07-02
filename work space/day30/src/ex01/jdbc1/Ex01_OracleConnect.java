package ex01.jdbc1;

/*
 * Java ���� MySql �����ϱ�
 * 1.  mysql ����Ʈ���� JDBC ����̹� �ٿ� �ޱ�
 * 2. mysql-connector-java-5.1.26-bin.jar ���� ������ Ȯ��
 * 3. lib �߰��� ���� ���� ����
 * 4. MySQL - com.mysql.jdbc.Driver
      ����Ŭ - oracle.jdbc.driver.OracleDriver
                 oracle.jdbc.OracleDriver
      MS SQL ���� - com.microsoft.sqlserver.jdbc.SQLServerDriver
   5. MySQL���� ���� : DB��(sampledb) port:3306  ����(SampleUser) ���(1004)
   6. Java API : java.sql.* ���� �ڿ��� ���
   
   ��Ÿ
   �ֿ� DBMS�� JDBC URL ����
	MySQL : jdbc:mysql://HOST[:PORT]/DBNAME[?param=value&param1=value2&...]
	Oracle: jdbc:oracle:thin:@HOST:PORT:SID
	MS SQL : jdbc:sqlserver://HOST[:PORT];databaseName=DB

   
 */
	//JDBC ������ �����ϱ�
	//1. �����ϰ��� �ϴ� �����ͺ��̽� ����̹� �ε�
	//2. ����̹� �ε�
	//3. ������� (� DB���� , � port  , � ����� , � ��� ���� (Connection String)
	//4. ��ɻ��� (CRUD) 
	//5. ��ɽ��� (execute ....  select (resultset) , insert , update , delete ...
	//6. ���ó�� (��ȸ , ��� ,,,,,)
	//7. �ڿ����� (���� ����)

import java.sql.DriverManager; //����̹�
import java.sql.Connection;  //����
import java.sql.Statement;   //���
import java.sql.ResultSet;     //���ó��

public class Ex01_OracleConnect {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
				//1. ����̹� ���
			   Class.forName("oracle.jdbc.OracleDriver"); //����̹� Ŭ���� �̸� ��� 
			   System.out.println("Oracle ����̹� �ε� �Ϸ�");
			   
			   //2. �������(ConnectionString)
			   conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kim","oracle");
			   System.out.println("Connection Success");
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
