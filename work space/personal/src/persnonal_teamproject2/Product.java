package persnonal_teamproject2;

import java.util.Vector;

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
	
	static public void MenuDisplay(Vector ProductVector) {
		for (int i = 0; i < ProductVector.size(); i++) {
			System.out.println("�޴� ��ȣ"+((Product) ProductVector.get(i)).getPnum()
					+"\t�޴�"+ ((Product) ProductVector.get(i)).getProductName()
					+"\t����"+((Product) ProductVector.get(i)).getPrice()					
					); //��� �޼ҵ�
		}
	}
	
}
	//Product�� ������.
