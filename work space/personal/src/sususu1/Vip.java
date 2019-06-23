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
	
		return "[ 고객번호 : " + customerNum + " , 고객명 : "+ customerName + " , "
				+ "고객주소 : " + customerAddress + " , 전화번호 : " + customerPhoneNo + " ] ★  특별회원번호 : "+this.vipNo;
	}

}
