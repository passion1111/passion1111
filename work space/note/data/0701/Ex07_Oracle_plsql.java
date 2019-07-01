package ex01.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import dbConn.util.ConnectionHelper;
import oracle.jdbc.OracleTypes;

/*
 CREATE OR REPLACE PROCEDURE SCOTT.usp_EmpList
(
	p_sal IN number,
  p_cursor OUT SYS_REFCURSOR --APP ����ϱ� ���� Ÿ��
)
IS
	BEGIN
  			OPEN p_cursor
        FOR
        		 SELECT empno, ename, sal FROM EMP WHERE sal > p_sal;

  END; 
 */
public class Ex07_Oracle_plsql {


	public static void main(String[] args) {
		Connection conn = null;
		//Statement stmt = null;
		CallableStatement cstmt = null; //pl-sql ���******************
		ResultSet rs = null;
		
		try{
				//1. ����̹� ���
			  /* Class.forName("oracle.jdbc.OracleDriver"); //����̹� Ŭ���� �̸� ��� 
			   System.out.println("Oracle ����̹� �ε� �Ϸ�");
			   
			   //2. �������(ConnectionString)
			   conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kingsmile","oracle");*/
			 conn = ConnectionHelper.getConnection("oracle");
			   
			   //3.��ɻ��� (CRUD)
			   //pl-sql ���� =>prepareCall
			 //String sql = "SELECT empno, ename, sal FROM EMP WHERE sal > ?;"
			   String sql = "{call usp_EmpList(?,?)}"; //******************
			   cstmt = conn.prepareCall(sql); //****************
			   //cstmt.executeQuery();
			   cstmt.setInt(1, 2000);
			   cstmt.registerOutParameter(2, OracleTypes.CURSOR);  //****************
			   
			   
			   //4.��ɽ���(pl-sql����)
			   cstmt.execute();
			   System.out.println("����");
			   //5.���ó��
			   rs =  (ResultSet)cstmt.getObject(2); //************************
			   
			   while(rs.next()){
				   System.out.printf("[%d][%s][%d]\n", 
						                 rs.getInt(1) , rs.getString(2) , rs.getInt(3) );
			     }
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}finally{
			//6.�ڿ�����
			//DB���� ����
			if(rs != null){try{rs.close();}catch(Exception e){}}
			if(cstmt != null){try{cstmt.close();}catch(Exception e){}}
			if(conn != null){try{conn.close();}catch(Exception e){}}
		}
		
	}

}
