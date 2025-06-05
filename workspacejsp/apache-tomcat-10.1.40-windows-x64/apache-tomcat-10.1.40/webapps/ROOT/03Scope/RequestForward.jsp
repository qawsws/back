<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forward 실행</title>
</head>
<body>
	<h2>forward를 이용한 request 영역의 속성값 읽기</h2>
	<%
		Person rPerson = (Person)(request.getAttribute("requestPerson"));
	%>
	<ul>
		<li>String객체 : <%=request.getAttribute("requestString") %></li>
		<li>Person객체 : <%=rPerson.getName() %>, <%=rPerson.getAge() %>
	</ul>
	<h2>매개변수로 전달된 값 출력하기</h2>
	<%
		request.setCharacterEncoding("UTF-8");
		out.print(request.getParameter("han"));
		out.print(request.getParameter("eng"));
	%>
</body>
</html>





