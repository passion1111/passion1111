<!-- 2017. 4. 27. ���� 3:06:21 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>this is list2 page</title>
<style type="text/css">
table {
	width: 100%;
	text-align: center;
	font-size: 20px;
	
}
table th{
	background-color: black;
	color: white;
}


table tr:nth-child(even) {
	background-color: lightgray;
}
table tr:HOVER {
	color: white;
	background-color: black;
}
table tr:ACTIVE{
	color: black;
	font-weight:bold;
	background-color: lightyellow;
}

#delete {
	background-color: pink;
	color: red;
}

#edit {
	background-color: #87cefa;
	color: blue;
}
button{
	font-size:20px;
	font-weight:bold;
	width: 100px;
	height: 90%;
}
#multi{
	/* visibility: hidden; */
	display:none;  
}
</style>
<script type="text/javascript">
var message = '${message}';
if (message) alert(message);


	function listChange(params) {
		var url = params.value + "_list.do";
		window.location.href = url;
	}
	
	function multiDelete(){
		var t= document.getElementsByName("dcode");
		var sum = new Array();
		var j=0;
		for (var i =0 ; i<t.length; i++){
			if(t[i].checked){
				sum[j] = t[i].value;
				j=j+1;
				/* alert(t[i].value); */
			}
		}
		/* alert("test.do?deptno="+sum); */
		window.location.href="multiDelete_dept2.do?dcode="+sum;
	}
	
	<!--
	function hide(){
		var el = document.querySelectorAll('#multi');
		for (var i =0 ; i<el.length; i++){
			if(el[i].style.display !='table-cell' )
				el[i].style.display = 'table-cell';
			else 
				el[i].style.display = 'none';
		}
	}
	
	function test(params){
		var dname = params.innerHTML.split('<td>')[2].split('</td>')[0];
		document.getElementsByName('keyvalue')[0].value=dname;
	}
	
	
	//-->
</script>
</head>
<body>
	<h3>
		<form action="search_dept2.do" method="post">
			검색어 입력 : <input size="30" type="search" name="keyvalue" placeholder="키워드 검색 가능합니다" list="dept2List"> <input type="submit" value="검색"> <a href="dept2_list.do" ><button id="delete">초기화</button></a> 
		</form>
	</h3> 
	<datalist id="dept2List">
	<c:forEach items="${list}" var="item">
		<option value="${item.dcode}"> ${item.dname} | ${item.pdept} | ${item.area}</option>
	</c:forEach>
	</datalist>
<hr>
<div >
<hr>
</div>
	<fieldset>
		<legend>
			<select style="width: 350px; height: 50px; font-size: 30px; font-weight: bold;" onchange="listChange(this);">
				<option value="dept">DEPT 테이블</option>
				<option value="dept2" selected="selected">DEPT2 테이블</option>
			</select>
			<a href="writeform_dept2.do"><button>추가하기</button></a>&nbsp;&nbsp;
			<a href="#"><button id="edit" onclick="hide()">다중삭제</button></a>&nbsp;&nbsp;
			<a href="#"><button id="multi" onclick="multiDelete()">삭제하기</button></a>&nbsp;&nbsp;
		</legend>

		<table cellpadding="5">
			<th><B>DCODE</B></th>
			<th><B>DNAME</B></th>
			<th><B>PDEPT</B></th>
			<th><B>AREA</B></th>
			<th><B></B></th>
			<th><B></B></th>
			<th id="multi"><B></B></th>
			<c:forEach items="${list}" var="item" varStatus="status">
				<tr onclick="test(this)">
					<td>${item.dcode}</td>
					<td>${item.dname}</td>
					<td>${item.pdept}</td>
					<td>${item.area}</td>
					
					<td><a href="delete_dept2.do?dcode=${ item.dcode}"><button
								id="delete">삭 제</button></a></td>
					<td><a href="updateform_dept2.do?dcode=${ item.dcode}"><button
								id="edit">수 정</button></a></td>
					<td id="multi"><input style="width: 30px; height: 30px;" type="checkbox" name="dcode" value="${item.dcode}"> </td>
				</tr>
			</c:forEach>
		</table>


	</fieldset>



</body>
</html>