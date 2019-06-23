package sususu1;

import java.util.List;

public class Product {
	private int productCode;
	private String productName;
	private int productPrice;
	Stock stock;

	public Product(int productCode, String productName, int productPrice,
			Stock stock) {
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.stock = stock;
	}

	public String getProductName() {
		return productName;
	}

	public Stock getStock() {
		return stock;
	}

	public int getProductPrice() {
		return productPrice;
	}
	

	public int getProductCode() {
		return productCode;
	}

	@Override
	public String toString() {
		return "[ ��ǰ�ڵ� : " + productCode+" , ��ǰ�̸� : " + productName + " , ��ǰ���� : " + productPrice+"]";
	}
}
