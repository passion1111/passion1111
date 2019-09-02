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

<c:set var="trBgColor_even" value="#C4E1FF"/>
<c:set var="trBgColor_odd" value="#EEF7FF"/>

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
	/* <table class="tbcss0"> ~</table>안의 테이블에 가로,세로 선이 모두 없게 보이기. */
	/* 경계선 색상은 직접 table 태그에 직접 설정. */ 
	/*-----------------------------------------------------------------------*/ 
	.tbcss0, .tbcss0 td, .tbcss0 th{ 
		border-collapse: collapse; 
		        /*padding:5;*/
		font-size: 9pt;
		font-family: tahoma,굴림,돋움,verdana; 
	}
	
	
	
	
	/*-----------------------------------------------------------------------*/ 
	/* <table class="tbcss1"> ~</table>안의 테이블에 가로,세로 선이 모두 단일선으로 보이기. */
	/* 경계선 색상은 직접 table 태그에 직접 설정. */ 
	/*-----------------------------------------------------------------------*/ 
	.tbcss1{ 
		padding:5;
		border-collapse: collapse; 
		border:1px solid ${tableBorderColor};
		font-size: 9pt;
		font-family: tahoma,굴림,돋움,verdana; 
	}
	.tbcss1 th{ 
		padding:5;
		background-color:${thBgColor};
		color:${thFontColor};
		
		border:1px solid  ${thBorderColor};
		/* border-top:0px solid  ${thBorderColor};
		border-bottom:0px solid ${thBorderColor}; 		
		border-left:0px  solid  ${thBorderColor};
		border-right:0px  solid  ${thBorderColor}; */
	}
	.tbcss1 td{ 
		padding:5;
		/* background-color:${tdBgColor}; */
		color:${tdFontColor};
		
		border:0px solid  ${tdBorderColor};
		/* border-top:1px solid  ${tdBorderColor};
		border-bottom:1px solid ${tdBorderColor}; 		
		border-left:1px  solid  ${tdBorderColor};
		border-right:1px  solid  ${tdBorderColor}; */
	}
	.tbcss1 tr:nth-child(odd){ padding:5;background-color:${trBgColor_odd}; }
	.tbcss1 tr:nth-child(even){ padding:5;background-color:${trBgColor_even}; }  
	
	
	
		
	/*-----------------------------------------------------------------------*/ 
	/* <table class="tbcss11"> ~</table>안의 테이블에 가로,세로 선이 모두 단일선으로 보이기. */
	/* 경계선 색상은 직접 table 태그에 직접 설정. */ 
	/*-----------------------------------------------------------------------*/ 
	.tbcss3, .tbcss3 th, .tbcss3 td{ 
		padding:5;
		border-collapse: collapse; 
		border:0px solid ${tableBorderColor};
		font-size: 9pt;
		font-family: tahoma,굴림,돋움,verdana; 
	}
	.tbcss3 th{ 
		background-color:${tableBorderColor};
		color:${trFontColor_head};
	}
	.tbcss3 tr:nth-child(odd){ padding:5;background-color:${trBgColor_odd}; }
	.tbcss3 tr:nth-child(even){ padding:5;background-color:${trBgColor_even}; }  
	
	
	
	
	
	/*-----------------------------------------------------------------------*/ 
	/* <table class="tbcss00"> ~</table>안의 테이블에 가로,세로 선이 모두 단일선으로 보이기. */
	/* 경계선 색상은 직접 table 태그에 직접 설정. */ 
	/*-----------------------------------------------------------------------*/ 
	/* .tbcss00, .tbcss00 th, .tbcss00{ 
		padding:10;
		border-collapse: collapse; 
		border:0px solid ${trBgColor_odd};
		background-color:${trBgColor_odd};
		font-size: 9pt;
		font-family: tahoma,굴림,돋움,verdana; 
	} */
	
	
	
	
	 
	/*-----------------------------------------------------------------------*/ 
	/* <table class="tbcss2"> ~</table>안의 가로선은 단일선으로 보이고 세로 선은 안 보이기. */
	/* 경계선 색상은 직접 table 테그에 직접 설정*/ 
	/*-----------------------------------------------------------------------*/ 
	.tbcss2, .tbcss2 td, .tbcss2 th{ 
		padding:5;
		border-collapse:collapse;  
		
		border-top:0px solid  ${trBgColor_head};
		border-bottom:0px solid ${trBgColor_head}; 		
		border-left:0px;
		border-right:0px;
		
		font-size: 9pt;
		font-family: tahoma,굴림,돋움,verdana;  
			
		/* 
		border-spacing:0;
		border-collapse:collapse;  
		border:0px;
		font-size: 9pt;
		font-family: tahoma,굴림,돋움,verdana; 
		*/
	}
	.tbcss2 th{ 
		background-color:${trBgColor_head};
		color:${trFontColor_head};
	}
	
	
	
	/*-----------------------------------------------------------------------*/ 
	/* 홀수행 짝수행 백경색 지정*/ 
	/*-----------------------------------------------------------------------*/ 
	/*
	.tbcss2 tr:not(.addedTr):nth-child(odd){ background-color:${trBgColor_odd}; }
	.tbcss2 tr:not(.addedTr):nth-child(even){ background-color:${trBgColor_even}; }  
	*/
	
	
	
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













