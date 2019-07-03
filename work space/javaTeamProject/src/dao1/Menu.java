package dao1;

public class Menu {
	
	String product;
	int price, amount, ordernum;
	
	public Menu(String product, int price, int amount, int ordernum) {
		
		this.product = product;
		this.price = price;
		this.amount = amount;
		this.ordernum = ordernum;
		
	}//constructor method
	
	//getter and setter
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}
	
	//toString
	@Override
	public String toString() {
		return "메뉴 |이름| " + product + "\t|가격| " + price + "\t|수량| " + amount + "\t|주문번호| " + ordernum;
	}

}//end class Menu
