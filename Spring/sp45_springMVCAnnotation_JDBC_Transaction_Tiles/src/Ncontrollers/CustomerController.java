package Ncontrollers;

/*import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
*/


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dao.NoticeDao;

import vo.Notice;


@Controller
@RequestMapping("/customer/")
public class CustomerController {

	@Autowired
	private NoticeDao noticeDao;
	//setter 구성
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	
	//@RequestMapping("/customer/notice.htm")
	@RequestMapping("notice.htm")
	public String notices(String pg , String f , String q, Model model) throws ClassNotFoundException, SQLException{
		
		//(String pg , String f , String q) 
		//아래코드의 역확을 대신 처리 **단 조건은 parameter의 변수명이 동일하게 
		//String _page = req.getParameter("pg");
		//String _field = req.getParameter("f");
		//String _query = req.getParameter("q");
		
		//기본값 처리
		int page = 1;
		String field = "TITLE";
		String query = "%%";
		//Case 별 조건 처리
		if(pg != null && !pg.equals("")){
			page = Integer.parseInt(pg);
		}
		if(f != null && !f.equals("")){
			field = f;
		}
		if(q != null && !q.equals("")){
			query = q;
		}
		List<Notice> list = noticeDao.getNotices(page, field,query);
		model.addAttribute("count",noticeDao.getCount(field, query));                    
		//ModelAndView mv = new ModelAndView();
		//mv.addObject("list",list);
		//mv.setViewName("notice.jsp"); 아니면  생성자에서 처리
		model.addAttribute("list", list);
		  
		
		//Tiles적용한 방식으로 변환
		return "customer.notice";
		//기존 방식
		//return "notice.jsp"; //@RequestMapping("/customer/notice.htm")
		                     //return Type => view
	}
	//상세 페이지
	//@RequestMapping("/customer/noticeDetail.htm")
	@RequestMapping("noticeDetail.htm")
	public String noticeDetail(String seq , Model model) throws ClassNotFoundException, SQLException{
		//String seq =req.getParameter("seq");
		Notice notice = noticeDao.getNotice(seq);
		//ModelAndView mv = new ModelAndView();
		//mv.addObject("notice",notice);
		//mv.setViewName("noticeDetail.jsp");
		model.addAttribute("notice",notice);
		//return "noticeDetail";
		//return "noticeDetail.jsp";
		return "customer.noticeDetail";
	}
   //글 등록하기 (화면)
	//@RequestMapping(value={"/customer/noticeReg.htm"},method=RequestMethod.GET)
	@RequestMapping(value={"noticeReg.htm"},method=RequestMethod.GET)
	public String noticeReg(){
		return "customer.noticeReg"; //view이름
		//return "noticeReg.jsp";
	}
	//글 등록처리하기 (model)
	//@RequestMapping(value={"/customer/noticeReg.htm"},method=RequestMethod.POST)
	@RequestMapping(value={"noticeReg.htm"},method=RequestMethod.POST)
	//public String noticeReg(String title , String content) throws ClassNotFoundException, SQLException{
	public String noticeReg(Notice n ,HttpServletRequest request) throws ClassNotFoundException, SQLException, IOException{
	    //위 Notice n 할수 있는 전제 조건 : parameter이름과 Notice클래스가 가지고 있는
		//Type명이 동일하고 , setter , getter가 구성
		//Notice  n = new Notice();
		//n.setTitle(title);
		//n.setContent(content);
		if(!n.getFile().isEmpty()) //파일을 첨부하지 않았을 경우에 대한 처리 
		{
			String fname = n.getFile().getOriginalFilename();
			String path = request.getServletContext().getRealPath("/customer/upload");
			String fpath = path + "\\" + fname;
		
		//System.out.println("fname : " + fname);
		//System.out.println("path : " + path);
		//System.out.println("fpath : " + fpath);
		
		//파일 쓰기 작업
			FileOutputStream fs = new FileOutputStream(fpath);
			fs.write(n.getFile().getBytes());
			fs.close();
			n.setFileSrc(fname); //DB파일명 기록
		}
		noticeDao.insert(n);// point 관련 없는 게시판 insert
		//noticeDao.InsertAndPointOfMember(n, "kglim");
		//다시 dispatcher  
		//controller가 다른 controller를 요청하는 방법
		return "redirect:notice.htm"; //view이름
	}
	@RequestMapping(value={"noticeEdit.htm"},method=RequestMethod.GET)
	public String noticeEdit(String seq , Model model) throws ClassNotFoundException, SQLException{
		Notice notice = noticeDao.getNotice(seq);
		model.addAttribute("notice", notice);
		return "customer.noticeEdit";
		//return "noticeEdit.jsp";
	}
	@RequestMapping(value={"noticeEdit.htm"},method=RequestMethod.POST)
	public String noticeEdit(Notice n ,HttpServletRequest request) throws ClassNotFoundException, SQLException, IOException{
		//Notice 객체 n seq 값을 가지고 있어야 한다
		//System.out.println(n.toString());
		if(!n.getFile().isEmpty()) //파일을 첨부하지 않았을 경우에 대한 처리 
		{
			String fname = n.getFile().getOriginalFilename();
			String path = request.getServletContext().getRealPath("/customer/upload");
			String fpath = path + "\\" + fname;
			FileOutputStream fs = new FileOutputStream(fpath);
			fs.write(n.getFile().getBytes());
			fs.close();
			n.setFileSrc(fname); //DB파일명 기록
		}
		noticeDao.update(n);
		
		return "redirect:noticeDetail.htm?seq=" + n.getSeq() ;
	}
	@RequestMapping("noticeDel.htm")
	public String noticeDel(String seq) throws ClassNotFoundException, SQLException{
		
		noticeDao.delete(seq);
		return "redirect:notice.htm";
	}
	//다운로드 요청 처리 
	@RequestMapping("download.htm")
	public void download(String p , String f , HttpServletRequest request ,HttpServletResponse response) throws IOException{
		
		//한글 파일명 처리 (Filtter 처리  확인) -> 경우 ...
	    //한글 파일 깨짐 현상 해결하기
		//System.out.println(f);
		String fname = new String(f.getBytes("ISO8859_1"),"UTF-8");
		//System.out.println(fname);
		//다운로드 기본 설정 (브라우져가 read 하지 않고 ... 다운 )
		//요청 - 응답 간에 헤더정보에 설정을 강제 다운로드
		response.setHeader("Content-Disposition", "attachment;filename=" + 
		                    new String(fname.getBytes(),"ISO8859_1"));
		//위 까지 이름 처리 ...다운로드 껍데기만
		///////////////////////////////////////////////////
		String fullpath = request.getServletContext().
				          getRealPath("/customer/" + p + "/" + fname);
		FileInputStream fin = new FileInputStream(fullpath);
		ServletOutputStream sout = response.getOutputStream();
			
		byte[] buf = new byte[1024];
		int size = 0;
		while((size=fin.read(buf,0,buf.length)) != -1)
		{
			sout.write(buf, 0, size);
		}
		fin.close();
		sout.close();
	}
}




