<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력하기</title>
</head>
<body>
	<!-- 1~9단까지의 구구단 출력하기 -->
	<!--  
	<p>2 * 1 = 2</p>
	<p>2 * 2 = 4</p>
	-->
	<h1>1~9단까지의 구구단 출력하기</h1>
	<%
		for(int i = 2; i <= 9; i++){
			for (int j = 1; j <= 9; j++) {
				out.print(i +" * "+ j +" = "+(i*j)+"<br>");
			}
		}
	%>
</body>
</html>