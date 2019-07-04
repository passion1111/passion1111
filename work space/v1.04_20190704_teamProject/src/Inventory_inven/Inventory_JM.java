package Inventory_inven;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import DBconnector.DBconnectmng;



public class Inventory_JM {

	public Inventory_JM() throws InterruptedException, ClassNotFoundException, SQLException {
		makeedit();
	}
	
	
	private void makeedit() throws InterruptedException, ClassNotFoundException, SQLException {
		System.out.println("Inventory Manager Initializing 1 ");
		Thread.sleep(500);
		
		PreparedStatement pstmt = null;
		
		//��üȭ �κ�
//		Inventory_JM this = new Inventory_JM();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Inventory Manager loading.");
		
		System.out.println("Inventory Manager loading...\n");
		Thread.sleep(500);
		
		Connection conn=new DBconnectmng().getConnection();
		
		System.out.print("I.M connection sucess!  \n\n$$$$$ Inventory mode $$$$$\n\n");

		boolean invenend=true;
		while (invenend) {
			
			String k=null;
			

			this.select(pstmt,conn);

			System.out.println("\n\nSelect functions.\n 1.Update 2.Delete 3.Exit");
			k = sc.next();
			while(!k.equalsIgnoreCase("1")&&!k.equalsIgnoreCase("2")&&
					!k.equalsIgnoreCase("3")){
			System.out.println("Please select numbers between 1~3...");
				k= sc.nextLine();
			}
			//while (!selection.equals("1") && !selection.equals("2")) {
		//	System.out.println("�߸��� ���� �Է��Ͽ����ϴ�. �ȹٷ� ������!");
			//selection = scan.nextLine();	}
			

			switch (k) {

			case "1":
				this.update(pstmt, conn);
				break;
			case "2":
				this.delete(pstmt, conn);
				break;
			case "3":
				System.out.println("$$$$$ Exit Inventory Manager mode $$$$$");
				conn.close(); 
				pstmt = null;
				invenend=false;
				break;
			

			}
			
			
			 // �������� Ŭ������ ������Ʈ ����� ����
			
			pstmt = null;
		} // while end
		
	}


	/*
	 * public static void makeedit throws ClassNotFoundException, SQLException,
	 * InterruptedException {
	 * System.out.println("Inventory Manager Initializing  "); Thread.sleep(500);
	 * 
	 * PreparedStatement pstmt = null;
	 * 
	 * //��üȭ �κ� Inventory_JM me = new Inventory_JM(); Scanner sc = new
	 * Scanner(System.in);
	 * 
	 * System.out.println("Inventory Manager loading."); Thread.sleep(500);
	 * Class.forName("oracle.jdbc.OracleDriver");
	 * System.out.println("Inventory Manager loading.."); Thread.sleep(500); String
	 * url = "jdbc:oracle:thin:@localhost:1521:lindswell"; String uid = "Lindswell";
	 * String pwd = "bit129"; System.out.println("Inventory Manager loading...\n");
	 * Thread.sleep(500); Connection conn = DriverManager.getConnection(url, uid,
	 * pwd);
	 * System.out.print("I.M connection sucess!  \n\n$$$$$ Inventory mode $$$$$\n\n"
	 * );
	 * 
	 * while (true) {
	 * 
	 * String k=null;
	 * 
	 * 
	 * me.select(pstmt,conn);
	 * 
	 * System.out.println("\n\nSelect functions.\n 1.Update 2.Delete 3.Exit"); k =
	 * sc.next(); while(!k.equalsIgnoreCase("1")&&!k.equalsIgnoreCase("2")&&
	 * !k.equalsIgnoreCase("3")){
	 * System.out.println("Please select numbers between 1~3..."); k= sc.nextLine();
	 * } //while (!selection.equals("1") && !selection.equals("2")) { //
	 * System.out.println("�߸��� ���� �Է��Ͽ����ϴ�. �ȹٷ� ������!"); //selection =
	 * scan.nextLine(); }
	 * 
	 * 
	 * switch (k) {
	 * 
	 * case "1": me.update(pstmt, conn); break; case "2": me.delete(pstmt, conn);
	 * break; case "3":
	 * System.out.println("$$$$$ Exit Inventory Manager mode $$$$$"); conn.close();
	 * System.exit(0); break;
	 * 
	 * 
	 * }
	 * 
	 * 
	 * // �������� Ŭ������ ������Ʈ ����� ����
	 * 
	 * pstmt = null; } // while end
	 * 
	 * }//main end
	 */


	public void select(PreparedStatement pstmt, Connection conn) throws SQLException {// PreparedStatement pstmt

		int row = 0, cols=0, r=0;
		String [] columnName;
		
		pstmt = conn.prepareStatement("SELECT * FROM STOCK");
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd=rs.getMetaData();
		cols = rsmd.getColumnCount();
		columnName = new String[cols];
		
		for (int i = 0; i < cols; i++) {
			System.out.print(rsmd.getColumnName(i+1)+"\t");
		}//�ʵ��̸� ��� for end
		System.out.println();
			
		
		while( rs.next() ) {
				for (int i = 0; i < cols; i++) {
					System.out.print(rs.getObject(i+1)+"\t");
				}//�ʵ�row�� ���  for end
				
		}//while end
		

	}//select end
		

	

	public void update(PreparedStatement pstmt, Connection conn) throws SQLException, InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\n�������� ������ ��ǰ�̸��� �Է��ϼ��� \n��ǰ�� : ");
		String p = sc.nextLine();
		int a;
		do {
			System.out.print("������ : ");
		
			
			while(!sc.hasNextInt()) {
			System.out.println("�������� ���ڷ� �Է��� �ּ���.");
			sc.next();
			}
			a=sc.nextInt();
			if(a<0)System.out.println("�������� ����� �Է����ּ���.");
		}while(a<0); //��ȿ���˻�
		
		pstmt = conn.prepareStatement("UPDATE STOCK SET "+p+"=?");
		pstmt.setInt(1, a);
		conn.setAutoCommit(false);
		pstmt.executeUpdate();
		System.out.println("��������� �����Ͻðڽ��ϱ�?\n��[Y] �ƴϿ�[N]");
		confirmModification(conn);
		pstmt.close();
	

	}

	public void delete(PreparedStatement pstmt, Connection conn) throws SQLException, InterruptedException {
			Scanner sc = new Scanner(System.in);
			
			System.out.print("����Ͽ��� ������ ��ǰ�̸��� �Է��ϼ���. \n��ǰ�� : ");
			String p = sc.next();
		
			pstmt = conn.prepareStatement("alter table stock drop column "+p);	
			System.out.println("������̺��� ������ �����ʹ� �޴��ǿ����� �������ϴ�. ����Ͻðڽ��ϱ�?\n��[Y] �ƴϿ�[N]");
			String sel = sc.next();
			if(sel.equalsIgnoreCase("y")) {
			pstmt.executeUpdate();
			System.out.println("\n����׸� ���� ����!\n");
			pstmt = conn.prepareStatement("DELETE BEVERAGE WHERE BVRNAME= " + "'" + p + "'");
//			conn.setAutoCommit(false);
			pstmt.executeUpdate();
			}else {
				System.out.println("�۾� ���!");
			}
			pstmt.close();
					
		
	}//delete end

	public void confirmModification(Connection conn) throws SQLException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String sel = sc.next();
			if (sel.equalsIgnoreCase("y")) {
				conn.commit();
				System.out.println("\n������� ���� �Ϸ�!\n");
				break;
			} else if (sel.equalsIgnoreCase("n")) {
				conn.rollback();
				System.out.println("�۾� ���!");
				break;
			} else {
				System.out.print("�߸� �Է��ϼ̽��ϴ�.�ٽ� �Է����ּ���." );
				Thread.sleep(1500);
				System.out.println("��������� �����Ͻðڽ��ϱ�? ��[Y] �ƴϿ�[N]");
			}
		}//while end
	}
	
	

}