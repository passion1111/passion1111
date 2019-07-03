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
		return "�޴� |�̸�| " + product + "\t|����| " + price + "\t|����| " + amount + "\t|�ֹ���ȣ| " + ordernum;
	}

}//end class Menu
