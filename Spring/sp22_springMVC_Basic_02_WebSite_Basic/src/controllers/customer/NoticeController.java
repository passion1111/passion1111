package controllers.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import vo.Notice;
import dao.NoticeDao;


public class NoticeController  implements Controller {  // spring 에서 제공하는 Controller interface implements 하면 컨트롤러가 된다.
	//게시물 목록보기
	//요청  > [ DB연동  > select method > result ] > view(출력) 
	//       [        DAO                      ] 
	private NoticeDao noticedao;
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}
	//여기서 new (x)
		
	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		//noticedao.getNotices(page, field, query)
		
		//검색 처리를 위한 코드
		String _page = req.getParameter("pg");
		String _field = req.getParameter("f");
		String _query = req.getParameter("q");
		
		//게시판 기본 설정(기본값 처리)/////////////
		int page = 1;
		String field = "TITLE";
		String query ="%%";
		//////////////////////////////////////
		if(_page != null && _page.equals("")){
			page = Integer.parseInt(_page);
		}
		if(_field != null && _field.equals("")){
			field = _field;
		}
		if(_query != null && _query.equals("")){
			query = _query;
		}
		
		List<Notice> list= noticedao.getNotices(page, field, query);
		
		//SpringMVC
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("notice.jsp"); 
		
		//내부적으로 forward 
		//customer/notice.htm 요청했던 주소 변환없이
		//notice.jsp 내용 출력
		return mv;
	}



	

}









