package com.coding.domain;

public class BoardFile extends BaseModel {
	public BoardFile() {
		// TODO Auto-generated constructor stub
	}
	public BoardFile(int IDX, String BRDNAME, String FILENAME, String INXNAME, int FILESIZE, int NUM, String FILE_PATH) {
		this.IDX = IDX;
		this.BRDNAME = BRDNAME;
		this.FILENAME = FILENAME;
		this.INXNAME = INXNAME;
		this.FILESIZE = FILESIZE;
		this.NUM = NUM;
		this.FILE_PATH = FILE_PATH;
	}
	public int IDX; //TB_BOARD_FILE_SEQ.NEXTVAL
	public String BRDNAME;//1: 일반게시판, 2: 교수학습Q&A, 3: 교수일대일문의
	public String FILENAME;//게시글 번호: TB_BOARD.BOARD_SEQ	
	public String INXNAME;	//파일명(전체경로)	100/bbs/20170001.jpg
	public int FILESIZE;	//사용자등록원본파일명	원본파일.jpg
	public int NUM;	//이미지항목여부(AS-IS사이트용)	0: 일반파일, 1: 이미지로직항목 파일
	public String FILE_PATH;
	
	public int getIDX() {
		return IDX;
	}
	public void setIDX(int IDX) {
		this.IDX = IDX;
	}
	public String getBRDNAME() {
		return BRDNAME;
	}
	public void setBRDNAME(String BRDNAME) {
		this.BRDNAME = BRDNAME;
	}
	public String getFILENAME() {
		return FILENAME;
	}
	public void setFILENAME(String FILENAME) {
		this.FILENAME = FILENAME;
	}
	public String getINXNAME() {
		return INXNAME;
	}
	public void setINXNAME(String INXNAME) {
		this.INXNAME = INXNAME;
	}
	public int getFILESIZE() {
		return FILESIZE;
	}
	public void setFILESIZE(int FILESIZE) {
		this.FILESIZE = FILESIZE;
	}
	public int getNUME() {
		return NUM;
	}
	public void setNUM(int NUM) {
		this.NUM = NUM;
	}
	public int getFILE_PATH() {
		return NUM;
	}
	public void setFILE_PATH(String FILE_PATH) {
		this.FILE_PATH = FILE_PATH;
	}
	
}
