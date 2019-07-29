<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %> <!-- 같은이름의 파일이면 나중에올린건 번호붙어서 서버에 저장하지만 파일으 다운받으면 원본이름으로 다운받음. -->
<%@page import="java.util.* , java.io.*" %>
<%@page import="java.awt.* , java.awt.image.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="edu.bit.thum.*"%>

<%
		String realPath="";
		String savePath="upload";
		String encType="UTF-8";
		int maxSize = 10*1024*1024; //10메가
		ServletContext context=getServletContext();
		realPath =context.getRealPath(savePath);
		
		try{
			MultipartRequest multi=new MultipartRequest(request,realPath,maxSize,encType,
					new DefaultFileRenamePolicy()); //drp넣거나
			Enumeration files=multi.getFileNames();
					int zoom=5;
					
					while(files.hasMoreElements()){
						String name=(String)files.nextElement();
						String fileName=multi.getFilesystemName(name);
						String orgFileName=realPath+"\\"+fileName;
						String thumFileName=realPath+"\\" + fileName;
%>
				원본 파일 저장 경로 및 파일명 : <%=orgFileName %><br>
				<img src="../upload/<%=fileName%>" border="0"><br><br><br>
							
<%	Thumbnail.createImage(orgFileName, thumFileName, zoom);%>

			썸네일 파일 저장 경로 및 파일명:<%=fileName %><br>
			<img src="../upload/<%=fileName%>" border="0" ><br>

<%					}
		}catch(Exception e){
			e.printStackTrace();
		}

%>