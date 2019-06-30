package com.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.board;
import com.board.control.CommandAction;
import com.board.dao.BoardDao;

public class AjaxListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		int page = 0;
		if(request.getParameter("page")!=null){
			page = Integer.parseInt(request.getParameter("page"));
		}
			ArrayList<board> articleList = BoardDao.getInstance().getArticleList(page);
			request.setAttribute("articleList", articleList);
		return "ajaxList.jsp";
	}

}
