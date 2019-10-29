package com.mhlab.userauth.controller;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
	"file:src/main/webapp/WEB-INF/add.xml", 
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@WebAppConfiguration
public class DBconnect {
	@Autowired
	DataSource ds;

	/*
	 * @Autowired SqlSessionFactory session;
	 */
	
	@Test
	public void dothatthing() throws SQLException {
		ds.getConnection();
	}

	@Test
	public void dothatthingA() {
		//SqlSession sessionB=session.openSession();
	}
}
