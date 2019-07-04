package MenuManager_dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import DBconnector.DBconnectmng;


public class MenuManager {//관리자모드에서 메뉴를 조회/추가/수정/삭제 하는 클래스
	static String url=null;
	static String uid=null;
	static String pwd=null;
	static Connection conn = null;
	
	Scanner sc = new Scanner(System.in);	
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	
	
	
	//------------------------------연결을 얻어오는 메소드
	static Connection getConnection() {
		conn=new DBconnectmng().getConnection();
		return conn;	
	}//END getConnection();
	
	//------------------------------ DB연결을 끊어주는 메소드 시작
	static void close() {
		try {
			conn.close();
			System.out.println("연결이 해제되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//------------------------------ 전체조회 메소드 시작
	public void list() throws SQLException {
		String sql = " SELECT * FROM BEVERAGE ORDER BY BVRNO";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

		try {
			while (rs.next()) {
				System.out.printf("%s%02d%s%6s%s%4d%s", "[", rs.getInt("bvrno"), "] ", rs.getString("bvrname"), " : ",
						rs.getInt("price"), "원\n");	
			}
		} catch (Exception e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}
	
	//------------------------------ 메뉴추가 시작
	public void addMenu() throws InterruptedException {// 관리자 메뉴 추가
		try {
			int bvrno, price;
			String bvrname;
			list();
			while (true) {
				System.out.println("메뉴를 추가합니다.");
				System.out.println("제품번호 입력 : ");
				while (!sc.hasNextInt()) {
					System.out.println("\n숫자로 다시 입력하세요 :");
					sc.next();
				}
				bvrno = sc.nextInt();
				
				System.out.println("제품이름 입력 : ");
				bvrname = sc.next();

				
				int temp; 
				do {
					System.out.println("가격  입력 : ");
					while (!sc.hasNextInt()) {
						System.out.println("정확한 가격을 입력해주세요");
						Thread.sleep(2000);
						System.out.println("가격  입력 : ");
						sc.next();
					}
					temp = sc.nextInt();
					if (temp <= 0) {
						System.out.println("정확한 가격을 입력해주세요.");
						Thread.sleep(2000);
					}
				} while (temp <= 0);
				price = temp;

				// 이름이 중복되면 걸러주는 코드
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
					System.out.println("이미 존재하는 메뉴입니다.\n");
					Thread.sleep(1500);
				} else
					break;
			} // 중복 확인.

			//메뉴추가 쿼리
			String sql = "INSERT INTO BEVERAGE (BVRNO, BVRNAME, PRICE) VALUES(" + bvrno + "," + "'" + bvrname + "'"
					+ "," + price + ")";
			pstmt = conn.prepareStatement(sql);
			conn.setAutoCommit(false);
			pstmt.executeUpdate();
			System.out.println("입력한 데이터를 추가하시겠습니까? 예[Y] 아니오[N]");
			String msg=confirmModification();
			if(msg.equals("y")) {
//			stock 테이블 동기화부분
				pstmt = conn.prepareStatement("INSERT INTO stock (BVRNO, BVRNAME, AMOUNT) VALUES(" + bvrno + "," + "'" + bvrname + "'"
						+ ", 10 )");
				pstmt.executeUpdate();
				System.out.println("재고테이블 동기화 완료");
//			동기화부분 끝
				
			}
		} catch (SQLIntegrityConstraintViolationException e) { 
			System.out.println("메뉴코드는 중복될 수 없습니다.");
			Thread.sleep(2000);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}// end addMenu();
	
	//------------------------------ 메뉴수정 시작
	public void modifyMenu() {
		try {
			list();
			int sel;
			while (true) {
				System.out.print("수정할 메뉴의 번호 입력 :  ");

				while (!sc.hasNextInt()) {
					System.out.println("잘못 입력하셨습니다. 메뉴번호를 다시 입력해주세요\n");
					Thread.sleep(2000);
					System.out.print("수정할 메뉴의 번호 입력 :  ");
					sc.next();
				}sel=sc.nextInt();

				// 없는 코드를 입력하면 되돌려보내는 코드
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
					System.out.println("메뉴번호가 존재하지 않습니다.\n");
					Thread.sleep(1500);
				} else
					break;
			}
			//수정할 메뉴 선택 완료------//
			
			
			
			System.out.print("수정할 필드를 번호로 입력해주세요(<1> 제품번호  <2> 제품이름  <3> 가격)");
			int field;
			do {
				while (!sc.hasNextInt()) {
					System.out.println("메뉴에 있는 숫자만 입력할 수 있습니다. 다시 입력해주세요.\n");
					Thread.sleep(2000);
					System.out.println("<1> 제품번호  <2> 제품이름  <3> 가격");
					sc.next();
				}
				field = sc.nextInt();
				if (field < 1 || field > 3) {
					System.out.println("메뉴에 있는 숫자만 입력할 수 있습니다. 다시 입력해주세요.");
					Thread.sleep(2000);
					System.out.println("<1> 제품번호  <2> 제품이름  <3> 가격");
				}
			} while (field < 1 || field > 3);	

//			입력받은 숫자에 맞는 db필드명으로 변수저장.
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
			
			if (fName.equalsIgnoreCase("bvrname")) {// 이름수정일 경우, 중복 걸러주는 코드
				System.out.println("새로운 이름을 입력해주세요");
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
						System.out.println("이미 존재하는 메뉴이름입니다.\n");
						Thread.sleep(1500);
						System.out.print("새로운 값을 입력해주세요");
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
				
			else if (fName.equals("bvrno")) {// 제품번호 수정일 경우 유효성 및 무결성 체크
				while (true) {
					try {
						System.out.println("제품번호 입력 : ");
						while (!sc.hasNextInt()) {
							System.out.println("\n숫자로 다시 입력하세요 :");
							sc.next();
						}
						int tmp = sc.nextInt();
						pstmt = conn.prepareStatement("UPDATE BEVERAGE SET " + fName + " = ? WHERE bvrno = " + sel);
						pstmt.setInt(1, tmp);
						conn.setAutoCommit(false);
						pstmt.executeUpdate();
						break;
					} catch (SQLIntegrityConstraintViolationException e) {
						System.out.println("메뉴번호는 중복될 수 없습니다.");
						Thread.sleep(2000);
					}
				} 				
			}//제품번호 수정 완료
				
				
			else if (fName.equals("price")) {// 가격 수정일 경우 유효성 체크
				int tmp=0;
				while (true) {
					do {
						System.out.println("가격 입력 : ");
						while (!sc.hasNextInt()) {
							System.out.println("\n정확한 가격을 입력해주세요:");
							Thread.sleep(2000);
							System.out.println("가격  입력 : ");
							sc.next();
						}
						tmp = sc.nextInt();
						if(tmp<=0) {
							System.out.println("정확한 가격을 입력해주세요.");
							Thread.sleep(2000);
						}
					}while(tmp<=0);
						pstmt = conn.prepareStatement("UPDATE BEVERAGE SET " + fName + " = ? WHERE bvrno = " + sel);
						pstmt.setInt(1, tmp);
						conn.setAutoCommit(false);
						pstmt.executeUpdate();
						break;
				} 			
			}//가격 수정 체크 완료

			System.out.println("수정사항을 저장하시겠습니까? 예[Y] 아니오[N]");
			confirmModification();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}//END modifyMenu();

	//------------------------------ 메뉴삭제
	public void deleteMenu() {
		try {
			list();
			int num=0;
			while (true) {
				System.out.print("삭제할 메뉴의 번호 입력 :  ");

				while (!sc.hasNextInt()) {
					System.out.println("잘못 입력하셨습니다. 메뉴번호를 다시 입력해주세요\n");
					Thread.sleep(2000);
					System.out.print("삭제할 메뉴의 번호 입력 :  ");
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
					System.out.println("메뉴번호가 존재하지 않습니다.\n");
					Thread.sleep(1500);
				} else
					break;
			}
			pstmt = conn.prepareStatement("DELETE BEVERAGE WHERE BVRNO= " + num);
			conn.setAutoCommit(false);
			pstmt.executeUpdate();

			System.out.println("삭제 후에는 복구가 불가능합니다. 계속 진행하시겠습니까? 예[Y] 아니오[N]");
			confirmModification();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//------------------------------------------------ commit/rollback 선택
	public String confirmModification() throws SQLException, InterruptedException {
		String msg="";
		while (true) {
			String sel = sc.next();
			if (sel.equalsIgnoreCase("y")) {
				conn.commit();
				msg="y";
				System.out.println("변경사항 저장 완료!");
				break;
			} else if (sel.equalsIgnoreCase("n")) {
				conn.rollback();
				System.out.println("작업 취소!");
				break;
			} else {
				System.out.print("잘못 입력하셨습니다.다시 입력해주세요.");
				Thread.sleep(1500);
				System.out.println("변경사항을 저장하시겠습니까? 예[Y] 아니오[N]");
			}
		} 
		return msg;
	}
}
