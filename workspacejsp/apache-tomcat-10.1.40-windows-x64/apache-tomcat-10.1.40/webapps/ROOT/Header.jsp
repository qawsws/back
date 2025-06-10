<%@page import="member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header id="header">
		<div class="header_area box_inner clear">	
			<h1><a href="./">Tourist in tour</a></h1>
			<p class="openMOgnb"><a href="#"><b class="hdd">메뉴열기</b> <span></span><span></span><span></span></a></p>
			<!-- header_cont -->
			<div class="header_cont">
				<ul class="util clear">
					<%if(session.getAttribute("userDTO")!=null){ %>
					<li>
						<span style="color:white;">
						<%=((MemberDTO)session.getAttribute("userDTO")).getName() %>님 환영합니다.
						</span>
					</li>
					<%} %>
					<li>
						<%if(session.getAttribute("userDTO")==null){ %>
							<a href="./login.do">로그인</a>
						<%}else{ %>
							<a href="./logout.do">로그아웃</a>
						<%} %>
					</li>
					<li><a href="./join.do">회원가입</a></li>
				</ul>		
				<nav>
				<ul class="gnb clear">
					<li><a href="javascript:;" class="openAll1">여행정보</a>

                        <div class="gnb_depth gnb_depth2_1">
                            <ul class="submenu_list">
                                <li><a href="javascript:;">국내</a></li>
                                <li><a href="javascript:;">해외</a></li>
                            </ul>
                        </div>
					</li>
					<li><a href="javascript:;" class="openAll2">고객센터</a>
				        <div class="gnb_depth gnb_depth2_2">
                            <ul class="submenu_list">
                                <li><a href="./boardlist.do">공지사항</a></li>
                                <li><a href="javascript:;">문의하기</a></li>
                            </ul>
                        </div>
					</li>
					<li><a href="javascript:;" class="openAll3">상품투어</a>
                        <div class="gnb_depth gnb_depth2_3">
                            <ul class="submenu_list">
                                <li><a href="/program.do">프로그램 소개</a></li>
                                <li><a href="javascript:;">여행자료</a></li>
                            </ul>
                        </div>
					</li>
					<li><a href="javascript:;" class="openAll4">티켓/가이드</a>
                        <div class="gnb_depth gnb_depth2_4">
                            <ul class="submenu_list">
                                <li><a href="javascript:;">항공</a></li>
                                <li><a href="javascript:;">호텔</a></li>
                            </ul>
                        </div>
					</li>
				</ul>
                </nav>
				<p class="closePop"><a href="javascript:;">닫기</a></p>
			</div>
			<!-- //header_cont -->
		</div>
	</header>