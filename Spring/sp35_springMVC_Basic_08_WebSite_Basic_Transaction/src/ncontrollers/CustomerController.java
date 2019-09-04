package ncontrollers;

import java.io.FileInputStream;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import vo.Notice;
import dao.NoticeDao;

@Controller
@RequestMapping("/customer/") 
public class CustomerController {
    @Autowired
	private NoticeDao noticeDao;
	 
	 @RequestMapping("notice.htm") // -->  /customer/notice.htm
	public String notices(String pg , String f , String q , Model model) throws ClassNotFoundException, SQLException{
		 
			int page = 1;
			String field = "TITLE";
			String query ="%%";
			//////////////////////////////////////
			if(pg != null && pg.equals("")){
				page = Integer.parseInt(pg);
			}
			if(f != null && f.equals("")){
				field = f;
			}
			if(q != null && q.equals("")){
				query = q;
			}
			
			List<Notice> list= noticeDao.getNotices(page, field, query);
			model.addAttribute("list", list);
			return "notice.jsp";
	 }
	
	 @RequestMapping("noticeDetail.htm")
	public String noticeDetail(String seq , Model model ) throws ClassNotFoundException, SQLException{
		 
		 Notice notice = noticeDao.getNotice(seq);
		 model.addAttribute("notice", notice);
		 return "noticeDetail.jsp";
	 }

	 @RequestMapping(value="noticeReg.htm" , method=RequestMethod.GET)
	public String noticeReg(){
			System.out.println("글쓰기 매핑");
			return "noticeReg.jsp"; //view이름
	  }
    //트랜잭션 테스트
	@RequestMapping(value="noticeReg.htm",method=RequestMethod.POST)
	public String noticeReg(Notice n , HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException{
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
			
			//기존 Transaction 없는 메서드
			//noticeDao.insert(n); 주석 처리
			
			//트랜잭션 추가
			noticeDao.InsertAndPointOfMember(n, "KGLIM"); 
			return "redirect:notice.htm";
		
		}

	@RequestMapping("noticeDel.htm") 
	public String noticeDel(String seq) throws ClassNotFoundException, SQLException{
		noticeDao.delete(seq);
		return "redirect:notice.htm";
	} 

	@RequestMapping(value="noticeEdit.htm",method=RequestMethod.GET)
	public String noticeEdit(String seq , Model model) throws ClassNotFoundException, SQLException{
		//수정페이지는 기존 데이터 출력
	 	Notice notice= noticeDao.getNotice(seq);
	 	model.addAttribute("notice", notice);
	 	return "noticeEdit.jsp";
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
	   noticeDao.update(n);
   	   return "redirect:noticeDetail.htm?seq="+n.getSeq();
	}
	
	@RequestMapping("download.htm")
	public void download(String p , String f , 
			             HttpServletRequest request , 
			             HttpServletResponse response) throws IOException{
		
		String fname = new String(f.getBytes("euc-kr"),"8859_1");
		System.out.println(fname);
		response.setHeader("Content-Disposition", "attachment;filename=" + fname +";");
		String fullpath = request.getServletContext().getRealPath("/customer/" + p + "/" + f);
		System.out.println(fullpath);
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
