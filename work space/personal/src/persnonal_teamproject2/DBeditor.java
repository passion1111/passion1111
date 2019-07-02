package persnonal_teamproject2;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBeditor {
	static Scanner scan = new Scanner(System.in);
	//

	public static void main(String[] args)

			throws ClassNotFoundException, SQLException {
		String k ,sql;
		sql = k = null;
		PreparedStatement pstmt = null;
		DBeditor me = new DBeditor();

		// ↓ 이것도 가능 Class.forName("oracle.driver.jdbc.OracleDriver");
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("driver load sucess"); // 이부분수정
		// 2. Connection & Open
		// driver : @IP:portnumber:sid(or전역데이터베이스명)
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String uid = "kim";
		String pwd = "oracle";

		Connection conn = DriverManager.getConnection(url, uid, pwd); // 이 부분은 데이터베이스랑 연결되는 부분
		System.out.println("connection sucess");

		while (true) {
			  // 쿼리문 통합 클래스 (셀렉트 > stmt.executequery / 인서트,업데이트,딜리트 >
																// stmt.excuteUpdate

			me.select(pstmt,conn);

			System.out.println("\n시작할 기능을 고르시오.\n 1.추가 2.수정 3.삭제 4.종료");

			k = scan.nextLine();
			while(!k.equalsIgnoreCase("1")&&!k.equalsIgnoreCase("2")&&
					!k.equalsIgnoreCase("3")&&!k.equalsIgnoreCase("4")){
				System.out.println("1~4 사이의 기능을 선택하세요");
				k=scan.nextLine();
			}
			

			switch (k) {

			case "1":
				me.insert(pstmt, conn); 
				break;
			case "2":
				me.update(pstmt, conn);
				break;
			case "3":
				me.delete(pstmt, conn);
				break;
			case "4":
				System.out.println("프로그램을 종료합니다 ");
				conn.close(); 
				System.exit(0);
				break;

			}
			
			 // 쿼리문장 클래스의 업데이트 기능을 실행
			pstmt = null;
		} // while end

	}

	public void insert(PreparedStatement pstmt, Connection conn) throws SQLException {
		pstmt = null;
		System.out.println("번호 입력 :"); // gno
		String gno = scan.next();
		System.out.println("상품명 입력"); // gname
		String gname = scan.next();
		System.out.println("가격 입력"); // g_start
		String g_start = scan.next();
		System.out.println("가격2 입력"); // g_end
		String g_end = scan.next();

		String sql = "INSERT INTO GIFT VALUES( ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, gno);
		pstmt.setString(2, gname);
		pstmt.setString(3, g_start);
		pstmt.setString(4, g_end);
		pstmt.executeUpdate(); //여기 추가 부분
		
		System.out.println("데이터 추가 성공!");
		pstmt.close();
		

	}


	public void select(PreparedStatement pstmt, Connection conn) throws SQLException {// PreparedStatement pstmt

		System.out.println("상품번호\t상품명\t최저가\t최고가");
		pstmt = conn.prepareStatement("SELECT * FROM GIFT");
		ResultSet rs = pstmt.executeQuery("SELECT * FROM GIFT"); // 리절트셋 클래스로 셀렉트한 데이터를 담을 곳을 만들고 stmt.executeQuery로
									// 실행한다
//		pstmt = conn.prepareStatement("select*from dept2");
//		rs = pstmt.executeQuery();
//		System.out.println("\n dcode \t\t dname\t\t pdept \t\t area");

		try {
			while (rs.next()) { // rs에서 가져온값이 있으면
				int gno = rs.getInt("gno");// or index number
				String gname = rs.getString("gname");
				int g_s = rs.getInt("g_start");
				int g_e = rs.getInt("g_end");

				System.out.println(gno + "\t" + gname + "\t" + g_s + "\t" + g_e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(PreparedStatement pstmt, Connection conn) throws SQLException {
		
		
		System.out.println("수정할 상품정보을 선택하세요 \n 1.gno 2.gname 3.g_start 4.g_end");
		int i = scan.nextInt();
		System.out.println("수정할 상품번호를 선택하세요");
		int j = scan.nextInt();

		int a = 0, c = 0, d = 0;

		String b = null;
		String sql = null;

		switch (i) {
		case 1:
			System.out.println("gno 입력");
			a = scan.nextInt();
			sql = "UPDATE GIFT SET GNO=? WHERE GNO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, a);
			pstmt.setInt(2, j);
			
			break;
		case 2:
			System.out.println("gname 입력");
			b = scan.next();
			sql = "UPDATE GIFT SET GNAME=? WHERE GNO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b);
			pstmt.setInt(2, j);
	
			break;
		case 3:
			System.out.println("g_start 입력");
			c = scan.nextInt();
			sql = "UPDATE GIFT SET G_START=? WHERE GNO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, c);
			pstmt.setInt(2, j);
			
			break;
		case 4:
			System.out.println("g_end 입력");
			d = scan.nextInt();
			sql = "UPDATE GIFT SET G_END=? WHERE GNO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, d);
			pstmt.setInt(2, j);
			
			break;

		}
		pstmt.executeUpdate();
		System.out.println("데이터 수정 성공!");
		pstmt.close();

	}

	public void delete(PreparedStatement pstmt, Connection conn) throws SQLException {

		System.out.println("gno 입력");
		int a = scan.nextInt();
		
		String sql = "DELETE GIFT WHERE GNO=?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, a);
		
		pstmt.executeUpdate();
		System.out.println("데이터 삭제 성공!");
		pstmt.close();

		// delete ※테이블명 where ※삭제칼럼명=※삭제값
	}

}