<%@page import="java.sql.ResultSet"%>
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
	out.println("oracle �����ͺ��̽� db�� ���������� �����߽��ϴ�");
	
	ResultSet rs=null;
	String sql="select from board order by idx desc";
	
	PreparedStatement pstm=conn.prepareStatement(sql);

	
	catch(Exception e){
		
	}




%>

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
	<tr>
		<td><%=idx %></td>
		<td><%=title %></td>
		<td><%=writer %></td>
		<td><%=regdate %></td>
		<td><%=count %></td>
	</tr>
	
	


</table>
	<a href="write1.jsp">�۾���</a>
</body>
</html>