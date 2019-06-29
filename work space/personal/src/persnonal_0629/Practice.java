package persnonal_0629;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Practice {
	static Connection conn=null;
	PreparedStatement pstm=null;
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Practice p=new Practice();
		p.connect();
		p.select();
		p.insert();
		p.select();
		
		p.close();

		
	
	}

	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String uid ="kim";
		String pw ="oracle";
		conn=DriverManager.getConnection(url, uid, pw);
	}
	
	public void select() throws SQLException {
		System.out.println("연결성공");
		
		String sql="select * from gift";
		pstm=conn.prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		
		while(rs.next()) {
			String a=rs.getString(1);
			String b=rs.getString(2);
			String c=rs.getString(3);
			String d=rs.getString(4);
			String e=rs.getString(5);
			System.out.println(a+"\t"+b+"\t"+c+"\t"+d+"\t"+e);
			
			
			
		}
	}
	
	public void insert() throws SQLException {
		String sql="insert into gift values(?,?,?,?,?)";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1, "1");
		pstm.setString(2, "2");
		pstm.setString(3, "4");
		pstm.setString(4, "4");
		pstm.setString(5, "5");
		int result=pstm.executeUpdate();
		System.out.println(result+"데이터 입력완료");
		
		
	
	}
	
	public void close() throws SQLException {

		conn.close();
		pstm.close();
	}

}
