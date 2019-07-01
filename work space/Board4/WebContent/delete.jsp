<%@ page import="java.util.regex.Pattern"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content= "text/html" charset="EUC-KR">
<title>게시판을 지워보자용 </title>


</head>

<%
	String idx = request.getParameter("idx");

try{
    String driverName = "oracle.jdbc.driver.OracleDriver"; 
    
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
	ResultSet rs = null;

	Class.forName(driverName);
	Connection conn = DriverManager.getConnection(url, "kim", "oracle");
	out.println("Oracle DataBase Connection Success.");
	
	
	String sql = "DELETE from board where idx = " + idx;
	PreparedStatement pstm=conn.prepareStatement(sql);
	rs = pstm.executeQuery(sql);
	
	conn.close();
%>
	<script>
		alert("삭제되었습니다.");
		location.href="redirect.jsp";
	</script>

<%
}catch(Exception e){
	// out.println("Oracle Database Connection Problem <hr>");
%>
		<script>
		alert("삭제가 안되었어요.");
		location.href("redirect.jsp");
		</script>
<% 
	out.println(e.getMessage());
	e.printStackTrace();
}
%>



</body>
</html>