package dbExsimple;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleTest {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pstm=null;//sql�� ��Ÿ���� ��ü
		ResultSet rs=null;
		
		try {
		//sql������ ����� ������ select���̶�� ����� ����
//		��ü�� �̸� �غ��� ����
		
			String quary="select*from TEST";
			conn=DBconnection.getconnConnection();
			pstm=conn.prepareStatement(quary);
			rs=pstm.executeQuery();
			
			System.out.println("id pw name");
			System.out.println("******************");
			while(rs.next()) {
				
				String name=rs.getString(1);
				String id=rs.getString(2);
				String pw=rs.getString(3);
				
				
				String result=name+"  "+id+"  "+pw+" " ;
				System.out.println(result);
				
				
			}
		}catch (SQLException sqle) {
		System.out.println("select������ ���ܹ߻�");
		}finally {
			//db������ �����Ѵ�
			try {
				if(rs!=null) {rs.close();}
				if(pstm!=null) {pstm.close();}
				if(conn!=null) {conn.close();}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
	}
}