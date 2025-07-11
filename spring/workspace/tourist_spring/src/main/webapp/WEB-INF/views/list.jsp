<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title> 공지사항 | 고객센터 | 투어리스트인투어 </title>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="/css/common.css">
    <script src="/js/jquery-1.11.3.min.js"></script>
    <script src="/js/common.js"></script>
    <script src="/js/jquery.smooth-scroll.min.js"></script>
    <!--[if lte IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/placeholders.min.js"></script>
    <![endif]-->
</head>

<body>
<ul class="skipnavi">
    <li><a href="#container">본문내용</a></li>
</ul>
<!-- wrap -->
<div id="wrap">

    <%@ include file="./Header.jsp" %>

    <div id="container">
        <!-- location_area -->
        <div class="location_area customer">
            <div class="box_inner">
                <h2 class="tit_page">TOURIST <span class="in">in</span> TOUR</h2>
                <p class="location">고객센터 <span class="path">/</span> 공지사항</p>
                <ul class="page_menu clear">
                    <li><a href="#" class="on">공지사항</a></li>
                    <li><a href="#">문의하기</a></li>
                </ul>
            </div>
        </div>
        <!-- //location_area -->

        <!-- bodytext_area -->
        <div class="bodytext_area box_inner">
            <form action="/board/list" method="get" class="minisrch_form">
                <fieldset>
                    <legend>검색</legend>
                    <input type="text" name="keyword" value="${pageRequestDTO.keyword}" class="tbox" title="검색어를 입력해주세요" placeholder="검색어를 입력해주세요">
                    <button class="btn_srch">검색</button>
                    <c:if test="${sessionScope.UserId != null}">
                        <a class="btn_srch" href="/board/write">글쓰기</a>
                    </c:if>
                </fieldset>
            </form>
            <table class="bbsListTbl" summary="번호,제목,조회수,작성일 등을 제공하는 표">
                <caption class="hdd">공지사항  목록</caption>
                <thead>
                <tr>
                    <th scope="col">번호</th>
                    <th scope="col">제목</th>
                    <th scope="col">조회수</th>
                    <th scope="col">작성일</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${empty responseDTO.dtoList}">
                        <tr>
                            <td colspan="5" align="center">
                                등록된 게시물이 없습니다^^*
                            </td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="dto" items="${responseDTO.dtoList}" varStatus="loop">
                            <tr>
                                <td>${dto.num}</td>
                                <td class="tit_notice">
                                    <a href="/board/read?num=${dto.num}&${pageRequestDTO.link}">
                                            ${dto.title}
                                    </a>
                                </td>
                                <td>${dto.visitcount}</td>
                                <td>${dto.postdate}</td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>
            <!-- pagination -->
            <div class="pagination">
                <a data-num="1" class="firstpage  pbtn"><img data-num="1" src="/img/btn_firstpage.png" alt="첫 페이지로 이동"></a>
                <c:if test="${responseDTO.prev}">
                    <a data-num="${responseDTO.start-1}" class="prevpage  pbtn"><img data-num="${responseDTO.start-1} src="/img/btn_prevpage.png" alt="이전 페이지로 이동"></a>
                </c:if>
                <c:forEach begin="${responseDTO.start}" end="${responseDTO.end}" var="num">
                    <a ><span data-num="${num}" class="pagenum ${responseDTO.page==num ?"currentpage":""}">${num}</span></a>
                </c:forEach>
                <c:if test="${responseDTO.next}">
                    <a data-num="${responseDTO.end+1}" class="nextpage  pbtn"><img data-num="${responseDTO.end+1}" src="/img/btn_nextpage.png" alt="다음 페이지로 이동"></a>
                </c:if>
                <a data-num="${responseDTO.last}" class="lastpage  pbtn"><img data-num="${responseDTO.last}" src="/img/btn_lastpage.png" alt="마지막 페이지로 이동"></a>
            </div>
            <!-- //pagination -->

        </div>
        <!-- //bodytext_area -->

    </div>
    <!-- //container -->

    <footer>
        <div class="foot_area box_inner">
            <ul class="foot_list clear">
                <li><a href="javascript:;">이용약관</a></li>
                <li><a href="javascript:;">개인정보취급방침</a></li>
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

<h2 class="hdd">빠른 링크 : 전화 문의,카카오톡,오시는 길,꼭대기로</h2>
<div class="quick_area">
    <ul class="quick_list">
        <li><a href="tel:010-7184-4403"><h3>전화 문의</h3><p>010-1234-5678</p></a></li>
        <li><a href="javascript:;"><h3>카카오톡 <em>상담</em></h3><p>1:1상담</p></a></li>
        <li><a href="javascript:;"><h3 class="to_contact">오시는 길</h3></a></li>
    </ul>
    <p class="to_top"><a href="#layout0" class="s_point">TOP</a></p>
</div>
<script>
    let msg = '${msg}';
    if(msg!=null && msg.length>0){
        alert(msg);
    }
    document.querySelector(".pagination").addEventListener("click", function(e){
        e.preventDefault();
        const target = e.target;
        if(target.tagName !== 'A' && target.tagName !== 'SPAN' && target.tagName !== 'IMG'){
            return;
        }
        const num = target.getAttribute("data-num");
        const formObj = document.querySelector("form");
        formObj.innerHTML += `<input type='hidden' name='page' value='\${num}'/>`;
        formObj.submit();
    });
</script>
</body>
</html>
