package dbExsimple;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.SQLException;


public class StatementTest 
{
    public static void main(String args[])
    {
        Connection conn = null; // DB연결된 상태(세션)을 담은 객체
        Statement stm = null;  // SQL 문을 나타내는 객체
        
        try {
            conn = DBconnection.getconnConnection();
            stm = (Statement) conn.createStatement();
            
            String quary = "INSERT INTO TEST VALUES('id1', 'pw1', 'name1')";
            int success = ((java.sql.Statement) stm).executeUpdate(quary);
            
            if(success > 0)
                System.out.println("데이터 입력 성공");
            else
                System.out.println("데이터 입력 실패");
 
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}



//public class StatementTest_oracle {
//	public static void main(String args[]) {
//		Connection conn=null;
//		PreparedStatement pstm=null;
//		int result;
//		try {
//			String quary="insert into test values(?,?,?)";
//			conn=DbConnection223.getConnection();
//			pstm=conn.prepareStatement(quary);
//			//쿼리에 값 세팅
//			//1,23,은 각각의 컬럼순서
//			pstm.setString(1, "confirm1");
//			pstm.setString(2, "confirmed2");
//			pstm.setString(3, "confirmed3");
//			result=pstm.executeUpdate();
//			
//			if(result>0) System.out.println("데이터 입력");
//			else System.out.println("입력 실패");
//		} catch (Exception sqle) {
//			sqle.printStackTrace();
//		}
//		
//	}
//}
