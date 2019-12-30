<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<script type="text/javascript">
function ser(){
	window.alert("서비스 준비중입니다");
};

</script>
	<!-- 퀵메뉴 -->
    <div class="quickBox">
        <ul>
            <li><a href="https://www.facebook.com/codingplus2017" target="_blank">페이스북</a></li>
            <li><a href="https://www.instagram.com/codingplus2017/" target="_blank">인스타그램</a></li>
            <li><a href="https://blog.naver.com/wlrhks815" target="_blank">블로그</a></li>
            <li><a href="https://www.youtube.com/channel/UCdZWEY6VWFdYjP8QET3_6aQ" target="_blank">유튜브</a></li>
            <li><a href="javascript:" onclick="fnMove()">상담하기</a></li>
            <li class="topBtn"><a href="#">맨위로</a></li>
        </ul>
    </div>
	<!-- //퀵메뉴 -->
	<script type="text/javascript">
		$('.topBtn').click(function(){
			$('body,html').animate({
				scrollTop:0
			}, 400);
			
			return false;
		});
	</script>
	<script>
		function fnMove(){
			var offset = $(".olym_advice").offset();
			$('html,body').animate({scrollTop:offset.top - 90},600);
			
			return false;
		} 
	</script>
