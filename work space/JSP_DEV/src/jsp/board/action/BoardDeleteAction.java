package jsp.board.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.board.comment.model.CommentDAO;
import jsp.board.model.BoardDAO;
import jsp.common.action.Action;
import jsp.common.action.ActionForward;

public class BoardDeleteAction implements Action
{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		BoardDAO dao = BoardDAO.getInstance();

		// 占쌜뱄옙호占쏙옙 占쏙옙占쏙옙占승댐옙.
		String num = request.getParameter("num");
		int boardNum = Integer.parseInt(num);
		
		// 占쏙옙占쏙옙占쏙옙 占쌜울옙 占쌍댐옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占승댐옙.
		String fileName = dao.getFileName(boardNum);
		// 占쏙옙 占쏙옙占쏙옙 - 占쏙옙占쏙옙占� 占쏙옙占쏙옙占쏙옙占� 占쏙옙滂占� 占쏙옙占� 占쏙옙占쏙옙占싼댐옙.
		boolean result = dao.deleteBoard(boardNum);
		
		// 占쏙옙占싹삼옙占쏙옙 
		if(fileName != null)
		{
			// 占쏙옙占쏙옙占쏙옙 占쌍댐옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占싸몌옙 占쏙옙占쏙옙占승댐옙.
			String folder = request.getServletContext().getRealPath("UploadFolder");
			// 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占싸몌옙 占쏙옙占쏙옙占�.
			String filePath = folder + "/" + fileName;

			File file = new File(filePath);
			if(file.exists()) file.delete(); // 占쏙옙占쏙옙占쏙옙 1占쏙옙占쏙옙 占쏙옙占싸듸옙 占실므뤄옙 占싼뱄옙占쏙옙 占쏙옙占쏙옙占싹몌옙 占싫댐옙.
		}
		
		if(result){
			forward.setRedirect(true);
			forward.setNextPath("BoardListAction.bo");
		}
		else
			return null;

		return forward;
	}
}