<%@page import="org.apache.jasper.tagplugins.jstl.core.Catch"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>


<%
	int idx=1;
	String title=request.getParameter("title");
	String writer=request.getParameter("writer");
	String regdate=request.getParameter("regdate");
	String content=request.getParameter("content");
	int count=9999;
	if(title==""||title==null)out.println("title�� null�Դϴ�");
	if(writer==""||writer==null)out.println("writer�� null�Դϴ�");
	else if(!Pattern.matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$", writer));
//���Խ� ���ľ���.
		out.println("�̸��� ������ �ƴմϴ�");
	if(regdate==""||regdate==null)out.println("��¥�� null�Դϴ�.");
	try{
		String driverName="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		Class.forName(driverName);
		Connection conn=DriverManager.getConnection(url, "kim", "oracle");
		out.println("oracle �����ͺ��̽� db�� ���������� �����߽��ϴ�");
		
	
		String sql="insert into board "+"(idx,title,writer,regdate,count,content)"+
				" values(BOARD_SEQUENCE.NEXTVAL"+",'"+title+"','"+writer+"','"+regdate+"','1','"+content+"')";
		
		PreparedStatement pstm=conn.prepareStatement(sql);
		
		pstm.executeUpdate();
		
		
		conn.close();
		pstm.close();
		
		
	}
		catch(Exception e){
			out.println("orcle �����ͺ��̽� db���ӿ� ������ �ֽ��ϴ�. <hr>");
			out.println(e.getMessage());
			e.printStackTrace();
			
		}finally{
			out.print("<script>location.href='list.jsp';</script>");
			
		}
	
		
		
	
	%>
</head>
<body>

</body>
</html>