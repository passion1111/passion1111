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

public class TradeBoardModifyProAction implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String num=request.getParameter("board_num");
		
		String existFile=request.getParameter("existing_file");
		int fileSize= 5*1024*1024;
		
		String uploadPath = request.getServletContext().getRealPath("/UploadFolder");

		System.out.println(uploadPath +"//�뾽濡쒕뱶�뤃�뜑?");
		TradeBoardDAO dao = TradeBoardDAO.getInstance();
		TradeBoardVO border = new TradeBoardVO();
		
		try {
			
			MultipartRequest multi = new MultipartRequest
					(request, uploadPath, fileSize, "euc-kr", new DefaultFileRenamePolicy());

			String fileName = "";
			Enumeration<String> names = multi.getFileNames();
			if(names.hasMoreElements())
			{
				String name = names.nextElement();
				fileName = multi.getFilesystemName(name);
				if(fileName == null)	// 占쏙옙占쏙옙占쏙옙 占쏙옙占싸울옙 占쏙옙占쏙옙占쏙옙 첨占쏙옙 占쏙옙占쌩다몌옙 占쏙옙占쏙옙 占쏙옙占싹몌옙占쏙옙 占쏙옙占쏙옙
					border.setBoard_file(existFile);
				else	// 占쏙옙占싸울옙 占쏙옙占쏙옙占쏙옙 첨占쏙옙占쏙옙占쏙옙 占쏙옙占�
					border.setBoard_file(fileName);
			}
			
			
			
			
	
			
			border.setBoard_num(dao.getSeq()); 
			border.setBoard_id(multi.getParameter("board_id")); // 占쏙옙占썹값
			border.setBoard_subject(multi.getParameter("board_subject"));
			border.setBoard_content(multi.getParameter("board_content"));
			border.setBoard_file(fileName);
			
			boolean result = dao.boardInsert(border);
			
			System.out.println("view/tra/Content.do?num="+border.getBoard_num());
			request.setAttribute("num", num);
			if(result){
				System.out.println("而⑦뀗痢좊줈 �꽆�뼱媛�湲곗쐞�븳 �떒怨�");
				return "/view/tra/content.do?num="+num;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�뙆�씪 �벑濡� �떎�뙣 " + e.getMessage());
		}
		
		
		
		return "/view/tra/content.do";
	}

}
