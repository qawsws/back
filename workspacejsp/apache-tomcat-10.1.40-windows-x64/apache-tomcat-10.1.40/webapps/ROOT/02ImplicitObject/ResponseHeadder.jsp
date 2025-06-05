<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Collection" %>
<% 
	SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	// 문자열 데이터를 시간 데이터로 변경하여 저장 : 1970-01-01 00:00:00 초 부터의 경과시간
	long add_date = s.parse(request.getParameter("add_date")).getTime();
	//문자열 데이터를 숫자로 변경하여 저장
	int add_int = Integer.parseInt(request.getParameter("add_int"));
	//문자열 데이터를 String에 변환 없이 저장
	String add_str = request.getParameter("add_str");
	
	//response의 헤더에 데이터를 저장
	response.addDateHeader("myBirthday", add_date);
	// myNumber라는 이름의 헤더에 8282, 1004번 둘다 저장
	response.addIntHeader("myNumber", add_int);
	response.addIntHeader("myNumber", 1004);
	//addHeader를 사용하여 홍길동, 손오공 둘다 저장
	response.addHeader("myName",add_str);
	response.addHeader("myName","손오공");
	//setHeader를 사용하여 데이터를 수정 할 수 있음.
	response.setHeader("myName", "전유치");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장객체 - response data</title>
</head>
<body>
	<h2>응답 헤더 정보 출력하기</h2>
	<%Collection<String> headerNames = response.getHeaderNames();
		for(String hName : headerNames){
			//getHeader() : 첫번째 데이터만 출력하기 때문에 8282랑 홍길동이 두번 출력됨
			String hValue = response.getHeader(hName);%>
			<li><%=hName %> : <%=hValue %></li>
		<%} %>
		<!-- getHeaders()를 사용하여 헤더 안에있는 데이터를 저장 -->
	<%Collection<String> myNumber = response.getHeaders("myNumber");
		//반복문을 이용하여 각각의 데이터를 출력
		for(String myNum : myNumber){%>
			<li>myNumber : <%=myNum %></li>
		<%} %>
</body>
</html>
























