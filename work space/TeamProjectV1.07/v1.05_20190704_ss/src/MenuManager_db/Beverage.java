package MenuManager_db;

public class Beverage extends Object{//객체생성해야되니까 필요...
	
	private int bvrno;
	private String bvrname;
	private int price;
	
	public int getBvrno() {
		return bvrno;
	}
	public void setBvrno(int bvrno) {
		this.bvrno = bvrno;
	}
	public String getBvrname() {
		return bvrname;
	}
	public void setBvrname(String bvrname) {
		this.bvrname = bvrname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Beverage [bvrno=" + bvrno + ", bvrname=" + bvrname + ", price=" + price + "]";
	}
	
	
	
	
}
