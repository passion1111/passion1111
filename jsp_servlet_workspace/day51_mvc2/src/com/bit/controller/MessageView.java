package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/bitCamp")
public class MessageView extends HttpServlet implements Servlet{
	private static final long serialVersionUID = 1L;
	//1. 전송방식 결정
	//2. 사용자 요청 (doGet / doPost 방식)
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	// 사용자 요청 처리 메소드
	private void doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

		String msg = request.getParameter("message");
		
		Object obj = null;
		
		if( msg == null || msg.equals("test")) {
			obj = "메세지가 없거나, test로 넘어왔어요.";
		} else if( msg.equals("name")) {
			obj = "나의 이름은 kingsmile 입니다.";
		} else if( msg.equals("aa")) {
			obj = "aa 입니다.";
		} else {
			obj = "찾는 type이 없군요.";
		}
		
		//3. 저장  request.setAttribute("변수명", 데이터);
		request.setAttribute("result", obj);
		
		//4. 해당 뷰 페이지로 이동
		RequestDispatcher d = 
				request.getRequestDispatcher("/view/messageView.jsp");
		d.forward(request, response);
		
	}

}







