package dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//if(rs!=null) { try{ rs.close()} catch(Exception e) { } }
//if(rs!=null) { try{ rs.close()} catch(Exception e) { } }
//if(rs!=null) { try{ rs.close()} catch(Exception e) { } }

public class ConnectionCloseHelper1 {

	public static void close(Connection conn) {
		if(conn!=null) {
			try{ conn.close();
				} catch(Exception e) { } }
	}
	public static void close(Statement stmt) {
		if(stmt!=null) { try{ stmt.close();} catch(Exception e) { } }
	}
	public static void close(ResultSet rs) {
		if(rs!=null) {try { rs.close();}catch(Exception e) { } }
	}
	public static void close(PreparedStatement pstmt) {
		if(pstmt!=null) { try{pstmt.close();}catch(Exception e) {}}
	}
	
}
