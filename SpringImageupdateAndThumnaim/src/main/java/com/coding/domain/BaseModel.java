package com.coding.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseModel {
	private int RNO;
	private int TRC;

	public int getRNO() {
		return RNO;
	}

	public void setRNO(int rNO) {
		RNO = rNO;
	}

	public int getTRC() {
		return TRC;
	}

	public void setTRC(int tRC) {
		TRC = tRC;
	}
	
	public String getITEMNO() {
		return String.valueOf(TRC - (RNO - 1));
	}
	
	
	
	private String REG_ID;
	private String UPD_ID;
	
	
	private Date REG_DT;
	public Date getREG_DT() {
		return REG_DT;
	}
	public void setREG_DT(Date rEG_DT) {
		REG_DT = rEG_DT;
	}
	public String getREG_DTYMD() {
		return new SimpleDateFormat("yyyy-MM-dd").format(REG_DT);
	}
	
	public long REG_DT_NOW() {
		try {
			return ((new Date()).getTime() - REG_DT.getTime()) / (24 * 60 * 60 * 1000);
		}
		catch(Exception e) {
			return -1;
		}
	}
	
	private Date UPD_DT;
	public Date getUPD_DT() {
		return UPD_DT;
	}
	public void setUPD_DT(Date uPD_DT) {
		UPD_DT = uPD_DT;
	}
	public String getUPD_ID() {
		return UPD_ID;
	}
	
	public String getREG_DTNAME() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(REG_DT);
	}
	
	public String getREG_ID() {
		return REG_ID;
	}
	public void setREG_ID(String rEG_ID) {
		REG_ID = rEG_ID;
	}
	
	
	
	public void setUPD_ID(String uPD_ID) {
		UPD_ID = uPD_ID;
	}
}