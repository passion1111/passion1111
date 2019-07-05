package Kiosk_DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DBconnector.DBconnectmng;
import Kiosk_main.CancelMenu;
import Kiosk_main.Menu;

public class KioskDBManager {
	static String url = null;
	static String uid = null;
	static String pwd = null;
	static Connection conn = null;

	Scanner sc = new Scanner(System.in); // ��� �� �͵鵵 ���⿡ ����
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	

	public static Connection getConnection() {// ������ ������ �޼ҵ�
		conn=new DBconnectmng().getConnection();
		return conn;
	}

	public ArrayList addlist() throws SQLException { // ���� DB�� �ִ� ��ü �޴��� �ѷ���

		ArrayList<Menu> menupan = new ArrayList<Menu>();
		String sql = " SELECT * FROM BEVERAGE ORDER BY BVRNO";// �����Ͱ� ��ǰ��ȣ ������ ���ĵ��� �ʾƼ� �� ����... order by ���
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

		try {
			while (rs.next()) {
				menupan.add(new Menu(rs.getString("bvrname"), rs.getInt("price")));
			}

		} catch (Exception e) {
			System.out.println("SQLException: " + e.getMessage());
		}
		return menupan;
	}

	public int getjumunnum() throws SQLException { // ���� DB�� �ִ� ��ü �޴��� �ѷ���

		String sql = " SELECT jumunNO FROM jumunnum ORDER BY jumunNO";// �����Ͱ� ��ǰ��ȣ ������ ���ĵ��� �ʾƼ� �� ����... order by ���
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

		int jumunno = 0;

		try {
			while (rs.next()) {
				jumunno = rs.getInt("jumunno");

			}
			if (jumunno == 0) {
				jumunno = 100;
			} else {
				jumunno++;
			}
			insertjumunnum(jumunno);
			pstmt = null;

		} catch (Exception e) {
			System.out.println("SQLException: " + e.getMessage());
		}
		return jumunno;
	}

	public void insertjumunnum(int jumunno) {
		String sql = " insert  into jumunnum (jumunNO) values (?)";// �����Ͱ� ��ǰ��ȣ ������ ���ĵ��� �ʾƼ� �� ����... order by ���

		try {
			pstmt = conn.prepareStatement(sql);
			String no = String.valueOf(jumunno);// �̷��� �ؾ��� ������ �𸣰���
			pstmt.setString(1, no);

			int rsu = pstmt.executeUpdate();

			System.out.println(rsu + "�� �ֹ���ȣ �Է¼���");

		} catch (Exception e) {
			System.out.println("SQLException: " + e.getMessage());
		}

	}

	public void breakdown(ArrayList arr, int no) {
		String brkdown = "";
		for (int i = 0; i < arr.size(); i++) {
			CancelMenu m = (CancelMenu) arr.get(i);
			brkdown += " �޴�:" + m.getMenuname() + "�ֹ�����:" + m.getAmount() + ",";
		}

		String sql = "update jumunnum set jumunbreakdown= ? where jumunNO=?";
		try {
			pstmt = conn.prepareStatement(sql);
			String no2 = String.valueOf(no);// �̷��� �ؾ��� ������ �𸣰���
			pstmt.setString(1, brkdown);
			pstmt.setString(2, no2);

			int rsu = pstmt.executeUpdate();

			System.out.println(rsu + "�� �ֹ����� �Է¼���");

		} catch (Exception e) {
			System.out.println("SQLException: " + e.getMessage());
		}

	}

}
