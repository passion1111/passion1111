package edu.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class MessageProcess extends HttpServlet
				implements CommandProcess {

	/*
	 * @Override 
	 * public void doProcess(HttpServletRequest request,
	 * HttpServletResponse response) throws Exception { //1. 전송방식 결정 //2. 사용자 요청 분석,
	 * 처리 //3. 저장 - request.setAttribute("변수", 데이터); String str =
	 * "hi~~~ MVC 기반 데이터 보내기"; request.setAttribute("message", str);
	 * 
	 * //4. 해당 뷰 페이지로 이동 
	 * RequestDispatcher dp =
	 * 		request.getRequestDispatcher("/view/messageProcess.jsp"); dp.forward(request,
	 * response);
	 * 
	 * }
	 */
	
	@Override
	public String doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		//3. 저장
		request.setAttribute("message", "th129");
		
		return "/view/messageProcess.jsp";
	}
	

	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		try {
			RequestDispatcher dp = 
					req.getRequestDispatcher(doProcess(req, resp));
			dp.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			RequestDispatcher dp = 
					req.getRequestDispatcher(doProcess(req, resp));
			dp.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	

}
