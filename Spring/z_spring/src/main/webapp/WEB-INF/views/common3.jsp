<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--JSP 페이지 처리 방식 선언-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>

<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--현재 페이지에 common.jsp 파일 내의 소스 삽입하기-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
 <%@include file="common2.jsp"%>

<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--CSS 설정이 저장된 자바 변수를 EL로 선언->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<c:set var="menubarStyle" value="height:20;cursor:pointer;" />

<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--[메뉴바] 관련 배경색, 글자색 저장하는 자바 변수를 EL로 선언->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<c:set var="menubarBgC_mOut" value="#2C5885" />    
<c:set var="menubarBgC_mOver" value="#4684C1" />
<c:set var="menubarFontC" value="#FCFDFE" /> 
<!----------------------------->
<c:set var="menubarBgC_mOut" value="#A1A1A1" />    
<c:set var="menubarBgC_mOver" value="#646464" />
<c:set var="menubarFontC" value="white" /> 
<!----------------------------->
<c:set var="menubarBgC_mOut" value="black" /> 
<c:set var="menubarBgC_mOver" value="#8F8F8F" />
<c:set var="menubarFontC" value="white" />
<!----------------------------->
<c:set var="menubarBgC_mOut" value="#EA4D00" />    
<c:set var="menubarBgC_mOver" value="#993200" />
<c:set var="menubarFontC" value="#E1EBF4" /> 
<!----------------------------->
<c:set var="menubarBgC_mOut" value="#004040" />    
<c:set var="menubarBgC_mOver" value="#008080" />
<c:set var="menubarFontC" value="#E1EBF4" /> 



<script>
	//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	// body 태그를 모두 실행한 후에 실행할 자스 코드 설정
	//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	$(document).ready(function(){
		
		
		//$("body").prepend(    "<center>${param_info}</center>"    );
		
		//-------------------------------------	
		// print_single_menubar(~) 함수 호출로 body 태그 척번째에 [메뉴바] 출력하기
		//-------------------------------------	
		print_single_menubar(  
				"black"    //menunbarBgColor 
				,"gray"    //,mouseoverBgColor
				,"white"    //,mouseoverFontColor
				,"black"   //,mouseoutBgColor
				,"white"   //,mouseoutFontColor
				,[
					//['/erp/contactSearchForm1.do','연락처1']
					//,['/erp/contactSearchForm2.do','연락처2']
					//,['/erp/contactSearchForm3.do','연락처3']
					['${path1}/boardListForm.do','게시판']
					,['${path1}/contactSearchForm.do','연락처']
					//,['${path1}/contactSearchForm2.do','연락처2']
					//,['logout()','로그아웃']
				]
		);
		//-------------------------------------	
		// body 태그 첫번째에 [로그아웃] 링크문자 출력하기
		//-------------------------------------	
		$("body").prepend(
			"<center><div style='cursor:pointer;'  onclick=\"location.replace('${path1}/loginForm.do');\">[로그아웃]</div></center>"
		);
	})
</script>
<div style="height:2"></div>


		<%-- <div style="cursor:pointer;background-color:lightblue;width:100;height:15;border:1px solid black;padding:2"> --%>










































