<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>
		<!-- Title 영역  -->
		
		<tiles:getAsString name="title"/>
</title>
<link href="notice.css" type="text/css" rel="stylesheet" />
</head>
<body>
		<!-- Header 영역 -->
		<tiles:insertAttribute name="header" />
		<!-- Visual 영역 -->
		<tiles:insertAttribute name="visual" />
		<!-- Main   영역  -->
		<div id="main">
				<div class="top-wrapper clear">
					<!-- Content 영역 -->
					<tiles:insertAttribute name="content" />
					<!-- Aside(Navi) 영역 -->	
					<tiles:insertAttribute name="aside" />
				</div>		
					
		</div>	
			
		<!-- Footer 영역  -->
		<tiles:insertAttribute name="footer" />
</body>
</html>