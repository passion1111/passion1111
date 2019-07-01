package ex01.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;

import oracle.jdbc.internal.OracleTypes;

/*
 CREATE OR REPLACE PROCEDURE usp_delete_emp
  (
  	vempno IN emp.empno%TYPE,
    p_outmsg OUT VARCHAR2
   )
   IS
   		BEGIN
      		DELETE FROM EMP WHERE empno=vempno;
          COMMIT;
      	  p_outmsg := 'success';
          EXCEPTION WHEN OTHERS THEN
          p_outmsg := SQLERRM;	
          ROLLBACK;
      END;
 */


public class Ex08_Oracle_plsql_DML {
	public static void main(String[] args) {
		Connection conn = null;
		//Statement stmt = null;
		CallableStatement cstmt = null; //pl-sql ���******************
		ResultSet rs = null;
		
		try{
				//1. ����̹� ���
			   Class.forName("oracle.jdbc.OracleDriver"); //����̹� Ŭ���� �̸� ��� 
			   System.out.println("Oracle ����̹� �ε� �Ϸ�");
			   
			   //2. �������(ConnectionString)
			   conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kingsmile","oracle");
			   
			   //3.��ɻ��� (CRUD)
			   //pl-sql ���� =>prepareCall
			   String sql = "{call usp_delete_emp(?,?)}"; //******************
			  // String sql = "{call usp_insert_emp(?,?)}"; //******************
			   cstmt = conn.prepareCall(sql); //****************
			   cstmt.setInt(1, 7839);
			   cstmt.registerOutParameter(2, Types.VARCHAR);  //****************
			   
			   
			   //4.��ɽ���(pl-sql����)
			   cstmt.execute();
			   System.out.println("����");
			   //5.���ó��
			   String msg =  cstmt.getString(2); //************************
			   
			   System.out.println("ó����� : " + msg);
			   
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
