package lib.employee.facility.controller;

import java.awt.PageAttributes.MediaType;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lib.employee.facility.model.FacilitiesDAO;
import lib.employee.facility.model.FacilitiesDTO;


@RestController
@RequestMapping(value="/facility")
public class EmployeeController2 {
	@Autowired
	FacilitiesDAO facilitiesDAO; 
	
@RequestMapping(value = "/readData",method = RequestMethod.GET)
public HashMap check(@RequestParam String perPage,@RequestParam String page ) {
	System.out.println(perPage+page);
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


@RequestMapping(value="/createData",method = RequestMethod.POST )
public void insert(@RequestBody List<FacilitiesDTO> hash) {

	
			System.out.println(hash.size());
}
	
	
}
