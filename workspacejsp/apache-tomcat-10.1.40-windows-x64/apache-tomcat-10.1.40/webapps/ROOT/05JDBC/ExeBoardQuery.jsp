<%@page import="java.util.Date"%>
<%@page import="common.DBConnPool"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board 데이터 출력하기</title>
</head>
<style>
	table, td, th{
		border : 1px solid black;
		border-collapse: collapse;
	}
</style>
<body>
<h2>게시판 목록 조회</h2>
	<%
		DBConnPool jdbc = new DBConnPool();
		String sql = "SELECT * FROM board";
		jdbc.psmt = jdbc.con.prepareStatement(sql);
		jdbc.rs = jdbc.psmt.executeQuery();
	%>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<% while(jdbc.rs.next()){
			int num = jdbc.rs.getInt("num");
			String title = jdbc.rs.getString("title");
			String content = jdbc.rs.getString("content");
			String id = jdbc.rs.getString("id");
			Date postDate = jdbc.rs.getDate("postdate");
			int visitCount = jdbc.rs.getInt("visitcount");
		%>	
		<tr>
			<td><%=num %></td>
			<td><%=title %></td>
			<td><%=content %></td>
			<td><%=id %></td>
			<td><%=postDate %></td>
			<td><%=visitCount %></td>
		</tr>
		<%} %>
	</table>
	<%jdbc.close();%>
</body>
</html>




