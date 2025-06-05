<%@page import="common.JDBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록 조회</title>
</head>
<body>
	<h2>회원 목록 조회</h2>
	<%
		JDBConnect jdbc = new JDBConnect();
		//Statment사용시 ?를 사용할ㅇ 수 없어sql문을 처음부터 완전하게 만들어야함
		String sql = "SELECT id, pass, name, regidate FROM member";
		jdbc.stmt = jdbc.con.createStatement();
		//Statment의 경우 실행시 sql을 설정함
		jdbc.rs = jdbc.stmt.executeQuery(sql);
		
		//rs에 select문의 결과가 들어있고
		//rs.next()를 이용하여 데이터가 있는지 확인하고 그 데이터를 사용할 수 있도록 합니다.
		while(jdbc.rs.next()){
			//rs.getString(1) : 1을 적으면 첫번째 열인 id의 데이터를 반환
			String id = jdbc.rs.getString(1);
			//2을 적으면 첫번째 열인 pass의 데이터를 반환
			String pw = jdbc.rs.getString(2);
			//name을 적으면 name열의 데이터를 반환
			String name = jdbc.rs.getString("name");
			//regidate을 적으면 regidate열의 데이터를 반환
			java.sql.Date regidate = jdbc.rs.getDate("regidate");
			
			out.println(String.format("%s %s %s %s",id, pw, name, regidate)+ "<br/>");
		}
		jdbc.close();
	%>
</body>
</html>












