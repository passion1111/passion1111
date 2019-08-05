package edu.bit.board.action;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.board.model.BoardDAO;

public class ListAction implements CommandAction {

	//jsp �뙆�씪�뿉 �엳�뜕 java肄붾뱶�뱾�쓣 �떦 嫄룹뼱�궡 �씠履쎌쑝濡� 紐곗븘�몺.
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {


		int pageSize = 7; //�솕硫댁뿉 異쒕젰 �젅肄붾뱶 �닔 
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String pageNum = request.getParameter("pageNum");
		
		if( pageNum == null ) pageNum = "1";
		
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage * pageSize) - 6 ;  // 1
		int endRow = currentPage * pageSize ;  // 7
		int count = 0, number = 0;	//count �쟾泥� �럹�씠吏��닔濡쒖벐�엫
		
		List list = null;
		BoardDAO  dao = BoardDAO.getInstance();
		count = dao.getListAllCount(); //�쟾泥� �럹�씠吏� 由ы꽩...
		System.out.println(count+"카운트값");
		if( count > 0 )  list = dao.getSelectAll(startRow, endRow);  //�젅肄붾뱶 紐⑸줉 蹂닿린
		
		number = count - (currentPage - 1) * pageSize ;	
		// ex) 15 - (2-1)*7 = 8
		
		//�빐�떦 酉곗뿉�꽌 �궗�슜�븷 �냽�꽦(���옣)  �쐞履쎌� �넀����嫄� �뾾怨� request 遺�遺꾨쭔 �깉濡쒖옉�꽦�뻽�뼱
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("list", list);	//洹몃깷 list濡� �띀�쓣肉� bo �벑�쑝濡� 諛붽퓭�룄�릺 蹂댁븞�쐞�빐 "" 遺�遺�
		System.out.println("찍힘?");
		return "/board/list.jsp";	//request.jsp濡� 媛��꽭�슂�옒 �씠嫄� �쓽誘멸�
	}
}
