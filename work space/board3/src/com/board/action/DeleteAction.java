package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.board;
import com.board.control.CommandAction;
import com.board.dao.BoardDao;

import java.io.File;
import java.sql.*;

public class DeleteAction implements CommandAction{
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		
		int idx = Integer.parseInt(request.getParameter("idx"));
			
		board article = BoardDao.getInstance().getArticle(idx);
		String filename = article.getFilename();
		String uploadFileName=request.getRealPath("/upload")+"/"+filename;
		
		File uploadfile = new File (uploadFileName);
		if(uploadfile.exists() && uploadfile.isFile()){
			uploadfile.delete();
		BoardDao.getInstance().deleteArticle(idx);
		}
		return "list.do";
	}
	
}
