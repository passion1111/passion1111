package lib.employee.facility.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lib.employee.facility.model.FacilitiesDAO;
import lib.employee.facility.model.FacilitiesDTO;


@RestController
public class EmployeeController2 {
	@Autowired
	FacilitiesDAO facilitiesDAO; 
	
@RequestMapping
public HashMap check(Model model) {
	System.out.println("확인222");
	List list=facilitiesDAO.facSelect();
	HashMap aa=new HashMap();
	LinkedHashMap aa2=new LinkedHashMap();
	HashMap aa3=new HashMap();
	aa3.put("page",2);
	aa3.put("totalCount",100);
	
	aa2.put("contents",list);
	
	
	aa2.put("pagination",aa3);
	aa.put("result", true);
	aa.put("data", aa2);
	
	return aa;
}

	
	
}
