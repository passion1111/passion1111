package ex04.jdbc;

import java.sql.SQLException;

public class MainEntry {  // View
	
	public static void main(String[] args) throws SQLException 
			 {
		
		GogakController.connect();//연결메소드 호출
		GogakController.menu(); //메뉴 선택 메소드 호출 
	}
}

