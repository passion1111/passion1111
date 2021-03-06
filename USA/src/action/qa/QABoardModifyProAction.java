package action.qa;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Command;
import model.qa.QABoardDAO;
import model.qa.QABoardVO;

public class QABoardModifyProAction implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 게시판번호 파일사이즈 정해줌. 5메가.
		int num = Integer.parseInt(request.getParameter("num"));
		int fileSize = 5 * 1024 * 1024;
		// 실제경로.
		String uploadPath = request.getServletContext().getRealPath("/upload");

		QABoardDAO dao = QABoardDAO.getInstance();
		QABoardVO vo = new QABoardVO();

		try {

			MultipartRequest multi = new MultipartRequest(request, uploadPath, fileSize, "euc-kr",
					new DefaultFileRenamePolicy());
			// filename 디폴트로 ""으로 보여주기.
			String fileName = "";
			// multipart로 데이터를 보냈으니 열거형을 써서 담아줌.
			Enumeration<String> names = multi.getFileNames();
			if (names.hasMoreElements()) {
				// 파일네임과 실제 파일네임값을 읽어와줌.
				String name = names.nextElement();
				fileName = multi.getFilesystemName(name);
				// 기존파일이 있는지 불러오고. 새로업로드한게없다면 기존파일을 유지.아니면 새로운것을 업로드.
				String existFile = request.getParameter("board.board_file");
				if (fileName == null) {
					vo.setqa_filename(existFile);
				} else {
					vo.setqa_filename(fileName);
				}

				// 게시판번호
				vo.setqa_num(num);
				// 작성자
				vo.setqa_writer(multi.getParameter("board_id"));
				// 제목
				vo.setqa_subject(multi.getParameter("board_subject"));
				// 내용
				vo.setqa_contents(multi.getParameter("board_content"));
				// 파일네임.
				vo.setqa_filename(fileName);

				boolean result = dao.updateBoard(vo);

				if (result) {
					return "/view/qa/QAcontent.do?num=" + num;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("파일 등록 실패 " + e.getMessage());
		}

		return "/view/qa/QAcontent.do?num=" + num;

	}
}
