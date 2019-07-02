package ex01.jdbc1;

import java.sql.Connection;
import java.sql.Statement;

import dbConn.util.ConnectionCloseHelper;
import dbConn.util.ConnectionHelper;


//CRUD �۾� (Oracle)

class OracleInsert{
	private Connection conn;
	private Statement stmt;
	
	public OracleInsert(int empno , String ename, int sal) { //�ʿ��ϸ� �� �־ ó������.
		//* java jdbc ����� DML ������ ������ ���ٸ� (auto-commit)
		try{
			  conn = ConnectionHelper.getConnection("oracle");
			  //String sql = "INSERT INTO EMP(empno, ename,sal) VALUES(1000,'happy',100)";
			  String sql = "INSERT INTO EMP(empno, ename,sal) VALUES("   //���ڿ��ϰ�� �յڷ� �̱۵���ǥ
			                  + empno + ",'" + ename+ "'," + sal+")";
			  
			  System.out.println(sql);  //INSERT INTO EMP(empno, ename,sal) VALUES(2,'�ѱ�',10)
			  
			  stmt = conn.createStatement();
			  int affectrow =  stmt.executeUpdate(sql);
			  System.out.println("Insert �� ��� ���� : " + affectrow);
		}catch(Exception e){
			  System.out.println(e.getMessage());
		}finally{
			//���� helper ������ 
			//aaa.close(conn)
			//if(stmt != null){try{stmt.close();}catch(Exception e){}}
			//if(conn != null){try{conn.close();}catch(Exception e){}}
			ConnectionCloseHelper.close(stmt);
			ConnectionCloseHelper.close(conn);
		
		}
		
	}
	
}
class OracleUpdate{
	//update �޼��带 ���� ������ ������
	private Connection conn;
	private Statement stmt;
	
	public OracleUpdate() {
		  conn = ConnectionHelper.getConnection("oracle");
	}
	
	public int EmpUpdate(int sal , int empno){
		int affectrow = 0;
		try{
			   String sql = "update emp set sal=" + sal + " where empno=" +empno;
			
			   stmt = conn.createStatement();
			   affectrow  =  stmt.executeUpdate(sql); //
			   conn.commit(); //
		}catch(Exception e){
			  System.out.println(e.getMessage());
		}finally{
			ConnectionCloseHelper.close(stmt);
			ConnectionCloseHelper.close(conn);
			return affectrow;
		}
	}
}



public class Ex05_Oracle_DML {

	public static void main(String[] args) {
		
//		new OracleInsert(2222,"�ѱ�",10111);
		OracleUpdate ou = new OracleUpdate();
		int result  = ou.EmpUpdate(1000, 2222);  // sal, empno
		System.out.println("update �� ��� ���� : " + result);
	}

}
