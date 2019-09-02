<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactoryBuilder"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@page import="com.ibatis.common.resources.Resources"%>
<%@page import="java.io.Reader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="kr.bit.dao.*,java.util.List, kr.bit.service.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
	String resource="sqlMapConfig.xml";
	try{
		Reader reader=Resources.getResourceAsReader(resource);
		//SqlSessionFactory 생성
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		
		//sqlsession얻기=>요청 단위 메서드 단위로 처리하기.
		SqlSession sqlsession=factory.openSession();
		Emp2 emp=sqlsession.selectOne("emp22","나한라");
		out.print(emp.getEmpno());
int rowdata=0;
if(rowdata>0){
	sqlsession.commit();
}else{
	sqlsession.rollback();
}
sqlsession.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>
</body>
</html>