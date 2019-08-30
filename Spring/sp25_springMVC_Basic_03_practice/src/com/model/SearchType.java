package com.model;

public class SearchType {
	private int code;
	private String text;
	
	public SearchType(int code , String text){
		this.code = code;
		this.text = text;
	}

	public int getCode() {
		return code;
	}

	public String getText() {
		return text;
	}
	
}
