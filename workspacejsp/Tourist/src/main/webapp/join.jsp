<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title> 회원가입 | 투어리스트인투어 </title>
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="css/common.css">
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/common.js"></script>  
<script src="js/jquery.smooth-scroll.min.js"></script> 
<!--[if lte IE 9]>
    <script src="js/html5shiv.js"></script>
	<script src="js/placeholders.min.js"></script>
<![endif]-->
</head>

<body>
<ul class="skipnavi">
    <li><a href="#container">본문내용</a></li>
</ul>
<!-- wrap -->
<div id="wrap">
	
	<%-- <jsp:include page="Header.jsp" /> --%>
	<%@ include file="Header.jsp" %>
	
	<div id="container">
		<!-- location_area -->
		<div class="location_area member">
			<div class="box_inner">
				<h2 class="tit_page">TOURIST <span class="in">in</span> TOUR</h2>
				<p class="location">MEMBER <span class="path">/</span> 회원가입</p>
				<ul class="page_menu clear">
					<li><a href="javascript:;" class="on">회원가입</a></li>
				</ul>
			</div>
		</div>	
		<!-- //location_area -->

		<!-- bodytext_area -->
		<form action="LoginProcess.jsp" method="POST">
			<div class="bodytext_area box_inner">
				<!-- login-wrap -->
				<div class="login_wrap">
					<h1 class="loginTit"><a href="index.jsp"><img src="img/tit_login.png" alt="TOURIST IN TOUR" /></a></h1>
					<ul class="login_list">
						<li><%=request.getAttribute("loginErrMsg")==null?
								"" : request.getAttribute("loginErrMsg")%></li>
						<li><input type="text" name="id" size="32" placeholder="아이디"></li>
						<li><input type="password" name="pw" size="32" placeholder="비밀번호"></li>
						<li><button type="submit" class="btn_srch">로그인</button></li>
						<input type="hidden" id="autologin" value="off">
						<!-- <li class="kakao"><a href="javascript:;"><strong>카카오톡</strong> 로그인</a></li>
						<li class="naver"><a href="javascript:;"><strong>네이버</strong> 로그인</a></li>
						<li class="facebook"><a href="javascript:;"><strong>페이스북</strong> 로그인</a></li>
						<li class="cellphone"><a href="javascript:;"><strong>이메일 주소</strong> 로그인</a></li> -->
					</ul>
					
					<div class="btnonoff_line">
						<div class="switch"></div>
						<p>
							<a href="#" class="btn_onoff" onclick="return false;">로그인 유지</a>
						</p>
					</div>
							
				</div>
				<!-- //login-wrap -->
			</div>
		</form>
		<!-- //bodytext_area -->

	</div>
	<!-- //container -->

	<footer>
		<div class="foot_area box_inner">
			<ul class="foot_list clear">
				<li><a href="javascript;">이용약관</a></li>
				<li><a href="javascript;">개인정보취급방침</a></li>
			</ul>
			<h2>투어리스트인투어</h2>
			<p class="addr">서울특별시 종로구 혜화동 9길 청운빌딩 5층 <span class="gubun">/</span>        
				<span class="br_line">대표전화 <span class="space0">02-1234-5678</span> <span class="gubun">/</span>        
					<span class="br_line">E-mail : <span class="space0"> titour@touristintour.com</span></span>
				</span>
			</p>
			<p class="copy box_inner">Copyright(c) TouristInTour all right reserved</p>
			<ul class="snslink clear">
				<li><a href="javascript:;">blog</a></li>
				<li><a href="javascript:;">facebook</a></li>
				<li><a href="javascript:;">instargram</a></li>
			</ul>
		</div>
	</footer>

</div>
<!-- //wrap -->

<h2 class="hdd">빠른 링크 : 전화 문의, 카카오톡, 오시는 길, 꼭대기로</h2>
<div class="quick_area">
	<ul class="quick_list">
		<li><a href="tel:010-7184-4403"><h3>전화 문의</h3><p>010-1234-5678</p></a></li>
		<li><a href="javascript:;"><h3>카카오톡 <em>상담</em></h3><p>1:1상담</p></a></li>
		<li><a href="javascript:;"><h3 class="to_contact">오시는 길</h3></a></li>
	</ul>
	<p class="to_top"><a href="#layout0" class="s_point">TOP</a></p>
</div>

</body>
</html>
