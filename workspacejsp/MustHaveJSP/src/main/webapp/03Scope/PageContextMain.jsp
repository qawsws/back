<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.Person" %>
<%
//page영역에 데이터를 key, value형식으로 저장
pageContext.setAttribute("pageInteger", 1000);
pageContext.setAttribute("pageString", "페이지 영역의 문자열");
pageContext.setAttribute("pagePerson", new Person("한석봉",99));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page 영역 속성값 읽기</title>
</head>
<body>
	<h2>page 영역 속성값 읽기</h2>
	<%
	//getAttribute(key) : page영역에 key맞는 데이터를 반환합니다.
	//캐스팅을 해야 변수에 저장 가능
	int pInteger = (Integer)(pageContext.getAttribute("pageInteger"));
	String pString = (String)(pageContext.getAttribute("pageString"));
	Person pPerson = (Person)(pageContext.getAttribute("pagePerson"));
	%>
	<ul>
		<li>Integer 객체 : <%=pInteger %></li>
		<li>String 객체 : <%=pString %></li>
		<li>Person 객체 : <%=pPerson.getName() %>,<%=pPerson.getAge()%></li>
	</ul>
	<h2>include된 파일에서 page 영역 읽어오기</h2>
	<!-- page영역에 저장한 데이터는 include한 페이지에서도 사용할 수 있음 -->
	<%@ include file="PageInclude.jsp" %>
	<h2>페이지 이동 후 page 영역 읽어오기</h2>
	<a href="PageLocation.jsp">PageLocation.jsp</a>
</body>
</html>













