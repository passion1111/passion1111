package com.kosta.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.kosta.board.dao.BDao;
import com.kosta.board.dto.BDto;

public class BContentCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();// 모델이라는 객체는 맵을 만들 수 있다!!
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		// request.setCharacterEncoding("utf-8");
		String bId = request.getParameter("bId");

		BDao dao = new BDao();// jdbcTemplate이 넘어온다!
		BDto dto = dao.contentView(bId);

		model.addAttribute("content_view", dto);

	}

}
