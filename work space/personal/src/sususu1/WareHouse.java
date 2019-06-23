package sususu1;

import java.util.ArrayList;

public class WareHouse {
	private String wareHouseName;
	private String wareHouseAddress;
	private String wareHousePhoneNo;
	static ArrayList<Product> productList = new ArrayList<Product>();
	static ArrayList<Product> tempProductList = new ArrayList<Product>();
	static int productNumber = 5;
	
	public WareHouse() {
		for(Product p : productList){
			int tempa = p.getProductCode();
			String tempb = p.getProductName();
			int tempc = p.getProductPrice();
			Stock tempd = p.getStock();
			int tempe = tempd.getStockAmount();
			tempProductList.add(new Product(tempa, tempb, tempc, new Stock(tempe)));
		}
	}


	public ArrayList<Product> getTempProductList() {
		return tempProductList;
	}


	public static void dataSource() {
	
		Product prod1 = new Product(1, "≥Î∆Æ∫œ", 30, new Stock(300));
		Product prod2 = new Product(2, "Ω∫≈‰∫Í", 100, new Stock(200));
		Product prod3 = new Product(3, "≥√¿Â∞Ì", 200, new Stock(300));
		Product prod4 = new Product(4, "ºº≈π±‚", 150, new Stock(300));
		Product prod5 = new Product(5, "ø¿µø¿", 80, new Stock(300));

		productList.add(prod1);
		productList.add(prod2);
		productList.add(prod3);
		productList.add(prod4);
		productList.add(prod5);
	}
	
	public static void ProductAdd(String productName, int Price, int stock){
		productList.add(new Product(++productNumber, productName, Price, new Stock(stock)));
		tempProductList.add(new Product(productNumber-1, productName, Price, new Stock(stock)));
	}
	
	public void DataRestore(){
		
		while(productList.size()!=0){
			productList.remove(0);
		}
		for(Product p : tempProductList){
			int tempa = p.getProductCode();
			String tempb = p.getProductName();
			int tempc = p.getProductPrice();
			Stock tempd = p.getStock();
			int tempe = tempd.getStockAmount();
			 productList.add(new Product(tempa, tempb, tempc, new Stock(tempe)));
		}
	}
	
	public void BackUpSave(){
		while(tempProductList.size()!=0){
			tempProductList.remove(0);
		}
		
		for(Product p : productList){
			int tempa = p.getProductCode();
			String tempb = p.getProductName();
			int tempc = p.getProductPrice();
			Stock tempd = p.getStock();
			int tempe = tempd.getStockAmount();
			tempProductList.add(new Product(tempa, tempb, tempc, new Stock(tempe)));
		}
	}
}
