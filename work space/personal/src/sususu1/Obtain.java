package sususu1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Obtain {
	private int ObtainNum;
	private Date ObtainDate;
	private String customerName;
	ArrayList<ObtainList> obtainlist = new ArrayList<ObtainList>();
	SimpleDateFormat simpledate = new SimpleDateFormat("yyyy�� MM�� dd�� HH:mm:ss");
	public Obtain(int obtainNum, Date obtainDate, Customer customer) {
		ObtainNum = obtainNum;
		ObtainDate = obtainDate;
		this.customerName = customer.getCustomerName();
	}


	private String getObtainDate(){
		return simpledate.format(ObtainDate);
	}


	public void setObtainlist(ArrayList<ObtainList> obtainlist) {
		
		
			this.obtainlist.addAll(obtainlist);
		
		
	}

	@Override
	public String toString() {
		String sr ="";
		
		for(int i=0; i<obtainlist.size();i++){
		sr +=obtainlist.get(i).getProduct()+"\t"+"��ǰ���� : "+obtainlist.get(i).getObtainAmount()+"\t"+
				"Ȱ���� : "+obtainlist.get(i).getDiscount()+"\n";
		}
		
		return "���ֳ�¥ : "+getObtainDate()+"\t"+"���ֹ�ȣ : "+ObtainNum +"\t���� : " +customerName+"\n"+sr;
	}
	
	
	
}
