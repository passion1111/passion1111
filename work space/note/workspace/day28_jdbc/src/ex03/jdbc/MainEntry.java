package ex03.jdbc;

import java.sql.SQLException;

public class MainEntry {  // View
	
	public static void main(String[] args) 
			throws SQLException {
		
		GiftController.connect(); //����޼ҵ� ȣ��
		GiftController.menu(); //�޴� ���� �޼ҵ� ȣ�� 
	}
}
