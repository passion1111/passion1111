package edu.kosta.boardAction;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosta.boardModel.BoardDAO;

public class ListAction implements CommandAction {

	@Override
	public String process(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		int pageSize =7; //화면에 출력 레코드 수 
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		String pageNum = request.getParameter("pageNum");
		
		if( pageNum == null ) pageNum = "1";
		
		int currentPage = Integer.parseInt(pageNum);  // 1
		int startRow = (currentPage * pageSize) - 6 ;  // 1
		int endRow = currentPage * pageSize ;  // 7
		int count = 0, number = 0;
		
		List list = null;
		BoardDAO  dao = BoardDAO.getInstance();
		count = dao.getListAllCount(); //전체 페이지 리턴...  //ex) 9
																//1            7
		if( count > 0 ) {
			list = dao.getSelectAll(startRow, endRow);  //레코드 목록 보기
		} else {
			list = Collections.EMPTY_LIST ;
		}
	
		  //  9       	=		9   -  (1 - 1 ) * 7
		// 글목록에 표시 할 글번호 
		number = count - (currentPage - 1) * pageSize ;		 // ex) 9
		
		//해당 뷰에서 사용할 속성(저장)
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("list", list);
				
		return "/board/list.jsp";
	}

}






