package persnonal_0629_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class giftController1 {
	
	
	static String url="jdbc:oracle:thin:@localhost:1521:xe";
	static String uid="kim";
	static String pw="oracle";
	static String driver="oracle.jdbc.OracleDriver";
	static PreparedStatement pstm=null;
	static Connection conn=null;
	static Scanner sc=new Scanner(System.in);
	
	
	
	
	
	public  static void connect() throws ClassNotFoundException, SQLException{
		
		Class.forName(driver);
		conn=DriverManager.getConnection(url, uid, pw);

		conn.setAutoCommit(false); // �ڵ�Ŀ�� ���� 
	
	}
	
	public static void select() throws SQLException {
		String sql="select *from gift";
		pstm=conn.prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		ResultSetMetaData rsmd=rs.getMetaData();
		int count=rsmd.getColumnCount();
		while(rs.next()) {
			for (int i = 1; i <= count; i++) {
				switch(rsmd.getColumnType(i)) {
				
				case Types.NUMERIC:
				case Types.INTEGER:
					System.out.print(rsmd.getColumnName(i)+" "+rs.getInt(i)+ " ");
				break;
				
				case Types.DOUBLE:
					System.out.print(rsmd.getColumnName(i)+" "+rs.getDouble(i)+" ");
				break;
				
				case Types.FLOAT:
					System.out.print(rsmd.getColumnName(i)+" "+rs.getFloat(i)+ " ");
				break;
				default:
					System.out.print(rsmd.getColumnName(i)+" "+rs.getString(i)+ " ");
				
				}
				
				
				
			}//for end
			System.out.println();
		}
		
	
		
		
		
	}
	
	public static void insert() throws SQLException {
		String sql="insert into "+gift.getClassName()+" values(?,?,?,?)";
		pstm=conn.prepareStatement(sql);
		System.out.println("gno �Է����ּ���");
		String gno=sc.next();
		System.out.println("gname�� �Է����ּ���");
		String gname=sc.next();
		System.out.println("g_start�� �Է����ּ���");
		String g_start=sc.next();
		System.out.println("g_end�� �Է����ּ���");
		String g_end=sc.next();
		
		
		pstm.setString(1, gno);
		pstm.setString(2, gname);
		pstm.setString(3, g_start);
		pstm.setString(4, g_end);
		pstm.executeUpdate();
		
		
		
	}
	public static void update() throws SQLException {
	
		
		System.out.println("��ġ�� ���� Gno��ȣ�� �Է����ּ���.");	
		int result=sc.nextInt();
		
		System.out.println("������ ��ġ�� �����Ű���? 1.gno,2.gname,3.gstart,4.gend 5.��ü ");
		int SelectCoulmn=sc.nextInt();
		String sql = null;
		
		
		switch (SelectCoulmn) {
		case 1:
			System.out.println("��ġ�� ���� ���� �Է����ּ���");
			int ChangeCoulmn=sc.nextInt();
			sql="update "+gift.getClassName()+" set gno="+ChangeCoulmn+" where  gno="+result;
			break;
		case 2:
			System.out.println("��ġ�� ���� ���� �Է����ּ���");
			
			sql="update "+gift.getClassName()+" set gname="+sc.next()+" where  gno="+result;
			
			break;
		case 3:
				System.out.println("��ġ�� ���� ���� �Է����ּ���");
			
			sql="update "+gift.getClassName()+" set g_start="+sc.nextInt()+" where  gno="+result;
			break;
		case 4:
				System.out.println("��ġ�� ���� ���� �Է����ּ���");
			
			sql="update "+gift.getClassName()+" set g_end="+sc.nextInt()+" where  gno="+result;
			break;
		case 5:
			System.out.println("��ġ�� ���� ���� �Է����ּ���");
			
			sql="update "+gift.getClassName()+" set gno="+sc.nextInt()+",gname="+sc.next()  +"where  gno="+result;
			
			break;
	
		default:
			break;
		}
		
		
		
		pstm=conn.prepareStatement(sql);
		pstm.executeUpdate();
		
	}
	
	
}
