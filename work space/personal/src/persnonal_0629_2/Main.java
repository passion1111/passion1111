package persnonal_0629_2;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException   {
	
		giftController1.connect();
		giftController1.select();
		giftController1.update();
		giftController1.select();
		
		
	}
}
