joinus<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
		<div id="header">
			<div class="top-wrapper">
				<h1 id="logo"><a href="${pageContext.request.contextPath}/index.htm"><img src="${pageContext.request.contextPath }/images/logo.png" alt="" /></a></h1>
				<h2 class="hidden">���θ޴�</h2>
				<ul id="mainmenu" class="block_hlist">
					<li>
						<a href="">�н����̵�</a>
					</li>
					<li>
						<a href="" >��������</a>
					</li>
					<li>
						<a href="" >�α����</a>
					</li>
				</ul>
				<form id="searchform" action="" method="get">
					<fieldset>
						<legend class="hidden">
							�����˻���
						</legend>
						<label for="query">�����˻�</label>
						<input type="text" name="query" />
						<input type="submit" class="button" value="�˻�" />
					</fieldset>
				</form>
				<h3 class="hidden">�α��θ޴�</h3>
				<ul id="loginmenu" class="block_hlist">
					<li>
						<a href="${pageContext.request.contextPath}/index.htm">HOME</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/joinus/login.htm">�α���</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/joinus/join.htm">ȸ������</a>
					</li>
				</ul>
				<h3 class="hidden">ȸ���޴�</h3>
				<ul id="membermenu" class="clear">
					<li>
						<a href=""><img src="${pageContext.request.contextPath }/images/menuMyPage.png" alt="����������" /></a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/customer/notice.htm"><img src="${pageContext.request.contextPath }/images/menuCustomer.png" alt="������" /></a>
					</li>
				</ul>
			</div>
		</div>