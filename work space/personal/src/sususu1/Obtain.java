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
	SimpleDateFormat simpledate = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
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
		sr +=obtainlist.get(i).getProduct()+"\t"+"상품수량 : "+obtainlist.get(i).getObtainAmount()+"\t"+
				"활인율 : "+obtainlist.get(i).getDiscount()+"\n";
		}
		
		return "수주날짜 : "+getObtainDate()+"\t"+"수주번호 : "+ObtainNum +"\t고객명 : " +customerName+"\n"+sr;
	}
	
	
	
}
