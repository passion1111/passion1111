package edu.bit.board.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.board.model.BoardVO;

public class WriteProAction implements CommandAction {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		BoardVO vo=new BoardVO();
		
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		vo.setWriter(request.getParameter("writer"));
		vo.setEmail(request.getParameter("email"));
		vo.setSubject(request.getParameter("subject"));
		vo.setPasswd(request.getParameter("passwd"));
		vo.setReg_date(new Timestamp(System.currentTimeMillis()));
		vo.setReadcount(Integer.parseInt(request.getParameter("readcount")));
		vo.setRef(Integer.parseInt((request.getParameter("ref"))));
		vo.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		vo.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		vo.setContent(request.getParameter("content"));
		vo.setIp(request.getParameter("ip"));
		
	
	
		
		
		return "/board/writePro.jsp";
	}

}
