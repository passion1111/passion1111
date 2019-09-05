package com.kosta.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.kosta.board.dao.BDao;

public class BReplyCommand implements BCommand {

	@Override
	public void execute(Model model) {
				
		try{
			Map<String, Object> map = model.asMap();
			HttpServletRequest request = (HttpServletRequest) map.get("request");
			request.setCharacterEncoding("utf-8");
			
			String bId = request.getParameter("bId");
			String bName = request.getParameter("bName");
			String bTitle = request.getParameter("bTitle");
			String bContent = request.getParameter("bContent");
			String bGroup = request.getParameter("bGroup");
			String bStep = request.getParameter("bStep");
			String bIndent = request.getParameter("bIndent");
			
			BDao dao = new BDao();
			dao.reply(bId, bName, bTitle, bContent, bGroup, bStep, bIndent);			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
