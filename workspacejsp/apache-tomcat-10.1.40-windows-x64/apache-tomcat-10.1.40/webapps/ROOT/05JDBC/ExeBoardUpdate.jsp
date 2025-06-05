<%@ page import="common.JDBConnect" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board 데이터 추가하기</title>
</head>
<body>
	<h2>Board 추가 테스트 </h2>
	<%
	JDBConnect jdbc = new JDBConnect();
	

	String title = "제목2";
	String content="내용2";
	String id =  "test1";

	
	String sql = "INSERT INTO BOARD VALUES (SEQ_BOARD_NUM.NEXTVAL,?,?,?,sysdate,0)";
	jdbc.psmt = jdbc.con.prepareStatement(sql);
	

	jdbc.psmt.setString(1, title);
	jdbc.psmt.setString(2, content);
	jdbc.psmt.setString(3, id);
	
	int inResult = jdbc.psmt.executeUpdate();
	out.print(inResult + "행이 입력되었습니다");
	
	jdbc.close();
	%>
</body>
</html>