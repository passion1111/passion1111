package ex02.jdbc;
import java.sql.*;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;



public class ConnectionUtil {
	private static final String driver="oracle.jdbc.OracleDriver";
	private static final String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String uid="kim";
	String pw="oracle";
	Scanner sc=new Scanner(System.in);
	PreparedStatement pstm=null;
	Connection conn=null;
	ResultSet rs=null;
	String sql=null;
	String dcode,Dname,Pdept,Area;
	
	
	
	
	
	
	
	
	//menu
	public static void menu() {
		System.out.println("\n================ JDBC query=========");
		System.out.println("\t 1.���ڵ���� ");
		System.out.println("\t 2.���ڵ���� ");
		System.out.println("\t 3.��ü���� ");
		System.out.println("\t 4.���ڵ���� ");
		System.out.println("\t 5.���ϴ� �μ���ȣ �˻� ");
		System.out.println("\t 6.�ý��� ����");
		System.out.println("���ϴ� �޴� ���� �Է� ");
		
	
	
	}
	
	
	//select()
	public void selectAll() throws SQLException {
		pstm=conn.prepareStatement("select*from dept2"); //�� ��ɾ ����ɋ� ���������ͺ��̽��� �����ҋ�
		rs=pstm.executeQuery();//��ȯ���� �����Ƿ�
		System.out.println("\n Dcode \t dname \t pdept \t area");
		while(rs.next()) {
			System.out.print(rs.getString(1) +"\t");
			System.out.print(rs.getString(2) +"\t");
			System.out.print(rs.getString(3)+"\t");
			System.out.print(rs.getString(4)+"\t \n");
			
		}
		
	}
	
	
	public void select(int select) {
		
		try {
			
			sql="select * from dept2 where dcode="+select;
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			System.out.println("\n Dcode \t dname \t Pdept \t Area");
			while(rs.next()) {
				System.out.print(rs.getString(1) +"\t");
				System.out.print(rs.getString(2) +"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString(4)+"\t \n");
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
	}
	
	//insert()
	
	public void insert() throws SQLException {
		
		System.out.println("Dcode: ");
		dcode=sc.next();
		
		System.out.println("Dname: ");
		Dname=sc.next();
		
		System.out.println("Pdept: ");
		Pdept=sc.next();
		
		System.out.println("Area: ");
		Area=sc.next();
		
		
		try {
			

			sql = "INSERT INTO DEPT2 VALUEs( ?, ?, ?, ? )";
			pstm = conn.prepareStatement(sql);     // pstmt.setXXX( ����, �� );
			pstm.setString(1, dcode);
			pstm.setString(2, new String(Dname.getBytes("utf-8"), "utf-8"));
			pstm.setString(3, Pdept);
			pstm.setString(4, Area);
			
			
			int result=pstm.executeUpdate();
			System.out.println(result + "�����Ͱ� �߰��Ǿ����ϴ�.");
			// ȭ�� ��� Ȯ���ϰ��� �Ҷ� - select
			selectAll();
			//�ڹٴ� auto Commit �ȴ�.
			//conn.commit();
			pstm = null;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	
	//update
	
	public void update() {
		
		System.out.println("����� ��ġ�� �����ʴϱ�?");
		int num=sc.nextInt();
		
		//dcode,Dname,Pdept,Area
		System.out.println("������ ��ġ�ðڽ��ϱ�? 1.Dcode,2.Dname,3.Pdept,4.Area 5.��ü");
		int select=sc.nextInt();
		try {
			if(select==1) {
				System.out.println("�ٲٰ���� Dcode�� �Է����ּ���");
				dcode=sc.next();
			sql="update dept2 set dcode=? where dcode="+num;
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, dcode);
			pstm.executeUpdate();
			System.out.println(dcode+"���� �����Ϸ��");
			
			}else if(select==2) {
				System.out.println("�ٲٰ���� Dname�� �Է����ּ���");
				Dname=sc.next();
				sql="update dept2 set Dname =? where dcode="+num;
				pstm=conn.prepareStatement(sql);
				pstm.setString(2, Dname);
				pstm.executeUpdate();
			
				System.out.println(Dname+"���� �����Ϸ��");
			}else if(select==3) {
				System.out.println("�ٲٰ���� Pdept�� �Է����ּ���");
				Pdept=sc.next();
				sql="update dept2 set Pdetp=? where dcode="+num;
				pstm=conn.prepareStatement(sql);
				pstm.setString(3, Pdept);
				pstm.executeUpdate();
				
				System.out.println(Pdept+"���� ���� �Ϸ��");
			}else if(select==4) {
				System.out.println("Aread�� �Է����ּ���");
				Area=sc.next();
				sql="update dept2 set Area=? where dcode="+num;
				pstm=conn.prepareStatement(sql);
				pstm.setString(4, Area);
				
				System.out.println(Area+"���� ���� �Ϸ��");
				
			}else if(select==5) {
				System.out.println("�ٲٰ� ���� dcode,dname,Pdept,Area�� ������� �Է����ּ���");
				dcode=sc.next();
				Dname=sc.next();
				Pdept=sc.next();
				Area=sc.next();
				sql="update dept2 set dcode=?,dname=?,Pdept=?,Area=? wherw dcode="+num;
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, dcode);
				pstm.setString(2, Dname);
				pstm.setString(3, Pdept);
				pstm.setString(4, Area);
				pstm.executeUpdate();
				
				//�������� sql�����ٰ�  +������ + ���� �Է�.
				
				System.out.println("���� �Ϸ�ƽ��ϴ�.");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		
		
		
	}
	
	public void delete() {
		
		try {
			selectAll();
			System.out.println("�����Ͻ� ��ȣ��?");
			int num=sc.nextInt();
			sql = "delete table DEPT2 "+num;
			pstm = conn.prepareStatement(sql);   
			pstm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	

	
	public    void connect(){
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,uid,pw);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public void close() {
		try {
			if(rs!=null)rs.close();
			if(pstm!=null)pstm.close();
			if(rs!=null)rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
