package ex03.jdbc;

import java.sql.SQLException;

public class MainEntry {  // View
	
	public static void main(String[] args) 
			throws SQLException {
		
		GiftController.connect(); //연결메소드 호출
		GiftController.menu(); //메뉴 선택 메소드 호출 
	}
}
