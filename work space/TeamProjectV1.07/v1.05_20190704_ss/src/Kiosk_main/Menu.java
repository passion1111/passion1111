package Kiosk_main;

public class Menu {
	String menuname;
	int menuprice, menuamount;

	public Menu(String menuname, int menuprice, int menuamount) {
		super();
		this.menuname = menuname;
		this.menuprice = menuprice;
		this.menuamount = menuamount;
	}

	public int getMenuamount() {
		return menuamount;
	}

	public void setMenuamount(int menuamount) {
		this.menuamount = menuamount;
	}

	public String getName() {
		return menuname;
	}

	public void setName(String name) {
		this.menuname = name;
	}

	public int getPrice() {
		return menuprice;
	}

	public void setPrice(int price) {
		this.menuprice = price;
	}

	public Menu(String name, int price) {
		super();
		this.menuname = name;
		this.menuprice = price;
	}

	public Menu() {
		super();
	}

}
