package action.tra;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Command;
import model.tra.TradeBoardDAO;
import model.tra.TradeBoardVO;


public class TradeBoardWriteModify implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int fileSize= 5*1024*1024;
				
		String uploadPath=request.getServletContext().getContextPath();
			request.getServletContext().getContextPath();
		System.out.println(uploadPath +"//�뾽濡쒕뱶�뤃�뜑?");
		request.setAttribute("uploadPath", uploadPath);
		
		try {
			
			MultipartRequest multi = new MultipartRequest
					(request, uploadPath, fileSize, "euc-kr", new DefaultFileRenamePolicy());

			String fileName = "";
			Enumeration<String> names = multi.getFileNames();
			if(names.hasMoreElements())
			{
				String name = names.nextElement();
				fileName = multi.getFilesystemName(name);
			}
			
			TradeBoardDAO dao = TradeBoardDAO.getInstance();
			TradeBoardVO border = new TradeBoardVO();
			
			border.setBoard_num(dao.getSeq()); 
			border.setBoard_id(multi.getParameter("board_id")); // 占쏙옙占썹값
			border.setBoard_subject(multi.getParameter("board_subject"));
			border.setBoard_content(multi.getParameter("board_content"));
			border.setBoard_file(fileName);
		
			boolean result = dao.boardInsert(border);
			
			if(result){
				return "/view/tra/list.do";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�뙆�씪 �벑濡� �떎�뙣 " + e.getMessage());
		}
		
		
		
		return "/view/tra/list.do";
	}

}
