<%@ page import="java.util.regex.Pattern"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content= "text/html" charset="EUC-KR">
<title>게시판을 수정해보자용 </title>
</head>
<%
	String idx = request.getParameter("idx");
	
	request.setCharacterEncoding("euc-kr");
	
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	int count = 9999;
	if (title =="" || title ==null) out.println("title이 null이다");
	if (writer == "" || writer == null ) out.println("writer가 null이다");
		else if(!Pattern.matches("^[_0-9a-zA-Z-]+@[0-9a-zA-Z-]+(.[_0-9a-zA-Z-]+)*$", writer))
			out.println("이메일 형식이 아니다");
	if (content == "" || content == null) out.println("content가 null이다");
	

try{
    String driverName = "oracle.jdbc.driver.OracleDriver"; 

    String url = "jdbc:oracle:thin:@localhost:1521:XE";

	Class.forName(driverName);
	Connection con = DriverManager.getConnection(url, "kim", "oracle");
	out.println("Oracle DataBase Connection Success.");
	
	Statement stmt = con.createStatement();
	String sql = "UPDATE board SET title= '"+title+"', WRITER='"+writer+"', CONTENT ='"+content+"', REGDATE = sysdate, count ="+count+" WHERE idx="+idx+"";

	out.println(sql);
	stmt.executeQuery(sql);
	con.close();

}catch(Exception e){
	out.println("Oracle Database Connection Problem <hr>");
	e.printStackTrace();
}finally{
	out.println("<script>location.href='content.jsp?idx="+idx+"';</script>");
}
%>
<body>


</body>
</html>