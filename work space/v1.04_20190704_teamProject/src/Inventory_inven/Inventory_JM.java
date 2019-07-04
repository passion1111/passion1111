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
		
		//객체화 부분
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
		//	System.out.println("잘못된 값을 입력하였습니다. 똑바로 쓰세요!");
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
			
			
			 // 쿼리문장 클래스의 업데이트 기능을 실행
			
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
	 * //객체화 부분 Inventory_JM me = new Inventory_JM(); Scanner sc = new
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
	 * System.out.println("잘못된 값을 입력하였습니다. 똑바로 쓰세요!"); //selection =
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
	 * // 쿼리문장 클래스의 업데이트 기능을 실행
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
		}//필드이름 출력 for end
		System.out.println();
			
		
		while( rs.next() ) {
				for (int i = 0; i < cols; i++) {
					System.out.print(rs.getObject(i+1)+"\t");
				}//필드row값 출력  for end
				
		}//while end
		

	}//select end
		

	

	public void update(PreparedStatement pstmt, Connection conn) throws SQLException, InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\n재고수량을 수정할 상품이름을 입력하세요 \n상품명 : ");
		String p = sc.nextLine();
		int a;
		do {
			System.out.print("재고수량 : ");
		
			
			while(!sc.hasNextInt()) {
			System.out.println("재고수량을 숫자로 입력해 주세요.");
			sc.next();
			}
			a=sc.nextInt();
			if(a<0)System.out.println("재고수량을 양수로 입력해주세요.");
		}while(a<0); //유효성검사
		
		pstmt = conn.prepareStatement("UPDATE STOCK SET "+p+"=?");
		pstmt.setInt(1, a);
		conn.setAutoCommit(false);
		pstmt.executeUpdate();
		System.out.println("변경사항을 저장하시겠습니까?\n예[Y] 아니오[N]");
		confirmModification(conn);
		pstmt.close();
	

	}

	public void delete(PreparedStatement pstmt, Connection conn) throws SQLException, InterruptedException {
			Scanner sc = new Scanner(System.in);
			
			System.out.print("재고목록에서 삭제할 상품이름을 입력하세요. \n상품명 : ");
			String p = sc.next();
		
			pstmt = conn.prepareStatement("alter table stock drop column "+p);	
			System.out.println("재고테이블에서 삭제한 데이터는 메뉴판에서도 지워집니다. 계속하시겠습니까?\n예[Y] 아니오[N]");
			String sel = sc.next();
			if(sel.equalsIgnoreCase("y")) {
			pstmt.executeUpdate();
			System.out.println("\n재고항목 삭제 성공!\n");
			pstmt = conn.prepareStatement("DELETE BEVERAGE WHERE BVRNAME= " + "'" + p + "'");
//			conn.setAutoCommit(false);
			pstmt.executeUpdate();
			}else {
				System.out.println("작업 취소!");
			}
			pstmt.close();
					
		
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
		}//while end
	}
	
	

}