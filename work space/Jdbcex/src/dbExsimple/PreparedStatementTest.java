package dbExsimple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
 
public class PreparedStatementTest 
{
    public static void main(String args[])
    {
        Connection conn = null; // DB����� ����(����)�� ���� ��ü
        PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
        Scanner sc=new Scanner(System.in);
        String id,pw,name;
        id=sc.next();
        pw=sc.next();
        name=sc.next();
        try {
            
            String quary = "INSERT INTO TEST VALUES(?, ?, ?)";
            
            conn = DbConnection.getConnection();
            pstm = conn.prepareStatement(quary);
           
            // ������ ���� �����Ѵ�.
            // ���⼭ 1, 2, 3�� ù��°, �ι�°, ����° ��ġȦ�� ��� ��
            pstm.setString(1, id);
            pstm.setString(2, pw);
            pstm.setString(3, name);
            
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


