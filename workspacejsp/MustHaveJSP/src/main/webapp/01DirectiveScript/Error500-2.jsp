<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="IsErrorPage.jsp"%>
 <!-- 에러 발생시 errorPage속성에 설정한 페이지로 이동하게됨 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page 지시어 - errorPage, isErrorPage 속성</title>
</head>
<body>
	<%
		// 에러 발생시 jsp에서 지원하는 에러 페이지가 출력되며 에러의 내용 및 원인을 모두 출력한다.
		// jsp에러 페이지를 출력하지 않으려면 try/catch문 혹은 errorpage설정을 해야합니다.
	
		int myAge = Integer.parseInt(request.getParameter("age"))+10;
		out.println("10년 후 당신의 나이는"+myAge+"입니다.");
		
	%>
</body>
</html>