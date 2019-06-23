package sususu1;

import java.util.ArrayList;

public class ObtainList {
	private int obtainAmount;
	private double discount;
	public Product product;

	public ObtainList(int obtainAmount, double discount, int productCode) {
		this.obtainAmount = obtainAmount;
		this.discount = discount;
		for(Product p : WareHouse.productList){
			if(p.getProductCode()== productCode){
				this.product = p;
			}
		}
	}

	public int getObtainAmount() {
		return obtainAmount;
	}

	public double getDiscount() {
		return discount;
	}

	public Product getProduct() {
		return product;
	}
	
}
