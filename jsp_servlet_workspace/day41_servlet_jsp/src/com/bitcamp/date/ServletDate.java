package com.bitcamp.date;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello Servlet");
		
		response.setCharacterEncoding("euc-kr"); //�ѱ۱��� ó��
		Calendar c = Calendar.getInstance(); //�ý����� ���� �ִ� ��¥�� ����
		
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		
		PrintWriter out = response.getWriter();
		out.write("<html><head><title>������ �ð��� �� ���ϴ�</title></head>");
		out.write("<body><h1><font color='red'> Hello Servlet</font><h1>");
		out.write("<h2>���� �ð���");
		out.write(Integer.toString(hour) + " ��");
		out.write(Integer.toString(minute) + " ��");
		out.write(Integer.toString(second) + " �� �Դϴ�.");
		
		
		out.write("</h2></body></html>");
		out.close();
		
	}
	
}














