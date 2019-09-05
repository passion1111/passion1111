package ncontrollers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import vo.Notice;
import dao.NoticeDao;

@Controller
@RequestMapping("/customer/") 
public class CustomerController {
 	 
	 //Mybatis 사용으로 주석
	 //@Autowired
	 //private NoticeDao noticeDao;
	 
	 //Mybatis 사용으로 
	  @Autowired
	 private SqlSession sqlSession;
	
	 @RequestMapping("notice.htm")
	 public String notices(String pg , String f , String q , Model model) throws ClassNotFoundException, SQLException{
		 //System.out.println(pg + "- " + f + "- " + q);
		 	int page = 1;
			String field = "TITLE";
			String query ="%%";
			
			if(pg != null && !pg.equals("")){
				page = Integer.parseInt(pg);
			}
			if(f != null && !f.equals("")){
				field = f;
			}
			if(q != null && !q.equals("")){
				query = q;
			}
			
			System.out.println(page + "/ " + field + " / " + query);
			//주석 : Mybatis 사용으로 
			//List<Notice> list= noticeDao.getNotices(page, field, query);
			
			NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
			List<Notice> list= noticeDao.getNotices(page, field, query);
			model.addAttribute("list", list);
			
			//Tiles 적용전
			//return "notice.jsp";
			
			//Tiles 적용후
			return "customer.notice";
			
	 }
	
	 @RequestMapping("noticeDetail.htm")
	 public String noticeDetail(String seq , Model model ) throws ClassNotFoundException, SQLException{
		 
		//Mybatis 적용 전
		//Notice notice = noticeDao.getNotice(seq);
		
		//Mybatis 적용 
		NoticeDao noticeDao =  sqlSession.getMapper(NoticeDao.class);
		Notice notice = noticeDao.getNotice(seq);
		///
		
		model.addAttribute("notice", notice);
		
		//Tiles 적용전
		//return "noticeDetail.jsp";
			
		//Tiles 적용후
		 return "customer.noticeDetail"; //{1}.jsp  > noticeDetail.jsp
		 
		
	 }
	 //글등록 화면 처리
	 @RequestMapping(value="noticeReg.htm" , method=RequestMethod.GET)
	 public String noticeReg(){
	
			//Tiles 적용전
			//return "noticeReg.jsp";
				
			//Tiles 적용후
			return "customer.noticeReg";
	  }
	 
	 //글등록 처리(실제 글등록 처리)
	 @RequestMapping(value="noticeReg.htm",method=RequestMethod.POST)
	 public String noticeReg(Notice n , HttpServletRequest request ,Principal principal) throws IOException, ClassNotFoundException, SQLException{
				
			List<CommonsMultipartFile> files =n.getFiles();
			List<String> filenNames = new ArrayList<String>();
			if(files != null && files.size() > 0){
				//이 경우라면 최소 한개는 파일첨부
				for(CommonsMultipartFile multipartFile : files){
					String fname = multipartFile.getOriginalFilename();
					String path = request.getServletContext().getRealPath("/customer/upload");
					String fullpath = path + "\\" + fname;
					
					if(!fname.equals("")){
						//서버에 물리적 경로 파일쓰기작업
						FileOutputStream fs = new FileOutputStream(fullpath);
						fs.write(multipartFile.getBytes());
						fs.close();
					}
					filenNames.add(fname); //파일의 이름만 별도 관리
				}
			}
			
			//DB insert (파일명)
			n.setFileSrc(filenNames.get(0));
			n.setFileSrc2(filenNames.get(1));
			
			//Spring Security 사용한 글쓰기(사용자 처리)
			//1단계
			//UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			//Login ID 정보를 가지고 온다
			//n.setWriter(user.getUsername());
			
			//2단계
			//Principal principal; //함수의 파라메터
			//내부적으로 security 인증 사용자정보를 가지는 객체를 주소를 전달
			n.setWriter(principal.getName());
			
			//Mybatis 적용전
			//noticeDao.insert(n);
			
			//Mybatis 적용후
			NoticeDao noticeDao =  sqlSession.getMapper(NoticeDao.class);
			noticeDao.insert(n);
			
			//Tiles 로 바뀌지 않는다
			return "redirect:notice.htm"; //요청 주소
		
		}
	
	//글삭제하기
	 @RequestMapping("noticeDel.htm") 
	public String noticeDel(String seq) throws ClassNotFoundException, SQLException{
		
		//Mybatis 적용 전
		//noticeDao.delete(seq);
		 
		 //Mybatis 적용 후
		 NoticeDao noticeDao =  sqlSession.getMapper(NoticeDao.class);
		 noticeDao.delete(seq);
		//Tiles 로 바뀌지 않는다 (요청 주소)
		return "redirect:notice.htm";
	} 
	
	@RequestMapping(value="noticeEdit.htm",method=RequestMethod.GET)
	public String noticeEdit(String seq , Model model) throws ClassNotFoundException, SQLException{
		//수정페이지는 기존 데이터 출력
	 	
		//Mybatis 적용전
		//Notice notice= noticeDao.getNotice(seq);
		
		//Mybatis 적용후
		NoticeDao noticeDao =  sqlSession.getMapper(NoticeDao.class);
		Notice notice= noticeDao.getNotice(seq);
	 	
		
		model.addAttribute("notice", notice);
	 	
	 	//Tiles 적용전
		//return "noticeEdit.jsp";
		
		//Tiles 적용후
	 	return "customer.noticeEdit";
	}
	@RequestMapping(value={"noticeEdit.htm"},method=RequestMethod.POST)   //=>customer/notice.htm
	public String noticeEdit(Notice n , HttpServletRequest request) throws ClassNotFoundException, SQLException, IOException{
	   
		if(!n.getFile().isEmpty()){
		   	String fname = n.getFile().getOriginalFilename();
			String path = request.getServletContext().getRealPath("/customer/upload");
			String fpath = path + "\\" + fname;
			//파일쓰기 작업
			FileOutputStream fs = new FileOutputStream(fpath);
			fs.write(n.getFile().getBytes());
			fs.close();
			n.setFileSrc(fname); //파일이름 
		}
		
	   //Mybatis 적용전
	   //noticeDao.update(n);
		
	   //Mybatis 적용후
	   NoticeDao noticeDao =  sqlSession.getMapper(NoticeDao.class);
	   noticeDao.update(n);
	   //Tiles(x) 요청주소
   	   return "redirect:noticeDetail.htm?seq="+n.getSeq();
	}
	
	@RequestMapping("download.htm")
	public void download(String p , String f , 
			             HttpServletRequest request , 
			             HttpServletResponse response) throws IOException{
		
		String fname = new String(f.getBytes("euc-kr"),"8859_1");
	
		response.setHeader("Content-Disposition", "attachment;filename=" + fname +";");
		String fullpath = request.getServletContext().getRealPath("/customer/" + p + "/" + f);
	
		FileInputStream fin = new FileInputStream(fullpath);
	
		ServletOutputStream sout = response.getOutputStream();
		byte[] buf = new byte[1024]; //전체를 다읽지 않고 1204byte씩 읽어서
		int size = 0;
		while((size=fin.read(buf,0,buf.length)) != -1) //buffer 에 1024byte 담고
		{                                              //마지막 남아있는 byte 담고  그다음 없으면 탈출
			sout.write(buf, 0, size); //1kbyte씩 출력 
		}
		fin.close();
		sout.close();
	}
}
