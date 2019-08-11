package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.model.BoardVO;
import net.board.model.BoardDAO;

public class BoardModifyView implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 	ActionForward forward = new ActionForward();
		 	request.setCharacterEncoding("UTF-8");
	   		
			BoardDAO boarddao=new BoardDAO();
			BoardVO boarddata=new BoardVO();
		   	
			int num=Integer.parseInt(request.getParameter("num"));
		   	boarddata=boarddao.getDetail(num);
		   	
		   	if(boarddata==null){
		   		System.out.println("(수정)상세보기 실패");
		   		return null;
		   	}
		   	System.out.println("(수정)상세보기 성공");
		   	
		   	request.setAttribute("boarddata", boarddata);
		   	forward.setRedirect(false);
	   		forward.setPath("./board/modify.jsp");
	   		return forward;
	 }
}