<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>

<%@ page import="java.util.* ,  java.io.*,  java.net.* " %>

<%@ include file="../view/color.jsp" %>   
    
 <%
	
 %>
 <html>
 <head><title>여러개의 파일을 업로드하는 예제</title></head>
 <link href="style.css" rel="stylesheet" type="text/css" >
 <body bgcolor="<%=bodyback_c %>">
 <table width="50%" border="1"  align="center"  cellpadding="1"  cellspacing="1" >
 <tr>
 	<td width="15%"  bgcolor="<%=value_c %>"  align="center" ><strong>작성자</strong> </td>
 	<td  width="35%" > <%= user %></td>
 </tr>
 
 <tr>
 	<td width="15%"  bgcolor="<%=value_c %>"  align="center" ><strong>제목</strong> </td>
 	<td  width="35%" > <%= title %></td>
 </tr>
 
 <tr>
 	<td width="15%"  bgcolor="<%=value_c %>"  align="center" ><strong>내  용</strong> </td>
 	<td  width="35%"   colspan="3" > <%= content %></td>
 </tr>
 
 <tr><td colspan="4"  bgcolor="<%=value_c %>">&nbsp;</td></tr>
 
 <tr>
 	<td  colspan="4" ><strong>업로드된 파일 리스트</strong></td>
 </tr>
 
 <% for(int i=0; i< saveFiles.size();  i++) { %>
 
 <tr>
 	<td colspan="4">
 	<%
 		String y = (String)saveFiles.get(i);
 		String x = request.getContextPath()+"/"+savePath+"/"+URLEncoder.encode(y, "UTF-8");
 	%>
 	<%= i+1 %>.
 	<a  href="<%= x %>"> <strong><%=origFiles.get(i) %></strong></a>
 	</td>
 </tr>
 <% } %>
 </table>
 </body>
 </html>
 <%
 } catch(IOException e){
	 System.out.println(e);
 } catch(Exception ex){
	 System.out.println(ex);
 }
 %>
 
 
 
 
 
 
 