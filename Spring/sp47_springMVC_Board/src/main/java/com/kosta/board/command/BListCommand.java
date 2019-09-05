package com.kosta.board.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.kosta.board.dao.BDao;
import com.kosta.board.dto.BDto;

@Controller
public class BListCommand implements BCommand {

/*	@Autowired
	BDao dao;
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}*/

	@Override
	public void execute(Model model) {
		BDao dao=new BDao();
		List<BDto> dtos = dao.list();
		model.addAttribute("list", dtos);		// xxx.jsp	- list.jsp, write_view.jsp, ....
	}

}
