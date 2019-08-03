package edu.bit.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.board.action.ListAction;
import edu.bit.board.command.BoardCommand;
import edu.bit.board.command.ListBoardCommand;


@WebServlet("*.do")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = requestURI.substring(contextPath.length()+1);
		BoardCommand command = null;
		System.out.println(contextPath);
		System.out.println(com);
		String nextPage = "";
		
		//분기 
		if( com.equals("list.do")) {
			command = new ListBoardCommand();
			command.execute(request, response);
			
			try {
				nextPage =(String)new  ListAction().process(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if( com.equals("writeForm.do")) {
			nextPage = "/board/writeForm.jsp";
		}else if( com.equals("writePro.do")) {
			nextPage = "writePro.jsp";
		}else if( com.equals("deleteForm.do")) {
			nextPage = "deleteForm.jsp";
		}else if( com.equals("deletePro.do")) {
			nextPage = "deletePro.jsp";
		}else if( com.equals("updateForm.do")) {
			nextPage = "updateForm.jsp";
		}else if( com.equals("updatePro.do")) {
			nextPage = "updatePro.jsp";
		}
	
		RequestDispatcher d = request.getRequestDispatcher(nextPage);
		d.forward(request, response);
	}

}



