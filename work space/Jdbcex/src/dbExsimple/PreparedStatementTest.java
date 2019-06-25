package dbExsimple;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
 
public class PreparedStatementTest 
{
    public static void main(String args[])
    {
        Connection conn = null; // DB����� ����(����)�� ���� ��ü
        PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
        
        try {
            
            String quary = "INSERT INTO TEST VALUES(?, ?, ?)";
            
            conn = DbConnection223.getConnection();
            pstm = conn.prepareStatement(quary);
            
            // ������ ���� �����Ѵ�.
            // ���⼭ 1, 2, 3�� ù��°, �ι�°, ����° ��ġȦ�� ��� ��
            pstm.setString(1, "id2");
            pstm.setString(2, "pw2");
            pstm.setString(3, "name2");
            
            int success = pstm.executeUpdate();
            
            if(success > 0)
                System.out.println("������ �Է� ����");
            else
                System.out.println("������ �Է� ����");
 
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}


