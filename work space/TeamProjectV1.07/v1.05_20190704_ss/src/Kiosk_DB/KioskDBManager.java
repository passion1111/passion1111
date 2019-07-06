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

	Scanner sc = new Scanner(System.in); // 계속 쓸 것들도 여기에 선언
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	

	public static Connection getConnection() {// 연결을 얻어오는 메소드
		conn=new DBconnectmng().getConnection();
		return conn;
	}

	public ArrayList addlist() throws SQLException { // 현재 DB에 있는 전체 메뉴를 뿌려줌

		ArrayList<Menu> menupan = new ArrayList<Menu>();
		String sql = " SELECT * FROM BEVERAGE ORDER BY BVRNO";// 데이터가 제품번호 순으로 정렬되지 않아서 안 예쁨... order by 사용
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

	public int getjumunnum() throws SQLException { // 현재 DB에 있는 전체 메뉴를 뿌려줌

		String sql = " SELECT jumunNO FROM jumunnum ORDER BY jumunNO";// 데이터가 제품번호 순으로 정렬되지 않아서 안 예쁨... order by 사용
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
		String sql = " insert  into jumunnum (jumunNO) values (?)";// 데이터가 제품번호 순으로 정렬되지 않아서 안 예쁨... order by 사용

		try {
			pstmt = conn.prepareStatement(sql);
			String no = String.valueOf(jumunno);// 이렇게 해야함 이유는 모르겟음
			pstmt.setString(1, no);

			int rsu = pstmt.executeUpdate();

			System.out.println(rsu + "개 주문번호 입력성공");

		} catch (Exception e) {
			System.out.println("SQLException: " + e.getMessage());
		}

	}

	public void breakdown(ArrayList arr, int no) {
		String brkdown = "";
		for (int i = 0; i < arr.size(); i++) {
			CancelMenu m = (CancelMenu) arr.get(i);
			brkdown += " 메뉴:" + m.getMenuname() + "주문수량:" + m.getAmount() + ",";
		}

		String sql = "update jumunnum set jumunbreakdown= ? where jumunNO=?";
		try {
			pstmt = conn.prepareStatement(sql);
			String no2 = String.valueOf(no);// 이렇게 해야함 이유는 모르겟음
			pstmt.setString(1, brkdown);
			pstmt.setString(2, no2);

			int rsu = pstmt.executeUpdate();

			System.out.println(rsu + "개 주문내역 입력성공");

		} catch (Exception e) {
			System.out.println("SQLException: " + e.getMessage());
		}

	}

}
