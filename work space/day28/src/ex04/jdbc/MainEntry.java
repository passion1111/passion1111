package ex04.jdbc;

import java.sql.SQLException;

public class MainEntry {  // View
	
	public static void main(String[] args) throws SQLException 
			 {
		
		GogakController.connect();//����޼ҵ� ȣ��
		GogakController.menu(); //�޴� ���� �޼ҵ� ȣ�� 
	}
}

