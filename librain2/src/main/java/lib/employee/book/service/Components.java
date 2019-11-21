package lib.employee.book.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lib.book.scheduled.BookScheduledDAO;

@Component
public class Components {
	@Autowired
	BookScheduledDAO dao;
	
	@PostConstruct
	public void compo() {
		
		dao.rentAvailable();
		dao.rentservationAutoReturn();
		dao.rentStop();
	}
}
