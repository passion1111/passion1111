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
	
	//재고수정
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
			
			

			switch (k) {//입력받은 숫자에 맞는 메뉴에 들어가기위한 switch

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
		System.out.print("\n재고수량을 수정할 상품이름을 입력하세요 \n상품명 : ");
		String p = sc.nextLine();
	
				while (true) {
					String sql = "SELECT * FROM BEVERAGE";
					pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();

					int cnt = 0;
					while (rs.next()) {//상품이름검색후 존재 유무 판단.
						if (p.equals(rs.getString("bvrname"))) {
							cnt++;
						}
					}if (cnt == 0) {
						System.out.println("존재하지 않는 상품이름입니다.\n");
						Thread.sleep(1500);
						System.out.print("새로운 값을 입력해주세요\n상품명 : ");
						p = sc.next();
					} else {
						int a;
						do {
							System.out.print("재고수량 : ");
						
							
							while(!sc.hasNextInt()) {
							System.out.println("재고수량을 숫자로 입력해 주세요.");
							sc.next();
							}
							a=sc.nextInt();
							if(a<0)System.out.println("재고수량을 양수로 입력해주세요.");
						}while(a<0); 
						
						pstmt = conn.prepareStatement("UPDATE STOCK SET amount = ? where bvrname = '"+p+"'");
						pstmt.setInt(1, a);
						conn.setAutoCommit(false);
						pstmt.executeUpdate();
						System.out.println("수정 후에는 복구가 불가능합니다. 계속 진행하시겠습니까? 예[Y] 아니오[N]");
						confirmModification(conn);
						pstmt.close();
						break;
					}
				}
	}//end update

	public void delete(PreparedStatement pstmt, Connection conn) throws SQLException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("재고목록에서 삭제할 상품이름을 입력하세요. \n상품명 : ");
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
				System.out.println("존재하지 않는 상품이름입니다.\n");
				Thread.sleep(1500);
				System.out.print("새로운 값을 입력해주세요\n상품명 : ");
				p = sc.next();
			} else {
		
		
		
		pstmt = conn.prepareStatement("delete stock where bvrname = ?");
		pstmt.setString(1, p);
		pstmt.executeUpdate();
		System.out.println("\n재고항목 삭제 성공!\n");
		pstmt = conn.prepareStatement("DELETE BEVERAGE WHERE BVRNAME= " + "'" + p + "'");
		conn.setAutoCommit(false);
		pstmt.executeUpdate();
		System.out.println("수정 후에는 복구가 불가능합니다. 계속 진행하시겠습니까? 예[Y] 아니오[N]");
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
				System.out.println("\n변경사항 저장 완료!\n");
				break;
			} else if (sel.equalsIgnoreCase("n")) {
				conn.rollback();
				System.out.println("작업 취소!");
				break;
			} else {
				System.out.print("잘못 입력하셨습니다.다시 입력해주세요." );
				Thread.sleep(1500);
				System.out.println("변경사항을 저장하시겠습니까? 예[Y] 아니오[N]");
			}
		}
	}
	
	

}