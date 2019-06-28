package ex02.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import ex03.jdbc12.GiftDelete;
import ex03.jdbc12.GiftInsert;
import ex03.jdbc12.GiftSelect;
import ex03.jdbc12.GiftUpdate;

public class MainEntry {
	
	public   Connection Connection  ()  throws ClassNotFoundException, SQLException{
		// 1.Driver load,... exception
				Class.forName("oracle.jdbc.OracleDriver");
				// 2. Connection & Open
				// driver:@IP:portNumber:SID(or 전역데이터베이스명)
				String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
				String uid = "kimkim";
				String pwd = "oracle";
				Connection conn = DriverManager.getConnection(url, uid, pwd);
				return conn;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc=new Scanner(System.in);
		int select;
		while(true) {
			do {
				System.out.println("1번.업데이트 2번.추가.3.목록보기4.삭제");
				
				while(!sc.hasNextInt()){
					System.out.println("숫자를 입력해주세요.");
					sc.next();
				}
			select=sc.nextInt();
			}while(select<1||select>4);
//		클래스로 나눴는데 함수로 만들고싶으면 그대로 내용 복붙.
		if(select==1) {	GiftUpdate1 gu=new GiftUpdate1();}
		else if(select==2) {GiftInsert1 gi=new GiftInsert1(args);} //args 1숫자 2.string 3 int   4 int로 입력
		else if(select==3){GiftSelect1 gs=new GiftSelect1();}
		else if(select==4) {GiftDelete gd=new GiftDelete();}
		}
		//commit따로 만들지 정하면 됨.  그리고 insert시  gno중복검사를 위해서 not exist적용
		 
		
	
		}

}
