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
	<h1>게시글</h1>
	<table border="1">
	
	<tr>
		<th>번호</th>
		<td><%=rs.getString("idx") %></td>
		<th>작성자</th>
		<td><%=rs.getString("writer") %>     </td>
		<th>날짜</th> <td><%=rs.getString("regdate") %></td>
		<th>조회수</th> <td><%=rs.getString("count") %></td>
		</tr>
		
		<tr>
		<th colspan="2">제목</th> <!-- colspan은 행병합속성 -->
		<td colspan="6"><%=rs.getString("title") %> </td>
		</tr>
	
	
	<tr>
		<tr>
		<th colspan="2">내용</th>
		<td colspan="6"><%=rs.getString("content") %> </td>
		</tr>
	
	
	</table>
	
	<a href="delete.jsp?idx=<%=rs.getString("idx")  %>">게시글 삭제</a>
	<a href="modify_write.jsp?idx=<%=rs.getString("idx") %>">게시글 수정</a>
	<a href="list.jsp">목록</a>
	
	
	

</body>
<%

	}
}catch(Exception e){
	out.println("db에 문제가 있습니다.");
}finally{
	conn.close();
}


%>
</html>