package com.controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.EmpDTO;
import com.service.SelectService;

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
//		getRequestURI()�� getContextPat 硫붿냼�뱶瑜� �궗�슜�븯�뿬 �궗�슜�옄 �슂泥��떆 異붽��븳 �떇蹂꾧컪�쓣 �뼸�뒗�떎
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=requestURI.substring(contextPath.length());
		System.out.println("requestURI "+requestURI);
		System.out.println("contextPath "+contextPath);
		System.out.println("command "+command);
	//�떇蹂꾧컪�쓣 鍮꾧탳 泥섎━�븯�뿬 �썝�븯�뒗 �옉�뾽�쓣 �닔�뻾�븳�떎.
		if(command.equals("/insert.do")) {
			System.out.println("insert.do濡� �뱾�뼱�샂");
		}
		else if(command.equals("/view/select.do")) {
//			System.out.println("select.do濡� �뱾�뼱�샂");
		ArrayList<EmpDTO> list=new SelectService().execute(request,response);	
		request.setAttribute("list", list);
		System.out.println("command다녀갔어여");
		RequestDispatcher rd=request.getRequestDispatcher("/view/SelectView.jsp");
		rd.forward(request, response);
		}
		else if(command.equals("/delte.do")) {
			System.out.println("delete.do濡� �뱾�뼱�샂");
		}
		else if(command.equals("/update.do")) {
			System.out.println("update.do濡� �뱾�뼱�샂");
		}
	
	
	
	}

}
