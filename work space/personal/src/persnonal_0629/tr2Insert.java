package persnonal_0629;
import java.sql.*;
public class tr2Insert {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
   Class.forName("oracle.jdbc.OracleDriver");
   String url = "jdbc:oracle:thin:@localhost:1521:XE";
   String uid = "kim";
   String pwd = "oracle";
   Connection conn =DriverManager.getConnection(url,uid,pwd);
   String sql="insert into gift values(?,?,?,?)";
   PreparedStatement pstm=conn.prepareStatement(sql);
   
   pstm.setInt(1,1);
   pstm.setString(2,"name");
   pstm.setString(3,"3");
   pstm.setInt(4,1*100);
  int result=pstm.executeUpdate();
  System.out.println(result);
//   String sql="insert into gift values(?,?,?,?)";
//	pstm=conn.prepareStatement(sql);
//	pstm.setString(1, "1");
//	pstm.setString(2, "2");
//	pstm.setString(3, "4");
//	pstm.setString(4, "4");
//
//	int result=pstm.executeUpdate();
//	System.out.println(result+"데이터 입력완료");
   
//   rs.close();

   conn.close();
   
   
   
}
   
}//class