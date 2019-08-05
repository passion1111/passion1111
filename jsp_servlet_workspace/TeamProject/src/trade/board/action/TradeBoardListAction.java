package trade.board.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.action.Action;
import common.action.ActionForward;
import trade.board.model.TradeBoardDAO;
import trade.board.model.TradeBoardVO;

public class TradeBoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		  ActionForward forward = new ActionForward();
	        //한번에 보여줄 페이지
		  int pageSize=2;
		  
	        // 현재 페이지 번호 만들기
	        int spage = 1;
	        String page = request.getParameter("page");
	        
	        if(page != null)
	            spage = Integer.parseInt(page);
	        
	        // 검색조건과 검색내용을 가져온다.
	        String opt = request.getParameter("opt");
	        String condition = request.getParameter("condition");
	        
	        
	       
	        
	        
	        System.out.println(condition);
	        
	        
	        // 검색조건과 내용을 Map에 담는다.
	        HashMap<String, Object> listOpt = new HashMap<String, Object>();
	        listOpt.put("opt", opt);
	        listOpt.put("condition", condition);
	        listOpt.put("start", spage*5-4);
	        
	        TradeBoardDAO dao = TradeBoardDAO.getInstance();
	        int listCount = dao.getBoardListCount(listOpt);
	        ArrayList<TradeBoardVO> list =  dao.getBoardList(listOpt);
	        
	        // 한 화면에 3개의 게시글을 보여지게함
	        // 페이지 번호는 총 2개, 이후로는 [다음]으로 표시
	        
	        // 전체 페이지 수
	        int maxPage = (int)(listCount/5.0 + 0.2);
	        //시작 페이지 번호
	        int startPage = (int)(spage/5.0 + 0.8) * 2 - 1;
	        //마지막 페이지 번호
	        int endPage = startPage + 1;
	        if(endPage > maxPage)    endPage = maxPage;
	        
	        
	        
	      
	      
			
	        
	        
	        
	        
	        
	        
	        //한번에 보여줄 페이지 
	        request.setAttribute("pageSize", pageSize);
	        // 4개 페이지번호 저장
	        request.setAttribute("spage", spage);
	        request.setAttribute("maxPage", maxPage);
	        request.setAttribute("startPage", startPage);
	        request.setAttribute("endPage", endPage);
	        
	        // 글의 총 수와 글목록 저장
	        request.setAttribute("listCount", listCount);
	        request.setAttribute("list", list);
	        
	        //검색조건 유지를 위해 검색조건과 검색내용을 다시 보낸다.
	       if(opt!=null) {
	        request.setAttribute("opt", opt);
	        request.setAttribute("condition", condition);
	       }
	        
	        // 단순 조회이므로 forward()사용 (= DB의 상태변화 없으므로) 
	        forward.setRedirect(false);
	        forward.setNextPath("/view/list.jsp");
	        
	        
	        
	        return forward;
	    }


}


