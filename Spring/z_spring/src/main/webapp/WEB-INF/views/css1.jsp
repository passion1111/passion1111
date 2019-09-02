<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!--JSP 페이지 처리 방식 선언-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!-- JSTL 커스텀 태그로 색상 관련 변수 선언-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->


<!---------------------------------------------------------->
<c:set var="color1" value="red"/>
<c:set var="color1" value="lightblue"/>
<c:set var="color1" value="gray"/>
<!---------------------------------------------------------->
<c:set var="tableBorderColor" value="#00A8A8"/>

<c:set var="trBgColor_head" value="#003737"/>
<c:set var="trFontColor_head" value="white"/>

<c:set var="trBgColor_odd" value="#E8FFFF"/>
<c:set var="trFontColor_odd" value="black"/>								

<c:set var="trBgColor_even" value="#CAFFFF"/>
<c:set var="trFontColor_even" value="black"/>

<c:set var="trBgColor_mouseover" value="#53FFFF"/>
<c:set var="trFontColor_mouseover" value="black"/>
<!-----------------------------------------------------#002448 #CEE7FF #ECF5FF  #004080----->
<c:set var="tableBorderColor" value="#974B00"/>

<c:set var="trBgColor_head" value="#804000"/>
<c:set var="trFontColor_head" value="white"/>

<c:set var="trBgColor_odd" value="#FFF5EC"/>
<c:set var="trFontColor_odd" value="black"/>

<c:set var="trBgColor_even" value="#FFE1C4"/>
<c:set var="trFontColor_even" value="black"/>

<c:set var="trBgColor_mouseover" value="#FFAE66"/>
<c:set var="trFontColor_mouseover" value="black"/>
<!---------------------------------------------------------->
<c:set var="tableBorderColor" value="#004080"/>

<c:set var="trBgColor_head" value="#004080"/> 
<c:set var="trFontColor_head" value="white"/>

<c:set var="trBgColor_odd" value="#E6F2FF"/>
<c:set var="trFontColor_odd" value="white"/>

<c:set var="trBgColor_even" value="#CAE4FF"/>
<c:set var="trFontColor_even" value="white"/>

<c:set var="trBgColor_mouseover" value="#A2D0FF"/>
<c:set var="trFontColor_mouseover" value="#004080"/>
<!---------------------------------------------------------->
<c:set var="tableBorderColor" value="#004080"/>

<c:set var="thBgColor" value="#004080"/> 
<c:set var="thFontColor" value="white"/>
<c:set var="thBorderColor" value="#004080"/>

<c:set var="tdBgColor" value="#F0F8FF"/> 
<c:set var="tdFontColor" value="${thBgColor}"/>
<c:set var="tdBorderColor" value="${thBgColor}"/>

<c:set var="trBgColor_odd" value="#EEF7FF"/>
<c:set var="trBgColor_even" value="#C4E1FF"/>

<c:set var="trBgColor_mouseover" value="#5BADFF"/>

	
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
<!-- CSS 선언-->
<!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->	
<style>
	/*-----------------------------------------------------------------------*/ 
	body,form,td,th,pre { 
		font-size: 9pt; 
		color: black; 
		line-height: 160%; 
		font-family: 굴림,tahoma,돋움,verdana; 
	} 
	/*-----------------------------------------------------------------------*/ 
	input { 
		font-size: 9pt; 
		color:black; 
		font-family: 굴림,tahoma,돋움,verdana; 
		height: 20px; 
	} 
	/*-----------------------------------------------------------------------*/ 
	a:link {text-decoration:none;color:#696969} 
	a:hover{text-decoration:none;color:#66ccff} 
	a:visited {text-decoration:none;color:#330066} 
	/*-----------------------------------------------------------------------*/ 
	/*body,td,a,div,p,pre,input,textarea {font-family:굴림;font-size:9pt;}*/
	
	
	/*-----------------------------------------------------------------------*/ 
	/* 모든 table 태그의 경계선을 단일선으로 통합하기, 글자크기 지정하기, 글자체 지정하기 */
	/*-----------------------------------------------------------------------*/ 
	table{
		border-collapse:collapse;  
		font-size: 9pt;
		font-family: tahoma,굴림,돋움,verdana;  
	}
	

	/***************************************************************************************/
	/* 1행, 1열 table 태그 CSS 설정*/
	/***************************************************************************************/	
	/*------------------------------------------------------*/ 
	/* 외각선 보이기*/
	/*------------------------------------------------------*/ 
	.tbcss0, .tbcss0 th, .tbcss0 td{  
		padding:30;
		border:1px solid  ${tableBorderColor};
	}	
	/*------------------------------------------------------*/ 
	/* 외각선 안 보이기*/
	/*------------------------------------------------------*/ 
	.tbcss00, .tbcss00 th, .tbcss00 td{  
		padding:30;
		border:0px solid  ${tableBorderColor};
	}
	

	/***************************************************************************************/
	/* [검색조건/입력/수정] 데이터 내장 table 태그 CSS 설정.*/
	/***************************************************************************************/	
	/*-----------------------------------------------------------------------*/ 
	/* 검색조건/입력/수정 데이터 내장 table 태그 CSS 설정.*/
	/* 모든 선 보임. tr 태그 홀짝수별 배경색 같음*/
	/*-----------------------------------------------------------------------*/ 
	.tbcss1, .tbcss1 th, .tbcss1 td{  
		padding:5;
		border:1px solid  ${tableBorderColor};
	}	
	.tbcss1 th{ 
		background-color:${thBgColor};
		color:${thFontColor};
	}
	.tbcss1 td{ 
		background-color:${tdBgColor}; 
		color:${tdFontColor};
	}	
	/*-----------------------------------------------------------------------*/ 
	/* 검색조건/입력/수정 데이터 내장 table 태그 CSS 설정.*/
	/* 외각 선만 보임. tr 태그 홀짝수별 배경색 같음*/
	/*-----------------------------------------------------------------------*/ 
	.tbcss11{  
		border:1px solid  ${tableBorderColor};
	}
	.tbcss11 th, .tbcss11 td{  
		padding:5;
		border:0px solid  ${tableBorderColor};
	}
	.tbcss11 th{ 
		background-color:${thBgColor};
		color:${thFontColor};
	}
	.tbcss11 td{ 
		background-color:${tdBgColor}; 
		color:${tdFontColor};
	}	
	/*-----------------------------------------------------------------------*/ 
	/* 검색조건/입력/수정 데이터 내장 table 태그 CSS 설정.*/
	/* 외각 선만 보임. tr 태그 홀짝수별 배경색 다름*/
	/*-----------------------------------------------------------------------*/ 
	.tbcss111 {  
		border:1px solid  ${tableBorderColor};
	}
	.tbcss111 th, .tbcss111 td{  
		padding:5;
		border:0px solid  ${tableBorderColor};
	}
	.tbcss111 th{ 
		background-color:${thBgColor};
		color:${thFontColor};
	}
	.tbcss111 td{ 
		background-color:${tdBgColor};
		color:${tdFontColor};
	}
	.tbcss111 tr:nth-child(odd)  { background-color:${trBgColor_odd}; }
	.tbcss111 tr:nth-child(even) { background-color:${trBgColor_even}; }  
	
	/*-----------------------------------------------------------------------*/ 
	/* 검색조건/입력/수정 데이터 내장 table 태그 CSS 설정.*/
	/* 외각 선만 보임. tr 태그 홀짝수별 배경색 다름*/
	/*-----------------------------------------------------------------------*/ 
	.tbcss1111 {  
		border:0px solid  ${tableBorderColor};
	}
	.tbcss1111 th, .tbcss1111 td{  
		padding:5;
		border:0px solid  ${tableBorderColor};
	}
	.tbcss1111 th{ 
		background-color:${thBgColor};
		color:${thFontColor};
	}
	.tbcss1111 td{ 
		background-color:${tdBgColor};
		color:${tdFontColor};
	}
	
	
	
	/***************************************************************************************/
	/* 검색 결과물 내장 table 태그 CSS 설정.
	/***************************************************************************************/	
	/*-----------------------------------------------------------------------*/ 
	/* [검색 결과물] 내장 table 태그 CSS 설정. */
	/* 가로 선만 보임. tr 태그 홀짝수별 배경색 다름*/
	/*-----------------------------------------------------------------------*/ 
	.tbcss2, .tbcss2 th, .tbcss2 td{  
		padding:5;
		border-top:1px solid  ${tableBorderColor};
		border-bottom:1px solid ${tableBorderColor}; 		
		border-left:0px  solid  ${tableBorderColor};
		border-right:0px  solid  ${tableBorderColor}; 
	}
	.tbcss2 th{ 
		background-color:${thBgColor};
		color:${thFontColor};
	}
	.tbcss2 td{ 
		/*background-color:${tdBgColor};*/ 
		color:${tdFontColor};
	}
	.tbcss2 tr:nth-child(odd)  { background-color:${trBgColor_odd}; }
	.tbcss2 tr:nth-child(even) { background-color:${trBgColor_even}; }  
	/*-----------------------------------------------------------------------*/ 
	/* [검색 결과물 내장] table 태그 CSS 설정. */
	/* 모든 선 안보임. tr 태그 홀짝수별 배경색 다름*/
	/*-----------------------------------------------------------------------*/ 
	.tbcss22, .tbcss22 th, .tbcss22 td{  
		padding:5;
		border-top:0px solid  ${tableBorderColor};
		border-bottom:0px solid ${tableBorderColor}; 		
		border-left:0px  solid  ${tableBorderColor};
		border-right:0px  solid  ${tableBorderColor}; 
	}
	.tbcss22 th{ 
		background-color:${thBgColor};
		color:${thFontColor};
	}
	.tbcss22 td{ 
		/*background-color:${tdBgColor};*/ 
		color:${tdFontColor};
	}
	/*.tbcss22 tr:nth-child(odd)  { background-color:${trBgColor_odd}; }
	.tbcss22 tr:nth-child(even) { background-color:${trBgColor_even}; }  */
	
	
	
	/*-----------------------------------------------------------------------*/ 
	/* 홀수행 배경색 지정, 마우스오버 시 배경색 지정.*/
	/*-----------------------------------------------------------------------*/ 
	.oddBgC{ background:#DADADA; }
	.mouseOverBgC{ background:#FFFF99; }
	
</style>



















<script>
$(document).ready(function(){
	//---------------------------------------------------
	/* $(".tbcss1 th,.tbcss1 td").not(".tbcss1 .tbcss1 th,.tbcss1 .tbcss1 td").css({
		"border-collapse":"collapse"
		,"border-top":"0px solid  ${trBgColor_head}"
		,"border-bottom":"0px solid ${trBgColor_head}"		
		,"border-left":"0px"
		,"border-right":"0px"		
		,"font-size": "9pt"
		,"font-family": "tahoma,굴림,돋움,verdana"
	}); */
	//---------------------------------------------------
	//var obj1 = $(".tbcss2").find("th,td");var obj2 = $(".tbcss1").find("th,td");var obj3 = obj1.not(obj2);
	/* $(".tbcss2 th,.tbcss2 td").not(".tbcss2 .tbcss1 th,.tbcss2 .tbcss1 td").css({
		"border-collapse":"collapse"
		,"border-top":"0px solid  ${trBgColor_head}"
		,"border-bottom":"0px solid ${trBgColor_head}"		
		,"border-left":"0px"
		,"border-right":"0px"		
		,"font-size": "9pt"
		,"font-family": "tahoma,굴림,돋움,verdana"
	});
	$(".tbcss2 th,").not(".tbcss2 .tbcss1 th").css({
		"background-color":"${trBgColor_head}"
		,"color":"${trFontColor_head}"
	}); */
	//---------------------------------------------------
	/* $(".tbcss2 tr:eq(0)").nextAll().not(".addedTr").filter(":even").css({
		"background-color":"red"
	});
	$(".tbcss2 tr:eq(0)").nextAll().not(".addedTr").filter(":odd").css({
		"background-color":"pink"
	}); */
		

})

</script>













