<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelloServlet</title>
</head>
<body>
	<h2>Web.xml 에서 매핑 후 JSP에서 출력하기</h2>
	<p>
		<strong><%=request.getAttribute("message") %></strong>
		<br />
		<a href="/MustHaveJSP/12Servlet/HelloServlet.do">바로가기</a>
	</p>
</body>
</html>