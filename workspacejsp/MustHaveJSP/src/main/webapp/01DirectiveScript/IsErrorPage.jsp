<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러페이지</title>
</head>
<body>
	<h2>서비스 중 일시적인 오류가 발생했습니다.  </h2>
	<p>
	 	오류명 : <%= exception.getClass().getName() %>
	 	오류 메시지 : <%= exception.getMessage() %>
	 	</p>
</body>
</html>