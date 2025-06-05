<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테이블로 태그로 출력하는 구구단</title>
<style>
	table, td{
	border: 1px solid black;
	border-collapse: collapse;
	}
</style>
</head>
<body>
<table>
	
			<%for (int i = 2; i <= 9; i++) {%>
			<tr>
				<%for (int j = 1; j <= 9; j++) {%>
					<td><%= (i + " * " + j + " = " + (i * j) )%></td>
					<%}%>
				</tr>
			<% }%>
		</tr>
</table>
</body>
</html>