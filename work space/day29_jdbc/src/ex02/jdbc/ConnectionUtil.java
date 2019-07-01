package ex02.jdbc;
import java.sql.*;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;



public class ConnectionUtil {
	private static final String driver="oracle.jdbc.OracleDriver";
	private static final String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String uid="kim";
	String pw="oracle";
	Scanner sc=new Scanner(System.in);
	PreparedStatement pstm=null;
	Connection conn=null;
	ResultSet rs=null;
	String sql=null;
	String dcode,Dname,Pdept,Area;
	
	
	
	
	
	
	
	
	//menu
	public static void menu() {
		System.out.println("\n================ JDBC query=========");
		System.out.println("\t 1.레코드삽입 ");
		System.out.println("\t 2.레코드수정 ");
		System.out.println("\t 3.전체보기 ");
		System.out.println("\t 4.레코드삭제 ");
		System.out.println("\t 5.원하는 부서번호 검색 ");
		System.out.println("\t 6.시스템 종료");
		System.out.println("원하는 메뉴 숫자 입력 ");
		
	
	
	}
	
	
	//select()
	public void selectAll() throws SQLException {
		pstm=conn.prepareStatement("select*from dept2"); //이 명령어가 실행될떄 실제데이터베이스가 실행할떄
		rs=pstm.executeQuery();//반환값이 있으므로
		System.out.println("\n Dcode \t dname \t pdept \t area");
		while(rs.next()) {
			System.out.print(rs.getString(1) +"\t");
			System.out.print(rs.getString(2) +"\t");
			System.out.print(rs.getString(3)+"\t");
			System.out.print(rs.getString(4)+"\t \n");
			
		}
		
	}
	
	
	public void select(int select) {
		
		try {
			
			sql="select * from dept2 where dcode="+select;
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			System.out.println("\n Dcode \t dname \t Pdept \t Area");
			while(rs.next()) {
				System.out.print(rs.getString(1) +"\t");
				System.out.print(rs.getString(2) +"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString(4)+"\t \n");
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
	}
	
	//insert()
	
	public void insert() throws SQLException {
		
		System.out.println("Dcode: ");
		dcode=sc.next();
		
		System.out.println("Dname: ");
		Dname=sc.next();
		
		System.out.println("Pdept: ");
		Pdept=sc.next();
		
		System.out.println("Area: ");
		Area=sc.next();
		
		
		try {
			

			sql = "INSERT INTO DEPT2 VALUEs( ?, ?, ?, ? )";
			pstm = conn.prepareStatement(sql);     // pstmt.setXXX( 순번, 값 );
			pstm.setString(1, dcode);
			pstm.setString(2, new String(Dname.getBytes("utf-8"), "utf-8"));
			pstm.setString(3, Pdept);
			pstm.setString(4, Area);
			
			
			int result=pstm.executeUpdate();
			System.out.println(result + "데이터가 추가되었습니다.");
			// 화면 결과 확인하고자 할때 - select
			selectAll();
			//자바는 auto Commit 된다.
			//conn.commit();
			pstm = null;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	
	//update
	
	public void update() {
		
		System.out.println("몇번을 고치고 싶으십니까?");
		int num=sc.nextInt();
		
		//dcode,Dname,Pdept,Area
		System.out.println("무엇을 고치시겠습니까? 1.Dcode,2.Dname,3.Pdept,4.Area 5.전체");
		int select=sc.nextInt();
		try {
			if(select==1) {
				System.out.println("바꾸고싶은 Dcode로 입력해주세요");
				dcode=sc.next();
			sql="update dept2 set dcode=? where dcode="+num;
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, dcode);
			pstm.executeUpdate();
			System.out.println(dcode+"으로 수정완료됨");
			
			}else if(select==2) {
				System.out.println("바꾸고싶은 Dname을 입력해주세요");
				Dname=sc.next();
				sql="update dept2 set Dname =? where dcode="+num;
				pstm=conn.prepareStatement(sql);
				pstm.setString(2, Dname);
				pstm.executeUpdate();
			
				System.out.println(Dname+"으로 수정완료됨");
			}else if(select==3) {
				System.out.println("바꾸고싶은 Pdept로 입력해주세요");
				Pdept=sc.next();
				sql="update dept2 set Pdetp=? where dcode="+num;
				pstm=conn.prepareStatement(sql);
				pstm.setString(3, Pdept);
				pstm.executeUpdate();
				
				System.out.println(Pdept+"으로 수정 완료됨");
			}else if(select==4) {
				System.out.println("Aread를 입력해주세요");
				Area=sc.next();
				sql="update dept2 set Area=? where dcode="+num;
				pstm=conn.prepareStatement(sql);
				pstm.setString(4, Area);
				
				System.out.println(Area+"으로 수정 완료됨");
				
			}else if(select==5) {
				System.out.println("바꾸고 싶은 dcode,dname,Pdept,Area를 순서대로 입력해주세요");
				dcode=sc.next();
				Dname=sc.next();
				Pdept=sc.next();
				Area=sc.next();
				sql="update dept2 set dcode=?,dname=?,Pdept=?,Area=? wherw dcode="+num;
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, dcode);
				pstm.setString(2, Dname);
				pstm.setString(3, Pdept);
				pstm.setString(4, Area);
				pstm.executeUpdate();
				
				//귀찮으면 sql문에다가  +변수명 + 으로 입력.
				
				System.out.println("수정 완료됐습니다.");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		
		
		
	}
	
	public void delete() {
		
		try {
			selectAll();
			System.out.println("삭제하실 번호는?");
			int num=sc.nextInt();
			sql = "delete table DEPT2 "+num;
			pstm = conn.prepareStatement(sql);   
			pstm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	

	
	public    void connect(){
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,uid,pw);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public void close() {
		try {
			if(rs!=null)rs.close();
			if(pstm!=null)pstm.close();
			if(rs!=null)rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
