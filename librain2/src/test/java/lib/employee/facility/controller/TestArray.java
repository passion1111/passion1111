package lib.employee.facility.controller;

import java.util.ArrayList;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lib.employee.book.model.EmpBookDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/librain-servlet.xml", 
		"file:src/main/webapp/WEB-INF/spring/mybatis.xml"})
@WebAppConfiguration
public class TestArray {
	@Test
	public void TestArray() {
		ArrayList list=new ArrayList();
		list.add("dd");
		list.add("bb");
		System.out.println(list.contains("dd"));
		
	}
	

}
