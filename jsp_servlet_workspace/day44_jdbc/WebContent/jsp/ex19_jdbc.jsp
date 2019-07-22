<%@page import="dbconnection.ConnectionCloseHelper1"%>
<%@page import="dbconnection.ConnectionHelper1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page  import="java.sql.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gogo</title>
</head>
<body>
<%
	//Class.forName("oracle.jdbc.OracleDriver");
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	try{
		
		//conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kim", "oracle");
		conn=ConnectionHelper1.getConnection("oracle");
		
		stmt=conn.createStatement();
		
		
		String sql="select *from dept2";
		rs=stmt.executeQuery(sql);
		
		%>
	Dcode &nbsp;&nbsp;&nbsp; dname &nbsp;&nbsp;&nbsp; pdept &nbsp;&nbsp;&nbsp;area<br/>
		<% 
		while(rs.next()){
			out.print(rs.getInt(1)+"\t");
			out.print(rs.getString(2)+"\t");
			out.print(rs.getString(3)+"\t");
			out.print(rs.getString(4)+"<br>");
			
		}//while end
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		ConnectionCloseHelper1.close(rs);
		ConnectionCloseHelper1.close(stmt);
		ConnectionCloseHelper1.close(conn);
	}
%>
</body>
</html>