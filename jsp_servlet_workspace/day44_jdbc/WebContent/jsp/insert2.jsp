<%@page import="dbconnection.ConnectionHelper1"%>
<%@page import="dbconnection.ConnectionSingletonHelper1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gogo</title>
</head>
<body>





<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<%
	request.setCharacterEncoding("UTF-8");
	String Dcode=request.getParameter("Dcode");
	String dname=request.getParameter("dname");
	String pdept=request.getParameter("pdept");
	String area=request.getParameter("area");
	Connection conn=null;
	PreparedStatement pstm=null;

	try{
		String driverName="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		Class.forName(driverName);
		 conn=DriverManager.getConnection(url, "kim", "oracle");
		//conn=ConnectionSingletonHelper1.getConnection("oracle");
		
	
		String sql="insert into dept2 "+"(Dcode,dname,pdept,area)"+
				" values("+Dcode+",'"+dname+"','"+pdept+"','"+area+"')";
		
		pstm=conn.prepareStatement(sql);
		 	
		pstm.executeUpdate();
		
		
		
		
	}
		catch(Exception e){
			//e.printStackTrace();
			
		}finally{
			//out.print("등록완료");
		//	out.print("<script>location.href='main.jsp';</script>");
			//ConnectionSingletonHelper1.close();
			
		conn.close();
		pstm.close();
		}
	
		
		
	
	%>
</head>
<body>

</body>
</html>
</body>
</html>