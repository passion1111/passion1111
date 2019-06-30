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
<title>게시판 만들고</title>
<%
	
	
	
try{
	String driverName="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	Class.forName(driverName);
	Connection conn=DriverManager.getConnection(url, "kim", "oracle");
	//out.println("oracle 데이터베이스 db에 성공적으로 접속했습니다");
	
	ResultSet rs=null;
	String sql="select *from board order by idx desc";
	PreparedStatement pstm=conn.prepareStatement(sql);
	rs=pstm.executeQuery(sql);
//아래는 css부분
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
	<h1>게시글</h1>
	<table>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>날짜</th>
		<th>날짜</th>
		<th>조회수</th>
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
	<a href="write1.jsp">글쓰기</a>
<%
}catch(Exception e){
	out.print("뭔가 잘못됐어여");
}

%>
</body>
</html>