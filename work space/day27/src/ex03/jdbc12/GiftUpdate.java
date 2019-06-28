package ex03.jdbc12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GiftUpdate {
	public GiftUpdate() throws ClassNotFoundException, SQLException{
		 Scanner sc=new Scanner(System.in);
		 int select;
		Class.forName("oracle.jdbc.OracleDriver"); // exception
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE" ;
		String uid = "kimkim";
		String pwd = "oracle";
		Connection conn = DriverManager.getConnection(url, uid, pwd); // exception
	
		//3. 사용( DML - select )
		Statement stmt = conn.createStatement();
		PreparedStatement pstmt = null;  ///////////////////////////
		ResultSet rs = stmt.executeQuery(" select * from gift ");	
		
		System.out.println("상품번호\t상품명\t최저가\t최고가"  ); 
		while( rs.next() ) {
			int gno = rs.getInt("gno");
			String gname = rs.getString("gname");
			int g_s = rs.getInt("g_start");
			int g_e = rs.getInt("g_end");
			
			System.out.println(gno + "\t" + gname + "\t" + g_s + "\t" + g_e ); 
		}// while end
		
		//////////////// 레코드 Update ////////////////////////////
		System.out.println("\n목록에서 Update 할 번호 ? ");
		int num = new Scanner(System.in).nextInt();
		
		
		System.out.println("무엇을 바꾸고 싶으십니까?  1.gno 2.gname 3.최저가격");
		do {
			while(!sc.hasNextInt()) {
				System.out.println("목록에 있는 숫자를 입력해주세요");
				sc.next();
			}
			
		select=sc.nextInt();
		}while(select>3||select<1);
		
		if(select==1){
		System.out.println("gno 를 바꾸시겠습니까? 몇번으로....? ");
		int gno = new Scanner(System.in).nextInt();
		pstmt = conn.prepareStatement("update gift set gno = ? where gno = " + num);
		pstmt.setInt(1, gno);
		pstmt.executeUpdate();  // 반환값이 없는 경우 - insert, update, delete
		System.out.println(gno +  " 수정 완료됨!!! ");
		}
		///------------------------------------------------------------------------//
		else if(select==2) {
		System.out.println("gname을 바꾸시겠습니까? 상품명 어떤걸로....? ");
		String gname = new Scanner(System.in).next();
		pstmt =  conn.prepareStatement("update gift set gname = ?  where gno = " + num) ;
		pstmt.setString(1, gname);
		pstmt.executeUpdate();
		System.out.println(gname + " 수정 완료됨!! ");
		}
		///------------------------------------------------------------------------//
		else if(select==3) {
		System.out.println("최저가격을 바꾸시겠습니까? 얼마....? ");
		String g_start = new Scanner(System.in).next();
		pstmt =  conn.prepareStatement("update gift set g_start = ? , g_end=?, gname =?  where gno = " + num) ;
		pstmt.setString(1, g_start);
		pstmt.setInt(2, 20);
		pstmt.setString(3, "kingsmile");
		pstmt.executeUpdate();
		System.out.println(g_start + " 수정 완료됨!! ");
		}
		///------------------------------------------------------------------------//
		rs = stmt.executeQuery("select * from gift");
		System.out.println("상품번호\t상품명\t최저가\t최고가"  ); 
		while( rs.next() ) {
		    int gno = rs.getInt("gno");
		    String gname = rs.getString("gname");
			int g_s = rs.getInt("g_start");
			int g_e = rs.getInt("g_end");
			
			System.out.println(gno + "\t" + gname + "\t" + g_s + "\t" + g_e ); 
		}// while end
	}
}

