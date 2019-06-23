package sususu1;

public class Customer {
	protected int customerNum;
	protected String customerName;
	protected String customerAddress;
	protected String customerPhoneNo;

	public Customer(int customerNum, String customerName,
			String customerAddress, String customerPhoneNo) {
		this.customerNum = customerNum;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerPhoneNo = customerPhoneNo;
	}
	
	public String getCustomerName() {
		return customerName;
	}

	@Override
	public String toString() {
		return "[ 고객번호 : " + customerNum + " , 고객명 : "+ customerName + " , 고객주소 : " + customerAddress + " , 전화번호 : " + customerPhoneNo +" ]";
	}
	
	

}
