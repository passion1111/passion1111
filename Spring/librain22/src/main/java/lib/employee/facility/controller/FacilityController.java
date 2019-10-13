package lib.employee.facility.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lib.employee.facility.model.FacilitiesDAO;
import lib.employee.facility.model.FacilitiesDTO;

@Controller
@EnableScheduling
public class FacilityController {
	@Autowired
	FacilitiesDAO facilitiesDAO; 
	
	@RequestMapping(value="/facility")
public String facility(Model model) {
	
	return "employee/erp/facility/facility";
}
	@RequestMapping(value="/facilityapproval")
public String facilityapproval(Model model) {
	
	return "admin/facilityapproval";
}



@Scheduled(fixedDelay = 30000)

	public void testdelay() {
	System.out.println("?��?��?�� ?��?��?��?��");
}
	
}
