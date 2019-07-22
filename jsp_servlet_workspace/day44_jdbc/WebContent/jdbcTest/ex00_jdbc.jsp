<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import="java.sql.*"  %>
 
<!DOCTYPE>
<html><head>
<title>JDBC</title>
</head>
<body>
<%	
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			out.print("driver load sucess <br>");
			
			Connection conn = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:xe", 
							"kingsmile", 
							"oracle");
			out.print("connection sucess <br>");
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			//conn.close();
		}
%>
</body>
</html>






