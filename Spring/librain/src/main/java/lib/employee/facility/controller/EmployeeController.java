package lib.employee.facility.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lib.employee.facility.model.FacilitiesDAO;
import lib.employee.facility.model.FacilitiesDTO;

@Controller
public class EmployeeController {
	@Autowired
	FacilitiesDAO facilitiesDAO; 
	
@RequestMapping
public String check(Model model) {
	System.out.println("확인");
	List<FacilitiesDTO> list=facilitiesDAO.facSelect();
	model.addAttribute("list",list);
	INDEX
	return "employee/erp/facility/example";
}

	
	
}
