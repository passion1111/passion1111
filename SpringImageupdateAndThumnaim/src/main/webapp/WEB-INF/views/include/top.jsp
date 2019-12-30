<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<script type="text/javascript">
function ser(){
	window.alert("서비스 준비중입니다");
};

</script>
	<!-- 탑메뉴 영역 -->
	<div class="top_Menu_wrap">
		<div class="top_Menu">
			<!-- 지역영역 -->
			<div class="k">
				<h3>지역별</h3>
				<ul>
					<li class="ktxt_1"><a href="../main/mokdong.do" tabindex="12">목동점</a></li>
					<li class="ktxt_2"><a href="../main/sangdo.do" tabindex="13">상도점</a></li>
				</ul>
			</div>
			<!-- //지역영역 -->
			<!-- sns영역 -->
			<div class="sns">
				<h3>소셜네트워킹</h3>
				<ul>
					<li class="facebook"><a href="https://www.facebook.com/codingplus2017" target="_blank" tabindex="14">페이스북</a></li>
					<li class="instar"><a href="https://www.instagram.com/codingplus2017/" target="_blank" tabindex="15">인스타그램</a></li>
					<li class="blog"><a href="https://blog.naver.com/wlrhks815" target="_blank" tabindex="16">블로그</a></li>
					<li class="youtube"><a href="https://www.youtube.com/channel/UCdZWEY6VWFdYjP8QET3_6aQ" target="_blank" tabindex="17">유튜브</a></li>
				</ul>
			</div>
			<!-- //sns영영 -->
			<!-- 멤버십영역 -->
			<div class="join">
				<h3>멤버십</h3>
				<%
					String userName = (String)request.getParameter("userName");
					if(userName.equals(""))
					{
				%>
					<ul>
						<li><a href="#layer2" class="btn-example" tabindex="8">로그인</a></li>
						<li><a href="../join/joinClause.do">회원가입</a></li>
					</ul>
				<%
					}else{
				%>
					<ul>
						<li><%=userName%></li>
						<li><a href="<c:url value="/login/logout.do"/>" id="logout">로그아웃</a></li>
					</ul>
				<%
					}
				%>
			</div>
		<!-- 멤버십 영역 -->
		</div>
	</div>
	<!-- //탑메뉴 영역 -->

	<!-- 상단영역 -->
	<div class="header_wrap">
		<header id="header">
			<!-- 코딩플러스 로고 -->
			<h1><a href="../main/main.do">코딩플러스</a></h1>
			<!-- //코딩플러스 로고 -->

			<!-- 내비게이션 영역 -->
			<nav class="gnbnav" id="gnbnav">
				<h2>주요메뉴</h2>
				<ul class="gnb_cont">
					<li class="gnb-title"><a href="../introduction/introduction.do">
						<span></span>코딩플러스소개</a>
					</li>
					<li class="gnb-title"><a href="../curriculum/codingBeginner.do">
						<span></span>교육과정</a>
					</li>
					<li class="gnb-title"><a href="../teacher/teacherList.do">
						<span></span>강사소개</a>
					</li>
					<li class="gnb-title"><a href="../notice/noticeList.do">
						<span></span>공지사항</a>
					</li>
					<li class="gnb-title"><a href="../archive/archiveList.do">
						<span></span>커뮤니티</a>
					</li>
					<li class="gnb-title"><a href="../olympiad/olympiad01.do">
						<span></span><img src="<c:url value="/resources/images/olymGold.jpg"/>" alt="올림피아드 메달">올림피아드</a>
					</li>
				</ul>
			</nav>
			<!-- //내비게이션 영역 -->
			<!-- 로그인 팝업 -->
			<div class="dim-layer">
				<div class="dimBg"></div>
				<div id="layer2" class="pop-layer">
					<div class="pop-container">
						<div class="pop-conts">
							<!--content //-->
							<div class="login_box">
								<p>코딩플러스 로그인</p>
							</div>
<%-- 							<div class="login_api">
								<p>사용하시는 소셜계정으로 간편로그인하세요!</p>
								<ul>
									<li class="naver_api" tabindex="60">
										<label>
											<img src="<c:url value="/resources/images/login_naver_ico.jpg"/>" alt="네이버로 로그인">
										</label>
										<span>네이버 아이디로 로그인하기</span>
									</li>
									<li class="facebook_api" tabindex="61">
										<label><img src="<c:url value="/resources/images/login_facebook_ico.jpg"/>" alt="페이스북으로 로그인"></label>
										<span>페이스북 아이디로 로그인하기</span>
									</li>
									
									<li class="kakao_api" tabindex="62">
										<label><img src="<c:url value="/resources/images/login_kakao_ico.jpg"/>" alt="카카오톡으로 로그인"></label>
										<span>카카오톡 아이디로 로그인하기</span>
									</li>
								</ul>
							</div> --%>
<!-- 							<div class="login_api">
								<ul>
									<li>
										<a id="kakao-login-btn"></a>
									</li>
								</ul>
							</div>
							<script type="text/javascript">
							// 사용할 앱의 JavaScript 키를 설정해 주세요.
							Kakao.init('48bb049e38014e3934144ce6ceea82db');
							// 카카오 로그인 버튼을 생성합니다.
							Kakao.Auth.createLoginButton({
								container: '#kakao-login-btn',
								success: function(authObj){
									// 로그인 성공시, API를 호출합니다.
									Kakao.API.request({
										url: '/v1/user/me',
										success: function(res){
											console.log(JSON.stringify(res.kaccount_email));
											console.log(JSON.stringify(res.id));
											console.log(JSON.stringify(res.properties.profile_image));
											console.log(JSON.stringify(res.properties.nickname));
											alert(JSON.stringify(res.id));
											alert(JSON.stringify(res.kaccount_email));
											alert(JSON.stringify(res.properties.profile_image));
											alert(JSON.stringify(res.properties.nickname));
										},
										fail: function(error){
											alert(JSON.stringify(error));
										}
									});
								},
								fail: function(err){
									alert(JSON.stringify(err));
								}
							});
							</script> -->
							<div class="login_br">
								<p>코딩플러스에 가입하신 아이디로 로그인하세요!</p>
								<form action="" method="post" id="loginFrm" name="loginFrm">
									<fieldset>
										<legend>로그인</legend>
										<div class="idx_login">
											<label>아이디</label>
											<input type="text" tabindex="63" id="uid" name="uid" placeholder="이메일(아이디)">
										</div>
										<div class="pwd_login">
											<label>비밀번호</label>
											<input type="password" tabindex="64" id="pwd" name="pwd" placeholder="비밀번호" onkeypress="javascript:fn_enter()"/>
										</div>
										<button type="button" tabindex="65" onclick="fn_submit()">로그인</button>
									</fieldset>
								</form>
							</div>
							<div class="pop_join">
								<a href="../join/joinClause.do" tabindex="66">회원가입</a>
								<a href="../login/findId_PW.do" tabindex="67">아이디/비밀번호 찾기</a>
							</div>
								<a href="#" class="btn-d" tabindex="68">닫으실려면 배경을 클릭해주세요!</a>
							<!--// content-->
						</div>
					</div>
				</div>
			</div>
		</header>
	</div>
	<!-- //상단영역 -->
