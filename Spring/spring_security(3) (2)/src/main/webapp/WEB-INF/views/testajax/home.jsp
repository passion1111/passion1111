<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Home</title>
</head>
<script
        src="https://code.jquery.com/jquery-3.5.1.js"
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
        crossorigin="anonymous"></script>
<body>

<h1>Home!</h1>

<sec:authorize access="isAnonymous()">
<p><a href="<c:url value="/login/loginForm.do" />">로그인</a></p>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="로그아웃" />
</form:form>
</sec:authorize>

<h3>
ajaxtest page
</h3>

<input type="button" value="눌러ajax" onclick="ajaxtest()">
<Script>
    ajaxtest()
    function ajaxtest(){




    // $.ajax({
    //     type: "get",
    //     beforeSend : function(jqXHR) {
    //         console.log(jqXHR);
    //         jqXHR.setRequestHeader("AJAX", true);
    //     },
    //     url: "/testajax2",
    //     data: "data",
    //     dataType: "text",
    //     success: function (response) {
    //         console.log(response)
    //         console.log("test34")
    //     },error:function(response){
    //         console.log(response,"에러")
    //     }
    // });
        $.ajax({
            beforeSend : function(jqXHR) {
                console.log(jqXHR);
                jqXHR.setRequestHeader("AJAX", true);
            },
            url: "/testajax2",
            data: "data",
            dataType: "text",
            type : 'get',
            success : function(data) {
    console.log(data)
            },
            error : function(jqXHR) {
                if (jqXHR.status == 401) {
                    //alert("401");
                } else if (jqXHR.status == 403) {
                    alert("로그인을 하셔야 댓글을 쓸 수 있습니다.");
                    location.replace('../loginforms');
                } else {
                    alert("예외가 발생했습니다. 관리자에게 문의하세요.");
                }
            }
        });


    }
</Script>
</body>
</html>
