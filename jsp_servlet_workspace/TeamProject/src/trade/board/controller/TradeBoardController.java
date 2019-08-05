package trade.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.action.ActionForward;
import trade.board.action.TradeBoardListAction;
import trade.board.model.TradeBoardDAO;

@WebServlet("*.do")
public class TradeBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=requestURI.substring(contextPath.length()+1);
		System.out.println(requestURI);
		System.out.println(contextPath);
		System.out.println(command);

		
		if(command.equals("view/list.do")) {
//			TradeBoardDao dao=new TradeBoardDao();
			TradeBoardDAO dao=new TradeBoardDAO();

			try {
				ActionForward action=new TradeBoardListAction().execute(request, response);
				System.out.println(action.getNextPath() +"dddd");
				RequestDispatcher rd=request.getRequestDispatcher(action.getNextPath());
				
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}

}
