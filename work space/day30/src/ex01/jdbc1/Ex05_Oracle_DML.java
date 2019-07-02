package ex01.jdbc1;

import java.sql.Connection;
import java.sql.Statement;

import dbConn.util.ConnectionCloseHelper;
import dbConn.util.ConnectionHelper;


//CRUD 작업 (Oracle)

class OracleInsert{
	private Connection conn;
	private Statement stmt;
	
	public OracleInsert(int empno , String ename, int sal) { //필요하면 더 넣어서 처리하자.
		//* java jdbc 사용한 DML 별도의 설정이 없다면 (auto-commit)
		try{
			  conn = ConnectionHelper.getConnection("oracle");
			  //String sql = "INSERT INTO EMP(empno, ename,sal) VALUES(1000,'happy',100)";
			  String sql = "INSERT INTO EMP(empno, ename,sal) VALUES("   //문자열일경우 앞뒤로 싱글따옴표
			                  + empno + ",'" + ename+ "'," + sal+")";
			  
			  System.out.println(sql);  //INSERT INTO EMP(empno, ename,sal) VALUES(2,'한글',10)
			  
			  stmt = conn.createStatement();
			  int affectrow =  stmt.executeUpdate(sql);
			  System.out.println("Insert 된 행수 개수 : " + affectrow);
		}catch(Exception e){
			  System.out.println(e.getMessage());
		}finally{
			//여기 helper 성으로 
			//aaa.close(conn)
			//if(stmt != null){try{stmt.close();}catch(Exception e){}}
			//if(conn != null){try{conn.close();}catch(Exception e){}}
			ConnectionCloseHelper.close(stmt);
			ConnectionCloseHelper.close(conn);
		
		}
		
	}
	
}
class OracleUpdate{
	//update 메서드를 만들어서 실행해 보세요
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
		
//		new OracleInsert(2222,"한글",10111);
		OracleUpdate ou = new OracleUpdate();
		int result  = ou.EmpUpdate(1000, 2222);  // sal, empno
		System.out.println("update 된 행수 개수 : " + result);
	}

}
