package dbExsimple;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.SQLException;


public class StatementTest 
{
    public static void main(String args[])
    {
        Connection conn = null; // DB����� ����(����)�� ���� ��ü
        Statement stm = null;  // SQL ���� ��Ÿ���� ��ü
        
        try {
            conn = DBconnection.getconnConnection();
            stm = (Statement) conn.createStatement();
            
            String quary = "INSERT INTO TEST VALUES('id1', 'pw1', 'name1')";
            int success = ((java.sql.Statement) stm).executeUpdate(quary);
            
            if(success > 0)
                System.out.println("������ �Է� ����");
            else
                System.out.println("������ �Է� ����");
 
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
//			//������ �� ����
//			//1,23,�� ������ �÷�����
//			pstm.setString(1, "confirm1");
//			pstm.setString(2, "confirmed2");
//			pstm.setString(3, "confirmed3");
//			result=pstm.executeUpdate();
//			
//			if(result>0) System.out.println("������ �Է�");
//			else System.out.println("�Է� ����");
//		} catch (Exception sqle) {
//			sqle.printStackTrace();
//		}
//		
//	}
//}
