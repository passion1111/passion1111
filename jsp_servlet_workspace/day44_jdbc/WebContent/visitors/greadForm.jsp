<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.* , java.sql.*"%>
<%@page import="edu.bit.visitors.*" %>
<%
	int numPerPage =5; //한 페이지에서 보여줄 페이지 수 
	int numPerBlock=3;//한 페이지에 보일 페이지 번호의 개수
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
<link href="../css/mystyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<h3 id="header">방명록</h3>
<div><br><br><a href="gdeleteForm.jsp">방명록 지우러 가기</a></div>
<div><br><br><a href="greadForm.jsp">목록보기</a></div>
<div><br><br><a href="gwriteForm.jsp">글쓰기</a></div>
<div><%@include file="menu.jsp" %></div>
<div id="main">
	<%
		Connection conn=BookDAO.loadOracleDriver();
	String pstr=request.getParameter("page");//하단에 get방식 전송에서 확인
	int mypage=1;
	try{
		mypage=Integer.parseInt(pstr);
	}catch(Exception e){
		try{
		//page없는 경우에는 마지막 페이지(가장 최근 글)
		mypage=1;
		}catch(Exception e2){
			e2.printStackTrace();
		}
	}
		Vector<BookVO> data=BookDAO.getData(conn, mypage, numPerPage);
		
		int n=data.size();
		out.print("<table width='100%'");
		for(int i=0;i<n;i++){
			BookVO vo=(BookVO)data.elementAt(i);
			String name=vo.getName();
			String email=vo.getEmail();
			String home=vo.getHome();
			String contents=vo.getContents();
	%>

	<tr bgcolor="e7e7e7">
		<td>이름: <%=name %></td>
	</tr>
	<tr>
		<td>이메일: <%if(email!=null&&email.length()>0){ %>
			<a href=mailto:<%=email %>><%=email %></a>
		<%} %>
		</td>
	
	</tr>
	
	<tr>
		<td>홈페이지: <%if(home!=null&&home.length()>0){ %>
			<a href=<%=home %>><%=email %></a>
		<%} %>
		</td>
	
	</tr>
	
	<tr>
		<td>
			내용:<p style='text-align:justipy'><%=contents %>
		</td>
	
	</tr>
	
<% 
		}//for end
%>
</table>
<div style="text-align:center">
	<%
	
			// 현재 페이지 번호가 소속된 블럭 번호를 계산
			int currentBlock=(int)Math.ceil(mypage/(double)numPerBlock);
	//데이터베이스 테이블에 저장된 총 페이지 수를 얻는다.
	double totalPage=BookDAO.getPageCount(conn, numPerPage);
	//총 블럭수 계싼
	int totalBlock=(int)Math.ceil((double)totalPage/numPerBlock);
	///////////////////
//	out.print("currentBlock:"+currentBlock);
//	out.print("totalPage:"+totalPage);
//	out.print("totalblock:"+totalBlock);
	//////////////////////////////////////// 위 없어도됨
	if(currentBlock>1){
	%>
	<a href='greadForm.jsp?page=<%=(currentBlock-1) *numPerBlock%>'>이전</a>
	
<%
}//if end
	//for문을 돌려서 각 페이지 번호에 해당하는 페이지의 방명록 내용을 
	//읽을 수 있도록 링크를 만든다.
		//for(int i=numperBlock;i>0;i--)//내림차순
	for(int i=1;i<=numPerBlock;i++){//오름차순 출력
		int pn=numPerBlock*(currentBlock-1)+i;
	if(pn>totalPage) continue;
	
	//페이지 번호에서 현재 페이지에는 밑줄을 친다.
	if(pn==mypage){
%>	
	<a href="greadForm.jsp?page=<%=pn %>">
		<span style="text-decoration: underline;"><%=pn %></span>
	</a>&nbsp;&nbsp;
	
	<% 	}else{%>
		<a href="greadForm.jsp?page=<%=pn %>">
		<%=pn %>
	</a>&nbsp;&nbsp;
		<% 
	}
	}//for end
		//totalblockl이 currentblock보다 크다는것은 현재 앞쪽에 표시되지않은
		//페이지번호가 있다는 의미
	if(totalBlock>currentBlock){
		int togo=(currentBlock+1)*numPerBlock;
	
		if(togo>totalPage)togo=(int)totalPage;
	
	%>
	<a href="greadForm.jsp?page=<%=togo %>">▶ <!-- 다음 --></a>
	<%} 
	conn.close();
%>
</div>



</div>
</body>
</html>