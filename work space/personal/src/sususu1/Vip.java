package sususu1;

public class Vip extends Customer {

	private int vipNo;
	
	public Vip(int vipNo, int customerNum, String customerName, String customerAddress,
			String customerPhoneNo) {
		super(customerNum, customerName, customerAddress, customerPhoneNo);
		this.vipNo = vipNo;
		// TODO Auto-generated constructor stub
	}

	public String toString(){
	
		return "[ ����ȣ : " + customerNum + " , ���� : "+ customerName + " , "
				+ "���ּ� : " + customerAddress + " , ��ȭ��ȣ : " + customerPhoneNo + " ] ��  Ư��ȸ����ȣ : "+this.vipNo;
	}

}
