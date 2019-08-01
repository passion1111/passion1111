package edu.bit.board.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.board.model.BoardDAO;
import edu.bit.board.model.BoardVO;

public class ListBoardCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {

		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> list = dao.getSelectAll(1, 5);
		
		request.setAttribute("list", list);
	}

}
