package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.service.*;
import com.domain.EmpDTO;

@WebServlet("*.do")
public class FrondControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		getRequestURI()와 getContextPat 메소드를 사용하여 사용자 요청시 추가한 식별값을 얻는다
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=requestURI.substring(contextPath.length());
		System.out.println("requestURI "+requestURI);
		System.out.println("contextPath "+contextPath);
		System.out.println("command "+command);
	//식별값을 비교 처리하여 원하는 작업을 수행한다.
		if(command.equals("/insert.do")) {
			System.out.println("insert.do로 들어옴");
		}
		else if(command.equals("/select.do")) {
//			System.out.println("select.do로 들어옴");
		ArrayList<EmpDTO> list=new SelectService().execute(request,response);	
		RequestDispatcher rd=request.getRequestDispatcher("/view/SelectView");
		rd.forward(request, response);
		}
		else if(command.equals("/delte.do")) {
			System.out.println("delete.do로 들어옴");
		}
		else if(command.equals("/update.do")) {
			System.out.println("update.do로 들어옴");
		}
	
	
	
	}

}
