package MenuManager_dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import DBconnector.DBconnectmng;


public class MenuManager {//�����ڸ�忡�� �޴��� ��ȸ/�߰�/����/���� �ϴ� Ŭ����
	static String url=null;
	static String uid=null;
	static String pwd=null;
	static Connection conn = null;
	
	Scanner sc = new Scanner(System.in);	
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	
	
	
	//------------------------------������ ������ �޼ҵ�
	static Connection getConnection() {
		conn=new DBconnectmng().getConnection();
		return conn;	
	}//END getConnection();
	
	//------------------------------ DB������ �����ִ� �޼ҵ� ����
	static void close() {
		try {
			conn.close();
			System.out.println("������ �����Ǿ����ϴ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//------------------------------ ��ü��ȸ �޼ҵ� ����
	public void list() throws SQLException {
		String sql = " SELECT * FROM BEVERAGE ORDER BY BVRNO";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

		try {
			while (rs.next()) {
				System.out.printf("%s%02d%s%6s%s%4d%s", "[", rs.getInt("bvrno"), "] ", rs.getString("bvrname"), " : ",
						rs.getInt("price"), "��\n");	
			}
		} catch (Exception e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}
	
	//------------------------------ �޴��߰� ����
	public void addMenu() throws InterruptedException {// ������ �޴� �߰�
		try {
			int bvrno, price;
			String bvrname;
			list();
			while (true) {
				System.out.println("�޴��� �߰��մϴ�.");
				System.out.println("��ǰ��ȣ �Է� : ");
				while (!sc.hasNextInt()) {
					System.out.println("\n���ڷ� �ٽ� �Է��ϼ��� :");
					sc.next();
				}
				bvrno = sc.nextInt();
				
				System.out.println("��ǰ�̸� �Է� : ");
				bvrname = sc.next();

				
				int temp; 
				do {
					System.out.println("����  �Է� : ");
					while (!sc.hasNextInt()) {
						System.out.println("��Ȯ�� ������ �Է����ּ���");
						Thread.sleep(2000);
						System.out.println("����  �Է� : ");
						sc.next();
					}
					temp = sc.nextInt();
					if (temp <= 0) {
						System.out.println("��Ȯ�� ������ �Է����ּ���.");
						Thread.sleep(2000);
					}
				} while (temp <= 0);
				price = temp;

				// �̸��� �ߺ��Ǹ� �ɷ��ִ� �ڵ�
				String sql = "SELECT * FROM BEVERAGE";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				int cnt = 0;
				while (rs.next()) {
					if (bvrname.equals(rs.getString("bvrname"))) {
						cnt++;
					}
				}
				if (cnt > 0) {
					System.out.println("�̹� �����ϴ� �޴��Դϴ�.\n");
					Thread.sleep(1500);
				} else
					break;
			} // �ߺ� Ȯ��.

			//�޴��߰� ����
			String sql = "INSERT INTO BEVERAGE (BVRNO, BVRNAME, PRICE) VALUES(" + bvrno + "," + "'" + bvrname + "'"
					+ "," + price + ")";
			pstmt = conn.prepareStatement(sql);
			conn.setAutoCommit(false);
			pstmt.executeUpdate();
			System.out.println("�Է��� �����͸� �߰��Ͻðڽ��ϱ�? ��[Y] �ƴϿ�[N]");
			String msg=confirmModification();
			if(msg.equals("y")) {
//			stock ���̺� ����ȭ�κ�
				pstmt = conn.prepareStatement("INSERT INTO stock (BVRNO, BVRNAME, AMOUNT) VALUES(" + bvrno + "," + "'" + bvrname + "'"
						+ ", 10 )");
				pstmt.executeUpdate();
				System.out.println("������̺� ����ȭ �Ϸ�");
//			����ȭ�κ� ��
				
			}
		} catch (SQLIntegrityConstraintViolationException e) { 
			System.out.println("�޴��ڵ�� �ߺ��� �� �����ϴ�.");
			Thread.sleep(2000);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}// end addMenu();
	
	//------------------------------ �޴����� ����
	public void modifyMenu() {
		try {
			list();
			int sel;
			while (true) {
				System.out.print("������ �޴��� ��ȣ �Է� :  ");

				while (!sc.hasNextInt()) {
					System.out.println("�߸� �Է��ϼ̽��ϴ�. �޴���ȣ�� �ٽ� �Է����ּ���\n");
					Thread.sleep(2000);
					System.out.print("������ �޴��� ��ȣ �Է� :  ");
					sc.next();
				}sel=sc.nextInt();

				// ���� �ڵ带 �Է��ϸ� �ǵ��������� �ڵ�
				String sql = "SELECT * FROM BEVERAGE";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				int cnt = 0;
				while (rs.next()) {
					if (sel==rs.getInt("bvrno")) {
						cnt++;
					}
				}
				if (cnt == 0) {
					System.out.println("�޴���ȣ�� �������� �ʽ��ϴ�.\n");
					Thread.sleep(1500);
				} else
					break;
			}
			//������ �޴� ���� �Ϸ�------//
			
			
			
			System.out.print("������ �ʵ带 ��ȣ�� �Է����ּ���(<1> ��ǰ��ȣ  <2> ��ǰ�̸�  <3> ����)");
			int field;
			do {
				while (!sc.hasNextInt()) {
					System.out.println("�޴��� �ִ� ���ڸ� �Է��� �� �ֽ��ϴ�. �ٽ� �Է����ּ���.\n");
					Thread.sleep(2000);
					System.out.println("<1> ��ǰ��ȣ  <2> ��ǰ�̸�  <3> ����");
					sc.next();
				}
				field = sc.nextInt();
				if (field < 1 || field > 3) {
					System.out.println("�޴��� �ִ� ���ڸ� �Է��� �� �ֽ��ϴ�. �ٽ� �Է����ּ���.");
					Thread.sleep(2000);
					System.out.println("<1> ��ǰ��ȣ  <2> ��ǰ�̸�  <3> ����");
				}
			} while (field < 1 || field > 3);	

//			�Է¹��� ���ڿ� �´� db�ʵ������ ��������.
			String fName = "";
			switch (field) {
			case 1:
				fName = "bvrno";
				break;
			case 2:
				fName = "bvrname";
				break;
			case 3:
				fName = "price";
				break;
			}//switch end
			
			if (fName.equalsIgnoreCase("bvrname")) {// �̸������� ���, �ߺ� �ɷ��ִ� �ڵ�
				System.out.println("���ο� �̸��� �Է����ּ���");
				String temp = sc.next();
				while (true) {
					
					String sql = "SELECT * FROM BEVERAGE";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();

					int cnt = 0;
					while (rs.next()) {
						if (temp.equals(rs.getString("bvrname"))) {
							cnt++;
						}
					}
					if (cnt > 0) {
						System.out.println("�̹� �����ϴ� �޴��̸��Դϴ�.\n");
						Thread.sleep(1500);
						System.out.print("���ο� ���� �Է����ּ���");
						temp = sc.next();
					} else {
						pstmt = conn.prepareStatement("UPDATE BEVERAGE SET " + fName + " = ? WHERE bvrno = " + sel);
						pstmt.setString(1, temp);
						conn.setAutoCommit(false);
						pstmt.executeUpdate();
						break;
					}
				}
			} 
				
			else if (fName.equals("bvrno")) {// ��ǰ��ȣ ������ ��� ��ȿ�� �� ���Ἲ üũ
				while (true) {
					try {
						System.out.println("��ǰ��ȣ �Է� : ");
						while (!sc.hasNextInt()) {
							System.out.println("\n���ڷ� �ٽ� �Է��ϼ��� :");
							sc.next();
						}
						int tmp = sc.nextInt();
						pstmt = conn.prepareStatement("UPDATE BEVERAGE SET " + fName + " = ? WHERE bvrno = " + sel);
						pstmt.setInt(1, tmp);
						conn.setAutoCommit(false);
						pstmt.executeUpdate();
						break;
					} catch (SQLIntegrityConstraintViolationException e) {
						System.out.println("�޴���ȣ�� �ߺ��� �� �����ϴ�.");
						Thread.sleep(2000);
					}
				} 				
			}//��ǰ��ȣ ���� �Ϸ�
				
				
			else if (fName.equals("price")) {// ���� ������ ��� ��ȿ�� üũ
				int tmp=0;
				while (true) {
					do {
						System.out.println("���� �Է� : ");
						while (!sc.hasNextInt()) {
							System.out.println("\n��Ȯ�� ������ �Է����ּ���:");
							Thread.sleep(2000);
							System.out.println("����  �Է� : ");
							sc.next();
						}
						tmp = sc.nextInt();
						if(tmp<=0) {
							System.out.println("��Ȯ�� ������ �Է����ּ���.");
							Thread.sleep(2000);
						}
					}while(tmp<=0);
						pstmt = conn.prepareStatement("UPDATE BEVERAGE SET " + fName + " = ? WHERE bvrno = " + sel);
						pstmt.setInt(1, tmp);
						conn.setAutoCommit(false);
						pstmt.executeUpdate();
						break;
				} 			
			}//���� ���� üũ �Ϸ�

			System.out.println("���������� �����Ͻðڽ��ϱ�? ��[Y] �ƴϿ�[N]");
			confirmModification();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}//END modifyMenu();

	//------------------------------ �޴�����
	public void deleteMenu() {
		try {
			list();
			int num=0;
			while (true) {
				System.out.print("������ �޴��� ��ȣ �Է� :  ");

				while (!sc.hasNextInt()) {
					System.out.println("�߸� �Է��ϼ̽��ϴ�. �޴���ȣ�� �ٽ� �Է����ּ���\n");
					Thread.sleep(2000);
					System.out.print("������ �޴��� ��ȣ �Է� :  ");
					sc.next();
				}num=sc.nextInt();

				
				String sql = "SELECT * FROM BEVERAGE";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				int cnt = 0;
				while (rs.next()) {
					if (num==rs.getInt("bvrno")) {
						cnt++;
					}
				}
				if (cnt == 0) {
					System.out.println("�޴���ȣ�� �������� �ʽ��ϴ�.\n");
					Thread.sleep(1500);
				} else
					break;
			}
			pstmt = conn.prepareStatement("DELETE BEVERAGE WHERE BVRNO= " + num);
			conn.setAutoCommit(false);
			pstmt.executeUpdate();

			System.out.println("���� �Ŀ��� ������ �Ұ����մϴ�. ��� �����Ͻðڽ��ϱ�? ��[Y] �ƴϿ�[N]");
			confirmModification();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//------------------------------------------------ commit/rollback ����
	public String confirmModification() throws SQLException, InterruptedException {
		String msg="";
		while (true) {
			String sel = sc.next();
			if (sel.equalsIgnoreCase("y")) {
				conn.commit();
				msg="y";
				System.out.println("������� ���� �Ϸ�!");
				break;
			} else if (sel.equalsIgnoreCase("n")) {
				conn.rollback();
				System.out.println("�۾� ���!");
				break;
			} else {
				System.out.print("�߸� �Է��ϼ̽��ϴ�.�ٽ� �Է����ּ���.");
				Thread.sleep(1500);
				System.out.println("��������� �����Ͻðڽ��ϱ�? ��[Y] �ƴϿ�[N]");
			}
		} 
		return msg;
	}
}
