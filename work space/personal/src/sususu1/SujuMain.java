package sususu1;

public class SujuMain {
	static MainFrame f;
	public static void main(String[] args) {
	 
		WareHouse.dataSource();
		PersonData.CreatePerson();
		f = new MainFrame();
		
	}
	
}
