package edu.bit.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet33
 */
@WebServlet("/Servlet33")
public class Servlet33 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String name=request.getParameter("name");
	String tel=request.getParameter("tel");
	response.setCharacterEncoding("euc-kr");
	PrintWriter out=response.getWriter();
	
	out.print("<html><head><title>����></title></head><body>");
	out.print("����� �̸���"+name+"�̰�<br/>");
	out.print("����� �ڵ�����ȣ��"+tel+"�Դϴ�.<br/>");
	out.println("</body></html>");
	out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
