<%@ page import="java.sql.*" %>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%
Connection conn=null;

try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String uid="kim";
	String pw="oracle";
	 conn=DriverManager.getConnection(url,uid,pw);
	String sql="select idx,title,writer,content,regdate,count from board where idx="+request.getParameter("idx");
	PreparedStatement pstm=conn.prepareStatement(sql);
	ResultSet rs=null;
	
	
	
	rs=pstm.executeQuery(sql);



	while(rs.next()){
%>

	


</head>
<body>
	<h1>�Խñ�</h1>
	<table border="1">
	
	<tr>
		<th>��ȣ</th>
		<td><%=rs.getString("idx") %></td>
		<th>�ۼ���</th>
		<td><%=rs.getString("writer") %>     </td>
		<th>��¥</th> <td><%=rs.getString("regdate") %></td>
		<th>��ȸ��</th> <td><%=rs.getString("count") %></td>
		</tr>
		
		<tr>
		<th colspan="2">����</th> <!-- colspan�� �ິ�ռӼ� -->
		<td colspan="6"><%=rs.getString("title") %> </td>
		</tr>
	
	
	<tr>
		<tr>
		<th colspan="2">����</th>
		<td colspan="6"><%=rs.getString("content") %> </td>
		</tr>
	
	
	</table>
	
	<a href="delete.jsp?idx=<%=rs.getString("idx")  %>">�Խñ� ����</a>
	<a href="modify_write.jsp?idx=<%=rs.getString("idx") %>">�Խñ� ����</a>
	<a href="list.jsp">���</a>
	
	
	

</body>
<%

	}
}catch(Exception e){
	out.println("db�� ������ �ֽ��ϴ�.");
}finally{
	conn.close();
}


%>
</html>