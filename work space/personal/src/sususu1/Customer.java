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
		return "[ ����ȣ : " + customerNum + " , ���� : "+ customerName + " , ���ּ� : " + customerAddress + " , ��ȭ��ȣ : " + customerPhoneNo +" ]";
	}
	
	

}
