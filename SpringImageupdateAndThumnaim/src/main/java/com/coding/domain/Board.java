package com.coding.domain;

public class Board extends com.coding.domain.BaseModel {
	public Board() {
		
	}
	private String BOARD_MNG_SEQ;
	public String getBOARD_MNG_SEQ() {
		return BOARD_MNG_SEQ;
	}
	public void setBOARD_MNG_SEQ(String bOARD_MNG_SEQ) {
		BOARD_MNG_SEQ = bOARD_MNG_SEQ;
	}
	public String getBOARD_SEQ() {
		return BOARD_SEQ;
	}
	public void setBOARD_SEQ(String bOARD_SEQ) {
		BOARD_SEQ = bOARD_SEQ;
	}
	public String getOPEN_YN() {
		return OPEN_YN;
	}
	public void setOPEN_YN(String oPEN_YN) {
		OPEN_YN = oPEN_YN;
	}
	public String getSUBJECT() {
		return SUBJECT;
	}
	public void setSUBJECT(String sUBJECT) {
		SUBJECT = sUBJECT;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	public String getFILE_PATH() {
		return FILE_PATH;
	}
	public void setFILE_PATH(String fILE_PATH) {
		FILE_PATH = fILE_PATH;
	}
	public String getFILE_NAME() {
		return FILE_NAME;
	}
	public void setFILE_NAME(String fILE_NAME) {
		FILE_NAME = fILE_NAME;
	}
	public String getREAL_FILE_NAME() {
		return REAL_FILE_NAME;
	}
	public void setREAL_FILE_NAME(String rEAL_FILE_NAME) {
		REAL_FILE_NAME = rEAL_FILE_NAME;
	}
	public String getPARENT_BOARD_SEQ() {
		return PARENT_BOARD_SEQ;
	}
	public void setPARENT_BOARD_SEQ(String pARENT_BOARD_SEQ) {
		PARENT_BOARD_SEQ = pARENT_BOARD_SEQ;
	}
	
	private String NOTICE_TOP_YN;
	public String getNOTICE_TOP_YN() {
		return NOTICE_TOP_YN;
	}
	public void setNOTICE_TOP_YN(String nOTICE_TOP_YN) {
		NOTICE_TOP_YN = nOTICE_TOP_YN;
	}
	
	public String getHITS() {
		return String.format("%,d", HITS);
	}
	public void setHITS(int hITS) {
		HITS = hITS;
	}
	public String getCREATENAME() {
		return CREATENAME;
	}
	public void setCREATENAME(String cREATENAME) {
		CREATENAME = cREATENAME;
	}
	public String getANSWER() {
		return ANSWER;
	}
	public void setANSWER(String aNSWER) {
		ANSWER = aNSWER;
	}
	public String getTHUMBNAIL_FILE_PATH() {
		return THUMBNAIL_FILE_PATH;
	}
	public void setTHUMBNAIL_FILE_PATH(String tHUMBNAIL_FILE_PATH) {
		THUMBNAIL_FILE_PATH = tHUMBNAIL_FILE_PATH;
	}
	public String getTHUMBNAIL_FILE_NAME() {
		return THUMBNAIL_FILE_NAME;
	}
	public void setTHUMBNAIL_FILE_NAME(String tHUMBNAIL_FILE_NAME) {
		THUMBNAIL_FILE_NAME = tHUMBNAIL_FILE_NAME;
	}
	public String getTHUMBNAIL_FILE_REAL_NAME() {
		return THUMBNAIL_FILE_REAL_NAME;
	}
	public void setTHUMBNAIL_FILE_REAL_NAME(String tHUMBNAIL_FILE_REAL_NAME) {
		THUMBNAIL_FILE_REAL_NAME = tHUMBNAIL_FILE_REAL_NAME;
	}
	public String getISSUE() {
		return ISSUE;
	}
	public void setISSUE(String iSSUE) {
		ISSUE = iSSUE;
	}
	public String getRECOMMEND() {
		return RECOMMEND;
	}
	public void setRECOMMEND(String rECOMMEND) {
		RECOMMEND = rECOMMEND;
	}
	public int getBOARD_SEQ3() {
		return BOARD_SEQ3;
	}
	public void setBOARD_SEQ3(int bOARD_SEQ3) {
		BOARD_SEQ3 = bOARD_SEQ3;
	}
	public String getCATEGORY_CODE() {
		return CATEGORY_CODE;
	}
	public void setCATEGORY_CODE(String cATEGORY_CODE) {
		CATEGORY_CODE = cATEGORY_CODE;
	}
	public int getSORT_NO() {
		return SORT_NO;
	}
	public void setSORT_NO(int sORT_NO) {
		SORT_NO = sORT_NO;
	}
	private String BOARD_SEQ;
	private String OPEN_YN;
	private String SUBJECT;
	private String CONTENT;
	private String FILE_PATH;
	private String FILE_NAME;
	private String REAL_FILE_NAME;
	private String PARENT_BOARD_SEQ;
	
	
	private int HITS;
	private String CREATENAME;
	private String ANSWER    ;
	private String THUMBNAIL_FILE_PATH       ; 
	private String THUMBNAIL_FILE_NAME      ;  
	private String THUMBNAIL_FILE_REAL_NAME;   
	private String ISSUE     ;
	private String RECOMMEND; 
	private int BOARD_SEQ3;
	private String CATEGORY_CODE;              
	private int SORT_NO;
	
	private int BOARD_SEQ_REPLY;
	public int getBOARD_SEQ_REPLY() {
		return BOARD_SEQ_REPLY;
	}
	public void setBOARD_SEQ_REPLY(int bOARD_SEQ_REPLY) {
		BOARD_SEQ_REPLY = bOARD_SEQ_REPLY;
	}
	private String OPEN_YN_REPLY;
	public String getOPEN_YN_REPLY() {
		return OPEN_YN_REPLY;
	}
	public void setOPEN_YN_REPLY(String oPEN_YN_REPLY) {
		OPEN_YN_REPLY = oPEN_YN_REPLY;
	}
	
}
