<%@page import="java.sql.ResultSet"%>
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
	out.println("oracle 데이터베이스 db에 성공적으로 접속했습니다");
	
	ResultSet rs=null;
	String sql="select from board order by idx desc";
	
	PreparedStatement pstm=conn.prepareStatement(sql);

	
	catch(Exception e){
		
	}




%>

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
	<tr>
		<td><%=idx %></td>
		<td><%=title %></td>
		<td><%=writer %></td>
		<td><%=regdate %></td>
		<td><%=count %></td>
	</tr>
	
	


</table>
	<a href="write1.jsp">글쓰기</a>
</body>
</html>