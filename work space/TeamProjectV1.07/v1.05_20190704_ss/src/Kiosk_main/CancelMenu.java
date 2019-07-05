package Kiosk_main;

public class CancelMenu {
	
	String menuname;
	int ordernum,amount;
	public String getMenuname() {
		return menuname;
	}
	
	
	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public int getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}
	public CancelMenu(String menuname, int ordernum) {
		super();
		this.menuname = menuname;
		this.ordernum = ordernum;
	}


	public CancelMenu(String menuname, int ordernum, int amount) {
		super();
		this.menuname = menuname;
		this.ordernum = ordernum;
		this.amount = amount;
	}
	
	

}
