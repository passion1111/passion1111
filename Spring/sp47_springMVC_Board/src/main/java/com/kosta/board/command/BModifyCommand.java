package com.kosta.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.kosta.board.dao.BDao;

public class BModifyCommand implements BCommand{

	@Override
	public void execute(Model model) {
		try{
			BDao dao=new BDao();
			Map<String, Object> map=model.asMap();//모델이라는 객체는 맵을 만들 수 있다!!
			HttpServletRequest request=(HttpServletRequest)map.get("request");
			request.setCharacterEncoding("utf-8");
			String bId=request.getParameter("bId");
			String bName=request.getParameter("bName");
			String bTitle=request.getParameter("bTitle");
			String bContent=request.getParameter("bContent");
			dao.modify(bId, bName, bTitle, bContent);	
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
