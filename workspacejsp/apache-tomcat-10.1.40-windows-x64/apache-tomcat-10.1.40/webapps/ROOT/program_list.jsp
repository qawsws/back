<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="program.dto.ProgramDTO" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <title>프로그램 소개 | 상품투어 | 투어리스트인투어</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="css/common.css">
    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/common.js"></script>  
    <script src="js/jquery.smooth-scroll.min.js"></script> 
</head>

<body>
<ul class="skipnavi">
    <li><a href="#container">본문내용</a></li>
</ul>
<div id="wrap">

   	<%@ include file="Header.jsp" %>

    
    <div id="container">
        <div class="location_area package">
            <div class="box_inner">
                <h2 class="tit_page">TOURIST <span class="in">in</span> TOUR</h2>
                <p class="location">상품투어 <span class="path">/</span> 프로그램 소개</p>
                <ul class="page_menu clear">
                    <li><a href="program.do" class="on">프로그램 소개</a></li>
                    <li><a href="#">여행 자료</a></li>
                </ul>
            </div>
        </div>    

        <div class="bodytext_area place_area box_inner">
            <ul class="program_list clear">
                <%
                   List<ProgramDTO> programList = (List<ProgramDTO>) request.getAttribute("programList");
                   if (programList == null || programList.isEmpty()) {
                %>
                   <li>등록된 프로그램이 없습니다.</li>
                <%
                  } else {
                     for (ProgramDTO p : programList) {
                          String imagePath = (p.getImg() != null && !p.getImg().isEmpty()) ? p.getImg() : "images/noimage.png";
                          String title = (p.getTitle() != null) ? p.getTitle() : "제목 없음";
                          String schedule = (p.getSchedule() != null) ? p.getSchedule() : "기간 정보 없음";
                          String description = (p.getText() != null) ? p.getText() : "";
                          int id = p.getId();
                %>
                    <li>
                        <a href="program_detail.jsp?id=<%= id %>">
                         <img class="img_place" src="img/<%= imagePath %>" alt="<%= title %>">
                         <h3><%= title %></h3>
                         <p class="subttl"><%= schedule %></p>
                         <div class="program_content">
                          <p><%= description %></p>
                            </div>
                        </a>
                        <p class="btn_more"><a href="javascript:;">더보기</a></p>
                        <button type="button" onclick="saveProgramName('<%= title.replace("'", "\\'") %>')">저장</button>
                    </li>
                <%
                        }
                    }
                %>
            </ul>
        </div>
    </div>

    <footer>
        <div class="foot_area box_inner">
            <ul class="foot_list clear">
                <li><a href="#">이용약관</a></li>
                <li><a href="#">개인정보취급방침</a></li>
            </ul>
            <h2>투어리스트인투어</h2>
            <p class="addr">서울특별시 종로구 혜화동 9길 청운빌딩 5층 <span class="gubun">/</span>        
                <span class="br_line">대표전화 <span class="space0">02-1234-5678</span> <span class="gubun">/</span>        
                <span class="br_line">E-mail : <span class="space0"> titour@touristintour.com</span></span>
                </span>
            </p>
            <p class="copy box_inner">Copyright(c) TouristInTour all right reserved</p>
            <ul class="snslink clear">
                <li><a href="#">blog</a></li>
                <li><a href="#">facebook</a></li>
                <li><a href="#">instagram</a></li>
            </ul>
        </div>
    </footer>

</div>

<div class="quick_area">
    <ul class="quick_list">
        <li><a href="tel:010-7184-4403"><h3>전화 문의</h3><p>010-1234-5678</p></a></li>
        <li><a href="#"><h3>카카오톡 <em>상담</em></h3><p>1:1상담</p></a></li>
        <li><a href="#"><h3 class="to_contact">오시는 길</h3></a></li>
    </ul>
    <p class="to_top"><a href="#wrap" class="s_point">TOP</a></p>
</div>

<script>
    function saveProgramName(programName) {
        const days = 7;
        const expires = new Date();
        expires.setTime(expires.getTime() + days * 24 * 60 * 60 * 1000);
        document.cookie = "savedProgram=" + encodeURIComponent(programName) + ";expires=" + expires.toUTCString() + ";path=/";
        alert(programName + " 저장되었습니다d.");
    }
</script>

</body>
</html>
