package persnonal_teamproject;

class Product{
	private int Pnum;
	private String ProductName;
	private int Price;
	private int Amount;
	
	Product(int Pnum,String ProductName,int Price,int Amount){
		this.Pnum=Pnum;
		this.ProductName=ProductName;
		this.Price=Price;
		this.Amount=Amount;
		
		
	}

	public int getPnum() {
		return Pnum;
	}

	public void setPnum(int pnum) {
		Pnum = pnum;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}
}
	//Product로 나눌것.
