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
        String id;
        String pw;
        String name;
        System.out.println("id�� �Է����ּ���");
        id=sc.next();
        System.out.println("pw�� �Է����ּ���");
        pw=sc.next();
        System.out.println("�̸��� �Է����ּ���");
        name=sc.next();
        
        
        try {
            
            String quary = "INSERT INTO TEST VALUES(?, ?, ?)";
            
            conn = DBconnection.getconnConnection();
            pstm = conn.prepareStatement(quary);
            
            // ������ ���� �����Ѵ�.
            // ���⼭ 1, 2, 3�� ù��°, �ι�°, ����° ��ġȦ�� ��� ��
            pstm.setString(1, id);
            pstm.setString(2, pw);
            pstm.setString(3, name);
            
            int success = pstm.executeUpdate();
            
            if(success > 0) {
                System.out.println("������ �Է� ����");
//            OracleTest__this a=new OracleTest__this();  //�Է¹����� Ȯ���ϴ� ��.
            }else
                System.out.println("������ �Է� ����");
 
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}


