<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장객체 - request</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		// radio의 경우 선택괸 데이터만 받음
		String gender = request.getParameter("gender");
		// 체크박스의 경우 getParameterValues를 이용하여 String배열로 데이터를 받을 수 있음.
		String[] favo = request.getParameterValues("favo");
		String favoStr = "";
		
		if(favo != null){
			for(int i=0; i< favo.length; i++){
				favoStr += favo[i] + " ";
			}
		}
		// HTML에서 엔터키를 출력할 수 잇도록 \r\n을  br태그로 변경해서 출력
		String intro = request.getParameter("intro").replace("\r\n","<br/>");
	%>
	<ul>
		<li>아이디 : <%= id %></li>
		<li>성별 : <%= gender %></li>
		<li>관심사항 : <%= favoStr %></li>
		<li>자기소개 : <%= intro %></li>
	</ul>
</body>
</html>