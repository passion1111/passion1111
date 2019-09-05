package kr.or.kosta.Ncontrollers;

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

import kr.or.kosta.dao.NoticeDao;
import kr.or.kosta.vo.Notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
//NoticeController 가 데이터 조회
//NoticeDetailController 가 데이터 상세 조회
//두녀석의 처리를 method기반
@Controller
@RequestMapping("/customer/") //클래스 단의 상위 mapping
public class CustomerController {
    
	@Autowired
	private NoticeDao noticeDao;
	
	@RequestMapping("notice.htm")
	public String notices(String pg , String f , String q, Model model) 
			throws ClassNotFoundException, SQLException{
		System.out.println("annotation_notice");
		System.out.println(pg  + "/ " + f + " / " + q);
		//(String pg , String f , String q) 
		//아래코드의 역확을 대신 처리 
		//**단 조건은 parameter의 변수명이 동일하게****************
		
		//notice(String pg ....에서 자동으로 값을 받을 수 있어요 ^^
		//String _page = req.getParameter("pg");
		//String _field = req.getParameter("f");
		//String _query = req.getParameter("q");
		
		//기본값 처리 (String pg , String f , String q 값이 없는 경우)
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
		//ModelAndView mv = new ModelAndView();
		//mv.addObject("list",list);
		//mv.setViewName("notice.jsp"); 아니면  생성자에서 처리
		model.addAttribute("list", list);
		
		
		
		/*
		Tiles  적용적 view 생성 코드
		return "notice.jsp"; //@RequestMapping("/customer/notice.htm")
		                     //return Type => view
	    */
		//Tiles 작용되도록 view  구성 변경
		return "customer.notice";
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
		
		//Tiles 적용 이전
		//return "noticeDetail.jsp";
		
		//Tiles 적용
		return "customer.noticeDetail";
		
	}
	//글 등록하기(글쓰기 화면 , 글쓰기 완료 버튼 누르면 데이터 처리)
	//GET(글쓰기 화면) : POST(데이터 처리)
	//value="/customer/noticeReg.htm" 
	
	//글등록화면(view)
	@RequestMapping(value="noticeReg.htm" , method=RequestMethod.GET)
	public String noticeReg(){
		
		//Tiles  적용이전
		//return "noticeReg.jsp"; //view이름
		
		//Tiles 적용
		return "customer.noticeReg";
	}
	
	//글등록처리(model)
	@RequestMapping(value="noticeReg.htm",method=RequestMethod.POST)
	public String noticeReg(Notice n , HttpServletRequest request ,Principal principal ) throws IOException, ClassNotFoundException, SQLException{
		System.out.println("실제 글 등록 처리");
		//Notice n
		//자동화 전제 조건은 Notice 객체가 가지는 memberfield 이름과 (setter, getter)구성
		//input Tag 의 name 값이 동일하다면 자동 주입
		//파일 업로드 (Spring 제공하는 MultipartFile 인터페이스 사용)
		//1. VO, DTO 객체 별도의 TYPE을 가져야한다
		//-private CommonsMultipartFile file; setter , getter 구성
		//2. 전송폼 설정 : enctype="multipart/form-data"
		//3. 추가 : com.springsource.org.apache.commons.fileupload-1.2.0.jar
		//4. xml 코드추가
		//<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
		//<property name="maxUploadSize" value="10485760"></property>
	    //</bean> 
		
		///////////////////다중파일업로드 처리 코드 //////////////////////////
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
					filenNames.add(fname); //파일의 이름만 별도 관리
				}
				
			}
		}
		  if(filenNames.size() > 0){
			   n.setFileSrc(filenNames.get(0));
			   n.setFileSrc2(filenNames.get(1));
			  
		   }else{
			   n.setFileSrc("NOT EMPTY");
			   n.setFileSrc2("NOT EMPTY");
		   }
		/*
		보안 코드 1단계 처리
		//기존 글쓴이 (보안 인증 처리)
		UserDetails user = (UserDetails)SecurityContextHolder.
				                        getContext().
				                        getAuthentication().
				                        getPrincipal(); //User들의 정보를 가지고 오겠다
		//user.getPassword();
		//user.getUsername(); 
		n.setWriter(user.getUsername().trim());
		*/
		/* 보안 코드 2단계 코드*/
		n.setWriter(principal.getName());  
		//DB insert (파일명)
		noticeDao.insert(n);
		
		//트랜잭션이 적용된 insert
		//noticeDao.InsertAndPointOfMember(n, "kglim");
		return "redirect:notice.htm";
		/////////////////////////////////////////////////////////////////
		
		
		/*  단일파일  업로드시 사용했던 코드 
		if(!n.getFile().isEmpty()){
			String fname = n.getFile().getOriginalFilename();
			String path = request.getServletContext().getRealPath("/customer/upload");
			String fpath = path + "\\" + fname;
		
			//System.out.println(request.getParameter("title"));
			//System.out.println("notice : " + n.getTitle() + " / " + n.getContent());
			//System.out.println("FileInfo : " + fpath);
		
			//파일쓰기 작업
			FileOutputStream fs = new FileOutputStream(fpath);
			fs.write(n.getFile().getBytes());
			fs.close();
		
			n.setFileSrc(fname); //파일이름 
		}
		noticeDao.insert(n);
		//controller 가 다른 controller 부르는 방법 redirect
		return "redirect:notice.htm";
		*/
	}
	
	//글수정하기(GET : 수정화면, POST : Data처리->update)
	@RequestMapping(value={"noticeEdit.htm"},method=RequestMethod.GET)   //=>customer/notice.htm
	public String noticeEdit(String seq , Model model) throws ClassNotFoundException, SQLException{
		//수정 -> 기존 데이터 가지고 와서 model 담는다
		Notice notice = noticeDao.getNotice(seq);
		model.addAttribute("notice",notice );
		
		//Tiles 적용이전
		//return "noticeEdit.jsp";

		//Tiles 적용이후
		return "customer.noticeEdit";
	}
	
	
	//문제점 : Notice 자동 주입에 문제
	//일단 :  자동주입을 위해서 주입되는 <input name=을 설정
	
	@RequestMapping(value={"noticeEdit.htm"},method=RequestMethod.POST)   //=>customer/notice.htm
	public String noticeEdit(Notice n , HttpServletRequest request) throws ClassNotFoundException, SQLException, IOException{
		//System.out.println(n.getSeq() + n.getContent() + n.getFileSrc());
		
	   //String fname = n.getFile().getOriginalFilename();
	   //System.out.println(fname);
	   //System.out.println(n.getSeq() + "/" + n.getTitle());
	   
	   
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
	   noticeDao.update(n);
   	   return "redirect:noticeDetail.htm?seq="+n.getSeq();
	}
	@RequestMapping("noticeDel.htm")
	public String noticeDel(String seq) throws ClassNotFoundException, SQLException{
		noticeDao.delete(seq);
		return "redirect:notice.htm";
	}
	
	@RequestMapping("download.htm")
	public void download(String p , String f , 
			             HttpServletRequest request , 
			             HttpServletResponse response) throws IOException{
		
		/*
		    //한글 처리 형식 지정
      		String sEncoding = new String(filename.getBytes("euc-kr"),"8859_1");
      		response.setHeader("Content-Disposition","attachment;filename= " + sEncoding);
      		//response.setHeader("Content-Disposition","attachment;filename= " + filename +";");
 
		 */
		
		
		
		//한글 파일명 처리 (Filtter 처리  확인) -> 경우 ...
    	//한글 파일 깨짐 현상 해결하기
		//String fname = new String(f.getBytes("ISO8859_1"),"UTF-8");
		String fname = new String(f.getBytes("euc-kr"),"8859_1");
		System.out.println(fname);
		//다운로드 기본 설정 (브라우져가 read 하지 않고 ... 다운 )
		//요청 - 응답 간에 헤더정보에 설정을 강제 다운로드
		//response.setHeader("Content-Disposition", "attachment;filename=" + 
	    //                new String(fname.getBytes(),"ISO8859_1"));
		response.setHeader("Content-Disposition", "attachment;filename=" + fname +";");
		//파일명 전송 
		//파일 내용전송
		String fullpath = request.getServletContext().getRealPath("/customer/" + p + "/" + f);
		System.out.println(fullpath);
		FileInputStream fin = new FileInputStream(fullpath);
		//출력 도구 얻기 :response.getOutputStream()
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
