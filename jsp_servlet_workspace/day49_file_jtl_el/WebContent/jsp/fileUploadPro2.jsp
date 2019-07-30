<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %> <!-- 같은이름의 파일이면 나중에올린건 번호붙어서 서버에 저장하지만 파일으 다운받으면 원본이름으로 다운받음. -->
<%@page import="java.net.*,java.util.* , java.io.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%
	String realPath="";
	String savePath="upload";
	String enctype="UTF-8";
	int maxSize=5*1024*1024;
	ServletContext context=getServletContext();
	realPath=context.getRealPath(savePath+"\\");
	
	
	try{
		MultipartRequest multi=new MultipartRequest
				(request,realPath,maxSize,enctype,new DefaultFileRenamePolicy());
		
		Enumeration params=multi.getParameterNames();
		while(params.hasMoreElements()){
			String name=(String)params.nextElement();
			String value=multi.getParameter(name);
			
		}
		
		Enumeration files=multi.getFileNames();
		while(files.hasMoreElements()){
			String name=(String)files.nextElement();
			String fileName=multi.getFilesystemName(name);//물리적인 주소
			String originName=multi.getOriginalFileName(name);
			String type=multi.getContentType(name);
			
			File file=multi.getFile(name);
		}
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
	%>