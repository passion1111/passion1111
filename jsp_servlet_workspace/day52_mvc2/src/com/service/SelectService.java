package com.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmpDAO;
import com.domain.EmpDTO;

public class SelectService {
	public ArrayList<EmpDTO> execute(HttpServletRequest request,HttpServletResponse response){
		
		EmpDAO dao=new EmpDAO();
		return dao.select();
	}//end execute()
}
