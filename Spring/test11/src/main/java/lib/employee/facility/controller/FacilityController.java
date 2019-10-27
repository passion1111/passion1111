package lib.employee.facility.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lib.employee.facility.model.FacilitiesDAO;

@Controller
public class FacilityController {
	@Autowired
	FacilitiesDAO facilitiesDAO; 
	
	@RequestMapping(value="/facility")
public String facility(Model model) {
	
	return "employee/erp/facility/facility";
}
	@RequestMapping(value="/facilityapproval")
public String facilityapproval(Model model) {
	
	return "admin/erp/facilityapproval";
}




	
}
