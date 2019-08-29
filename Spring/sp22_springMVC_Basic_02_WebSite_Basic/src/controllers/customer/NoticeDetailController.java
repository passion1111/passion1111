package controllers.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import vo.Notice;
import dao.NoticeDao;

public class NoticeDetailController implements Controller {
	private NoticeDao noticedao;
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		//게시판 상세보기
		//<a href="noticeDetail.htm?seq=${n.seq}">${n.title}</a>
		// req 객체를 통해서 게시물 글번호 얻기 (seq=10...)
		
		String seq = req.getParameter("seq");
		Notice notice = noticedao.getNotice(seq);
		
		ModelAndView mv = new ModelAndView("noticeDetail.jsp");
		mv.addObject("notice", notice);
		
		return mv;
	}

}





