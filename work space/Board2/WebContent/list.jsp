<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.regex.Pattern"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խ��� �����</title>
<%
	
	
	
try{
	String driverName="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	Class.forName(driverName);
	Connection conn=DriverManager.getConnection(url, "kim", "oracle");
	//out.println("oracle �����ͺ��̽� db�� ���������� �����߽��ϴ�");
	
	ResultSet rs=null;
	String sql="select *from board order by idx desc";
	PreparedStatement pstm=conn.prepareStatement(sql);
	rs=pstm.executeQuery(sql);
//�Ʒ��� css�κ�
%>
<style type="text/css">
	table,td,th{
	border:1px solid red;
	
}
	th{
	background-color:red;
	color:white;
	
	}
	
	


</style>
  
</head>
<body>
	<h1>�Խñ�</h1>
	<table>
	<tr>
		<th>��ȣ</th>
		<th>����</th>
		<th>��¥</th>
		<th>��¥</th>
		<th>��ȸ��</th>
		</tr>
<% 

	while(rs.next()){
		out.print("<tr>");
		out.print("<td>"+rs.getString("idx")+"</td>");
		
		out.print("<td> <a href='content.jsp?idx="+rs.getString("idx")+"'>" +rs.getString("title")+"</a></td>");
		
		out.print("<td>"+rs.getString("writer")+"</td>");
		out.print("<td>"+rs.getString("regdate")+"</td>");
		out.print("<td>"+rs.getString("count")+"</td>");
		out.print("</tr>");
	}





%>
	
	


</table>
	<a href="write1.jsp">�۾���</a>
<%
}catch(Exception e){
	out.print("���� �߸��ƾ");
}

%>
</body>
</html>