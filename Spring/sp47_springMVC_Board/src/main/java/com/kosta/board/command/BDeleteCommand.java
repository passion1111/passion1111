package com.kosta.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.kosta.board.dao.BDao;

public class BDeleteCommand implements BCommand{

	@Override
	public void execute(Model model) {
		BDao dao=new BDao();
		Map<String, Object> map=model.asMap();//모델이라는 객체는 맵을 만들 수 있다!!
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		String bId=request.getParameter("bId");
		dao.delete(bId);
	}

}
