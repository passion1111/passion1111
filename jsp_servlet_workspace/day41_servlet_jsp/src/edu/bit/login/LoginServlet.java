package edu.bit.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/bit")  //annotation
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public String user ="kingsmile";
	public String passwd ="1004";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pwd");
		
		response.setCharacterEncoding("euc-kr");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Login Test</title></head><body><b><br>");
		
		if( user.equals(id) && !passwd.equals(pw)) {
			out.println("암호가 틀렸습니다.");
			out.println("<a href='html/loginForm.html'> Login</a>");
			
		}else if( user.equals(id) && passwd.equals(pw)) {
			out.println("반갑습니다....어서와...<br />.");
			out.println("너의 아이디는 " + id + "이군요<br />");
			out.println("너의 패스워드는 " + pw + "입니다<br />");
		} else {
			out.println("등록되지 않은 사용자 입니다. <br />");
			out.println("<a href='html/loginForm.html'> Login</a>");
		}
		
		out.println("</b></body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		doGet(request, response);
	}

}
