package edu.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandProcess {
	
	public String doProcess(HttpServletRequest request,HttpServletResponse response)throws Exception; //추상메소드
}
