<%@page import="edu.emp.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="edu.emp.*" %>
<%@ page import="java.util.*  ,  java.text.SimpleDateFormat"  %>

<%@ include file = "/view/color.jsp" %>

<%
	int pageSize = 5;  //화면에 출력 레코드 수
	int SU = pageSize - 1; 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	String pageNum = request.getParameter("pageNum");
	
	if( pageNum == null ) pageNum = "1";
	
	int currentPage = Integer.parseInt(pageNum);  // ex) 1
	int startRow = (currentPage * pageSize) - SU; // (1 * 7) - 6 = 1 : start
	int endRow = (currentPage * pageSize);		  // (1 * 7) = 7 : end
	int count = 0, number = 0;  //전체글수, 화면에 보여줄 글번호
	
	List list = null;
	EmpDAO dao=EmpDAO.getInstance();
	count = dao.getListAllCount(); //전체 페이지 수 리턴
	
	if( count > 0 ) {
		list = dao.getSelectAll(startRow, endRow);
	}
	
	number = count - (currentPage - 1) * pageSize; 
	// ex)     16 - (1 - 1) * 7  = 16
	// ex)     16 - (2 - 1) * 7  = 9		
			
%>

<html><head><title>게시판</title></head>
<link href="/view/mystyle.css" rel="stylesheet" type="text/css">
<body bgcolor="<%=bodyback_c %>">
	<center>
		<b>글 목록(전체 글 : <%= count %>)
		</b>
	
	<table width="700">
		<tr>
			<td bgcolor="<%=value_c%>" align="right"><a href="writeForm.jsp">글쓰기</a>
			</td>
		</tr>
	</table>
	<% if(count == 0 ) { %>
	<table width="700" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td align="center">게시판에 저장된 글이 없습니다.</td>
		</tr>
	</table>
	<% } else { %>
	<table width="700" border="1" cellpadding="0" cellspacing="0"		align="center">
		<tr height="30" bgcolor="<%=value_c%>">
			<td align="center" width="50">글 번호</td>
			<td align="center" width="50">EMPNO</td>
			<td align="center" width="50">NAME</td>
			<td align="center" width="50">DEPTNO</td>
			<td align="center" width="50">TEL</td>
			<td align="center" width="50">PAY</td>
		
	<%
		for(int i=0; i < list.size(); i++ ) { //ArrayList 에 저장된 list size 만큼 반복
			empVO vo = (empVO)list.get(i);
	%>
		<tr height="30" >
			<td align="center" width="50"><%= number-- %></td>
		
			

	
		
		
	<%
			if ( vo.getPAY() >= 10000000 ) { // 조회수가 3이상이면 hot이미지 subject뒤에 삽입			
	%> 
		
	<%      } // if end %>
			
			<td align="center"  width="100"> <%=vo.getEMPNO()%></td>
			<td align="center"  width="150"><%= vo.getNAME() %> </td>
			<td align="center"  width="150"><%= vo.getDEPTNO() %> </td>
			<td align="center"  width="150"><%= vo.getTEL() %> </td>
			<td align="center"  width="150"><%= vo.getPAY() %> </td>
			
		</tr>
	<% } //for end %>
	</table>
	<% } %>
	
	<%      // 페이지 번호 //////////
			if( count > 0 ) {  //전체 페이지의 수를 연산  ex) 16 % 7 = 2
				int pageCount = count / pageSize + ( count % pageSize == 0 ? 0 : 1 );
				int startPage = (int)(currentPage / 3 ) * 3 + 1 ; //(1/5)*5+1 = 1
				int pageBlock = 3;
				int endPage = startPage + pageBlock - 1 ;  // 1 + 5 - 1 = 5
				
				if ( endPage > pageCount ) endPage = pageCount ;
				
				if ( startPage > 3 ) {			
	%>
			<a href="main.jsp?pageNum=<%=startPage-3 %>">[이전]</a>		
	<%
				} //if end
				
				for( int i = startPage ; i <= endPage ;  i++ ) {
	%>
			<a href="main.jsp?pageNum=<%=i %>"><%=i %></a>	
	<%
				} // for end
				if ( endPage < pageCount ) {			
	%>
		<a href="main.jsp?pageNum=<%=startPage+3 %>">[다음]</a>	
	<%
				} //  if end
			} //out if end
	%>
</body>
</center>
</html>
