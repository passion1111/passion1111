package com.board.action;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.board.control.CommandAction;
import com.board.dao.BoardDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import java.io.File;
import java.sql.*;
import com.board.beans.board;


public class ModifyAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		
		/// 파일삭제  지우는 부분 
		int idx = Integer.parseInt(request.getParameter("idx"));
		board delete_article = BoardDao.getInstance().getArticle(idx);
		String delete_filename = delete_article.getFilename();
		String uploadFileName=request.getRealPath("/upload")+"/"+delete_filename;
		
		File uploadfile = new File (uploadFileName);
		if(uploadfile.exists() && uploadfile.isFile()){
			uploadfile.delete();
		}
		//// 지우는 부분
				

		MultipartRequest multi = null;
			
		int sizeLimit = 10 * 1024 * 1024;
		String savePath = request.getRealPath("/upload");
		try{
			multi = new MultipartRequest(request, savePath, sizeLimit, "euc-kr", new DefaultFileRenamePolicy());
		}catch(Exception e){
			e.printStackTrace();
		}
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");
		int count = 0;
		String regip = request.getRemoteAddr();
		String filename = multi.getFilesystemName("filename");		
				
		if(title == "" || title ==null) System.out.println("title이 null이다");
			
		if(writer == "" || writer == null ) System.out.println("writer가 null이다");
		else if(!Pattern.matches("^[_0-9a-zA-Z-]+@[0-9a-zA-Z-]+(.[_0-9a-zA-Z-]+)*$", writer))
			System.out.println("이메일 형식이 아니다");
		
		if(content =="" || content == null) System.out.println("content가 null이다 ");
			
		board article = new board();
		article.setTitle(title);
		article.setWriter(writer);
		article.setContent(content);
		article.setCount(count);
		article.setRegip(regip);
		article.setFilename(filename);
		BoardDao.getInstance().insertArticle(article);
				
		return "content.do?idx="+idx;
	}

}
