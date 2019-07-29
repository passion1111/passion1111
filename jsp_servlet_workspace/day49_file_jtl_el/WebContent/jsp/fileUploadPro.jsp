<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %> <!-- 같은이름의 파일이면 나중에올린건 번호붙어서 서버에 저장하지만 파일으 다운받으면 원본이름으로 다운받음. -->
<%@page import="java.net.*,java.util.* , java.io.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%
		String realPath="";
		String savePath="upload";
		String encType="UTF-8";
		int maxSize = 10*1024*1024; //10메가

		//현재 jsp 페이지으 웹 어플리케이션상의 절대 경로 구함
		ServletContext context=getServletContext();
		realPath=context.getRealPath(savePath+ "\\");// savepath\
		out.print("realpath is"+realPath+"<br>");
		//DefaultFileRenamePolicy drp=new DefaultFileRenamePolicy();
		try{
			MultipartRequest multi=new MultipartRequest(request,realPath,maxSize,encType,
					new DefaultFileRenamePolicy()); //drp넣거나
					Enumeration params=multi.getParameterNames();
					while(params.hasMoreElements()){
						String name=(String)params.nextElement();//전송되는 파라미터 이름
						String value=multi.getParameter(name);//전송되는 파라미터 값
						out.print(name+"// k"+value+"<br>");
					}
					
					out.print("===================");
					//전송할 파일 정보를 가져와서 출력
					Enumeration files=multi.getFileNames();
					
					while(files.hasMoreElements()){
						String name=(String)files.nextElement();
						String fileName=multi.getFilesystemName(name);//물리적 경로에 있는 이름
						String originName=multi.getOriginalFileName(name);//원래 파일명
						String type=multi.getContentType(name);
						
						File file=multi.getFile(name);
						
						out.print("파라미터 이름: "+name+"<br>");
						out.print("실제파일 이름: "+originName+"<br>");
						out.print("저장된파일 이름: "+fileName+"<br>");
						out.print("파일타입: "+type+"<br>");
					if(file !=null){
						out.print("크기"+file.length()+"<br>");
					}
					}
			
		}catch(Exception e ){
			e.printStackTrace();
		}
		
		%>