package edu.bit.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.board.model.BoardDAO;
import edu.bit.board.model.BoardVO;

public class UpdateFormAction implements CommandAction {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int num = 0, ref=1, re_step=0, re_level=0;


				num = Integer.parseInt(request.getParameter("num"));
				String pageNum = request.getParameter("pageNum");

				try{
				BoardDAO dao = BoardDAO.getInstance();
				BoardVO vo = dao.update(num); 
				
			/*
			 * request.setAttribute("writer", vo.getWriter());
			 * request.setAttribute("num",vo.getNum() ); request.setAttribute("",
			 * vo.getSubject());
			 */
				}catch(Exception e) {
					
				}
		
		return null;
	}

}
