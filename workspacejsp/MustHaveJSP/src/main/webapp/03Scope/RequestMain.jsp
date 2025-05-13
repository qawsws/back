<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.Person" %>
<%
	request.setAttribute("requestString", "request 영역의 문자열"); 
	request.setAttribute("requestPerson", new Person("안중근", 31));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request 영역</title>
</head>
<body>
	<h2>request 영역의 속성값 삭제하기</h2>
	<%	
		//request에저장된 속성 삭제하기
		request.removeAttribute("requestString");
		// request에 속성이 없어도 에러가 나지는 않는다.
		request.removeAttribute("requestInteger");
	%>
	<h2>request 영역의 속성값 읽기</h2>
	<%
		Person rPerson = (Person)(request.getAttribute("requestPerson"));
	%>
	<ul>
		<li>String객체 : <%=request.getAttribute("requestString") %></li>
		<li>Person객체 : <%=rPerson.getName() %>, <%=rPerson.getAge() %>
	</ul>
	<%
		// forward의 경우 request의 데이터와 parameter데이터를 전달할 수 있음.
		request
		.getRequestDispatcher("RequestForward.jsp?han=한글&eng=영어")
		.forward(request, response);
		// sendRedirect의 경우 parameter데이터만 전달할 수 있음.
		//response.sendRedirect("RequestForward.jsp?han=한글&eng=영어");
	%>
</body>
</html>
















