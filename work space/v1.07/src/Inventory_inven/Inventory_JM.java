package Inventory_inven;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import DBconnector.DBconnectmng;



public class Inventory_JM {

	public Inventory_JM() throws InterruptedException, ClassNotFoundException, SQLException {
		makeedit();
	}
	
	//������
	private void makeedit() throws InterruptedException, ClassNotFoundException, SQLException {
		System.out.println("Inventory Manager Initializing 1 ");
		Thread.sleep(500);
		
		PreparedStatement pstmt = null;
		
		
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
			
			

			switch (k) {//�Է¹��� ���ڿ� �´� �޴��� �������� switch

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
			
			
			pstmt = null;
		}
		
	}


public void select(PreparedStatement pstmt, Connection conn) throws SQLException {// PreparedStatement pstmt

	
		
		pstmt = conn.prepareStatement("SELECT * FROM STOCK order by 1");
		ResultSet rs = pstmt.executeQuery();
		System.out.println("\nbvrno"+"\t"+"bvrname"+"\t"+"amount\n");
		while( rs.next() ) {
			
			System.out.print(rs.getInt("bvrno")+"\t"+rs.getString("bvrname")+"\t"+rs.getInt("amount")+"\n");
		}
	}


	public void update(PreparedStatement pstmt, Connection conn) throws SQLException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.print("\n�������� ������ ��ǰ�̸��� �Է��ϼ��� \n��ǰ�� : ");
		String p = sc.nextLine();
	
				while (true) {
					String sql = "SELECT * FROM BEVERAGE";
					pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();

					int cnt = 0;
					while (rs.next()) {//��ǰ�̸��˻��� ���� ���� �Ǵ�.
						if (p.equals(rs.getString("bvrname"))) {
							cnt++;
						}
					}if (cnt == 0) {
						System.out.println("�������� �ʴ� ��ǰ�̸��Դϴ�.\n");
						Thread.sleep(1500);
						System.out.print("���ο� ���� �Է����ּ���\n��ǰ�� : ");
						p = sc.next();
					} else {
						int a;
						do {
							System.out.print("������ : ");
						
							
							while(!sc.hasNextInt()) {
							System.out.println("�������� ���ڷ� �Է��� �ּ���.");
							sc.next();
							}
							a=sc.nextInt();
							if(a<0)System.out.println("�������� ����� �Է����ּ���.");
						}while(a<0); 
						
						pstmt = conn.prepareStatement("UPDATE STOCK SET amount = ? where bvrname = '"+p+"'");
						pstmt.setInt(1, a);
						conn.setAutoCommit(false);
						pstmt.executeUpdate();
						System.out.println("���� �Ŀ��� ������ �Ұ����մϴ�. ��� �����Ͻðڽ��ϱ�? ��[Y] �ƴϿ�[N]");
						confirmModification(conn);
						pstmt.close();
						break;
					}
				}
	}//end update

	public void delete(PreparedStatement pstmt, Connection conn) throws SQLException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("����Ͽ��� ������ ��ǰ�̸��� �Է��ϼ���. \n��ǰ�� : ");
		String p = sc.next();

		while (true) {
			String sql = "SELECT * FROM BEVERAGE";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			int cnt = 0;
			while (rs.next()) {
				if (p.equals(rs.getString("bvrname"))) {
					cnt++;
				}
			}
			if (cnt == 0) {
				System.out.println("�������� �ʴ� ��ǰ�̸��Դϴ�.\n");
				Thread.sleep(1500);
				System.out.print("���ο� ���� �Է����ּ���\n��ǰ�� : ");
				p = sc.next();
			} else {
		
		
		
		pstmt = conn.prepareStatement("delete stock where bvrname = ?");
		pstmt.setString(1, p);
		pstmt.executeUpdate();
		System.out.println("\n����׸� ���� ����!\n");
		pstmt = conn.prepareStatement("DELETE BEVERAGE WHERE BVRNAME= " + "'" + p + "'");
		conn.setAutoCommit(false);
		pstmt.executeUpdate();
		System.out.println("���� �Ŀ��� ������ �Ұ����մϴ�. ��� �����Ͻðڽ��ϱ�? ��[Y] �ƴϿ�[N]");
		confirmModification(conn);
		pstmt.close();
		break;
			}
		
		}
	
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
		}
	}
	
	

}