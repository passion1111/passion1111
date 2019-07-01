<%@page import="org.apache.jasper.tagplugins.jstl.core.Catch"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>


<%
	int idx=1;
	String title=request.getParameter("title");
	String writer=request.getParameter("writer");
	String regdate=request.getParameter("regdate");
	String content=request.getParameter("content");
	int count=9999;
	if(title==""||title==null)out.println("title이 null입니다");
	if(writer==""||writer==null)out.println("writer가 null입니다");
	else if(!Pattern.matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$", writer));
//정규식 고쳐야함.
		out.println("이메일 형식이 아닙니다");
	if(regdate==""||regdate==null)out.println("날짜가 null입니다.");
	try{
		String driverName="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		Class.forName(driverName);
		Connection conn=DriverManager.getConnection(url, "kim", "oracle");
		out.println("oracle 데이터베이스 db에 성공적으로 접속했습니다");
		
	
		String sql="insert into board "+"(idx,title,writer,regdate,count,content)"+
				" values(BOARD_SEQUENCE.NEXTVAL"+",'"+title+"','"+writer+"','"+regdate+"','1','"+content+"')";
		
		PreparedStatement pstm=conn.prepareStatement(sql);
		
		pstm.executeUpdate();
		
		
		conn.close();
		pstm.close();
		
		
	}
		catch(Exception e){
			out.println("orcle 데이터베이스 db접속에 문제가 있습니다. <hr>");
			out.println(e.getMessage());
			e.printStackTrace();
			
		}finally{
			out.print("<script>location.href='list.jsp';</script>");
			
		}
	
		
		
	
	%>
</head>
<body>

</body>
</html>