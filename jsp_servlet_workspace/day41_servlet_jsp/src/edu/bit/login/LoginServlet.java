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
			out.println("��ȣ�� Ʋ�Ƚ��ϴ�.");
			out.println("<a href='html/loginForm.html'> Login</a>");
			
		}else if( user.equals(id) && passwd.equals(pw)) {
			out.println("�ݰ����ϴ�....���...<br />.");
			out.println("���� ���̵�� " + id + "�̱���<br />");
			out.println("���� �н������ " + pw + "�Դϴ�<br />");
		} else {
			out.println("��ϵ��� ���� ����� �Դϴ�. <br />");
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
